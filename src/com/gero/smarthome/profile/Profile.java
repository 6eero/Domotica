package com.gero.smarthome.profile;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface Profile {


    /**
     * Method to set a profile to a list of devices
     * @param devicesOfTheProfile the device list
     * @throws Exception.DeviceOfflineException if a device in the lis is offline
     */
    public void impostaProfilo(@NotNull ArrayList<Device> devicesOfTheProfile) throws Exception.DeviceOfflineException;
}
