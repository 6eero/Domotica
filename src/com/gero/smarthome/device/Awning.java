package com.gero.smarthome.device;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
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
    

     /**
     * Method to send a command to a device (awnings)
     * @param command the command to send to the light
     * @throws Exception.DeviceOfflineException if the device is offline
     */
    public void send(@NotNull String command) throws Exception.DeviceOfflineException {

        switch (command) {
            case "close the awnings" -> {
                this.setState(this, false);
            }
            case "open the awnings" -> {
                this.setState(this,true);
            }
        }
    }
}
