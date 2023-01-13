package com.gero.smarthome.device;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

public class Camera extends Device {

    @Override
    public void send(@NotNull String command) throws Exception.DeviceOfflineException {

        if (command.equals("turn on the camera")) {
            this.setState(this, true);
        }
    }
}
