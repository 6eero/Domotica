package com.gero.smarthome;

import com.gero.smarthome.exceptions.Exception;
import com.gero.smarthome.profile.Profile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlHub implements IControlHub {

    private final List<Device> devicesList = new ArrayList<>();


    /**
     * Method to add a device to the device list of the home
     * @param device the one to add
     */
    @Override
    public void addDeviceToTheHome(@NotNull Device device) {
        devicesList.add(device);
    }


    /**
     * Method to know which device is on and which is off
     * @return two lists, one with the devices on, the other with those off
     */
    @Override
    public Map<String, List<Device>> statoImpianto() {

        Map<String, List<Device>> map = new HashMap<>();
        List<Device> onDevices = new ArrayList<>();
        List<Device> offDevices = new ArrayList<>();

        for (Device device : devicesList) {
            if (device.getState()) {
                onDevices.add(device);
            } else {
                offDevices.add(device);
            }
        }
        map.put("Devices turned on: ",onDevices);
        map.put("Devices turned off: ",offDevices);
        return map;

    }


    /**
     * Method to send a specific command to a device
     * @param device the device which will execute the command
     * @param command the command to execute
     * @throws Exception.DeviceOfflineException if the device is offline
     */
    @Override
    public void inviaComando(@NotNull Device device, @NotNull String command) throws Exception.DeviceOfflineException {
        device.send(command);
    }


    /**
     * Method to activate a profile
     * @param devListOfAProfile device listof the profile
     * @param profilo the profile to activate
     * @throws Exception.DeviceOfflineException if some device in the list is offline
     */
    @Override
    public void attivaProfilo(ArrayList<Device> devListOfAProfile, @NotNull Profile profilo) throws Exception.DeviceOfflineException {
        profilo.impostaProfilo(devListOfAProfile);
    }


    /**
     * Method to connect a device to the online services
     * @param device the device to connect
     */
    @Override
    public void connectToOnlineServices(@NotNull Device device) {
        device.connectToOnlineServices();
    }
}
