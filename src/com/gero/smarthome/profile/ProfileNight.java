package com.gero.smarthome.profile;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProfileNight implements Profile {


    private List<Device> devListOfAProfile = new ArrayList<>();

    public ProfileNight(List<Device> devListOfAProfile) {
        this.devListOfAProfile = devListOfAProfile;
    }

    @Override
    public void impostaProfilo(@NotNull ArrayList<Device> devicesOfTheProfile) throws Exception.DeviceOfflineException {

        for (Device device : devicesOfTheProfile) {

            device.setState(device, true);
            device.send("set the lights to minimum brightness");
            device.send("change color to red");
            device.send("close the awnings");
            device.send("close the electric gate");
            device.send("turn on the camera");
        }
    }
}
