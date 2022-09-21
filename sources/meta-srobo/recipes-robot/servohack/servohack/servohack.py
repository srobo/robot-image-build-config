#!/usr/bin/env python3
import asyncio
import logging
from json import JSONDecodeError, loads
from typing import Match

from astoria.common.components import StateConsumer
from astoria.common.code_status import CodeStatus
from astoria.common.ipc import ProcessManagerMessage
from pydantic import parse_obj_as

LOGGER = logging.getLogger("servohack")

logging.basicConfig(
    level=logging.INFO,
    format=f"%(asctime)s %(name)s %(levelname)s %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
)

loop = asyncio.get_event_loop()


class ServoHackConsumer(StateConsumer):
    """Restart the USB Hubs when usercode finishes."""

    name = "servohack"

    def _setup_logging(self, verbose: bool, *, welcome_message: bool = True) -> None:
        """Suppress INFO messages from gmqtt."""
        logging.getLogger("gmqtt").setLevel(logging.WARNING)

    def _init(self) -> None:
        """Initialise consumer."""
        self._lock = asyncio.Lock()
        self._code_started = False

        self._mqtt.subscribe("astprocd", self._handle_astprocd_message)

    async def _handle_astprocd_message(
        self,
        match: Match[str],
        payload: str,
    ) -> None:
        """Handle astprocd status messages."""
        try:
            message = parse_obj_as(ProcessManagerMessage, loads(payload))
            if message.status == ProcessManagerMessage.Status.RUNNING:
                LOGGER.debug(f"Received process info: {message}")
                async with self._lock:
                    if message.code_status is CodeStatus.RUNNING:
                        self._code_started = True
                        LOGGER.info("Code has been started")
                    elif message.code_status is None and self._code_started:
                        LOGGER.info("USB removed, toggling USB lines")
                        # Use USB power per-port power switching to toggle USB Power
                        # More information on the USB Hub Architecture of the Raspberry Pi 4
                        # can be found at https://github.com/mvp/uhubctl#raspberry-pi-4b
                        await asyncio.create_subprocess_exec(
                            "/usr/sbin/uhubctl",
                            "--loc", "1-1",  # USB2 hub 1-1, 4 ports ganged, dual to USB3 hub 2
                            "--action", "cycle",  # Toggle the port off and on
                            "--delay", "0.2",
                        )
                        self.code_started = False
            else:
                LOGGER.warn("Cannot get process info, astprocd is not running")
        except JSONDecodeError:
            LOGGER.error("Could not decode JSON manager message.")

    async def main(self) -> None:
        """Main method of the command."""
        LOGGER.info("Servo Hack started.")
        await self.wait_loop()


if __name__ == "__main__":
    consumer = ServoHackConsumer(True, None)
    loop.run_until_complete(consumer.run())
