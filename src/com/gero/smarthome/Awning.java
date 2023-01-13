package com.gero.smarthome;

import com.gero.smarthome.exceptions.ExecutionFailedException;
import org.jetbrains.annotations.NotNull;

public class Awning extends Device {
    private boolean state;

    /**
     * Constructor method to add a new awning to the control panel.
     * The new awning will be closed by default.
     */
    public Awning() {
        this.state = false;
    }


    @Override
    public @NotNull String getState() {
        return state ? "on" : "off";
    }

    /**
     * Method to send a command to a device (awnings)
     * @param command the command to send to the light
     * @throws ExecutionFailedException if the device cannot execute the command
     */
    void sendCommand(@NotNull String command) throws ExecutionFailedException {
        switch (command) {
            case "close" -> state = false;
            case "open" -> state = true;
            default -> throw new ExecutionFailedException("Unknown command");
        }
    }
}
