package com.gero.smarthome.device;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

public class ElectricGate extends Device {

    private boolean state;


    /**
     * Constructor method to add a new light to the control panel.
     * The new light will be white, with an intensity of 0 since it
     * will be turned off and offline by default.
     */
    public ElectricGate() {
        this.state = false;
    }


    /**
     * Method to send a command to a device (gate)
     * @param device the gate
     * @param command the command to send to the gate
     * @throws Exception.DeviceOfflineException if the device is offline
     */
    @Override
    public void send(@NotNull Device device, @NotNull String command) throws Exception.DeviceOfflineException {

        switch (command) {

            case "open the electric gate" -> {
                this.setState(device, true);
            }

            case "close the electric gate" -> {
                this.setState(device,false);
            }

        }
    }
}
