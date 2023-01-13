package com.gero.smarthome;

import com.gero.smarthome.exceptions.*;
import org.jetbrains.annotations.NotNull;

public class ElectricGate extends Device {
    private boolean state;

    public ElectricGate() {
        this.state = false;
    }

    @Override
    public @NotNull String getState() {
        return state ? "opened" : "closed";
    }

    /**
     * Method to send a command to a device (gate)
     * @param command the command to send to the gate
     * @throws ExecutionFailedException if the device is offline
     */
    @Override
    public void sendCommand(@NotNull String command) throws ExecutionFailedException {
        switch (command) {
            case "close" -> state = false;
            case "open" -> state = true;
            default -> throw new ExecutionFailedException("Unknown command");
        }
    }
}
