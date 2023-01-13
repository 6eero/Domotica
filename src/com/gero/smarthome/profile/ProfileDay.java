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
            device.send("set the lights to maximum brightness");
            device.send("change color to white");
            device.send("open the awnings");
            device.send("open the electric gate");
        }
    }
}
