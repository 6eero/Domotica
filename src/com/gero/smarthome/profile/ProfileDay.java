package com.gero.smarthome.profile;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProfileDay implements Profile {


    private List<Device> devListOfAProfile = new ArrayList<>();

    public ProfileDay(List<Device> devListOfAProfile) {
        this.devListOfAProfile = devListOfAProfile;
    }

    @Override
    public void impostaProfilo(@NotNull ArrayList<Device> devicesOfTheProfile) throws Exception.DeviceOfflineException {

        for (Device device : devicesOfTheProfile) {

            device.setState(device, true);
            device.send(device, "set the lights to maximum brightness");
            device.send(device, "change color to white");
            device.send(device, "open the awnings");
            device.send(device, "open the electric gate");
        }
    }
}
