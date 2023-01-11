package com.gero.smarthome.profile;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;

import java.util.ArrayList;
import java.util.List;

public class Profilo {

    private String nome;
    private List<Device> devicesOfTheProfile = new ArrayList<>();

    public Profilo(String nome, List<Device> devicesOfTheProfile) {
        this.nome = nome;
        this.devicesOfTheProfile = devicesOfTheProfile;
    }

    public List<Device> getDevicesOfTheProfile() {
        return devicesOfTheProfile;
    }

    public void profiloGiorno() throws Exception.DeviceOfflineException {
        for (Device device : devicesOfTheProfile) {

            device.setState(device, true);
            device.send(device, "set the lights to maximum brightness");
            device.send(device, "change color to white");
            device.send(device, "open the awnings");
            device.send(device, "open the electric gate");
        }
    }

    public void profiloNotte() throws Exception.DeviceOfflineException {
        for (Device device : devicesOfTheProfile) {

            device.setState(device, true);
            device.send(device, "set the lights to minimum brightness");
            device.send(device, "change color to red");
            device.send(device, "close the awnings");
            device.send(device, "close the electric gate");
        }
    }

    public String getNome() {
        return nome;
    }
}
