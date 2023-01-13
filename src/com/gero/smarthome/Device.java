package com.gero.smarthome;

import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

public abstract class Device {

    private boolean state;
    private boolean onlineStatus;;


    /**
     * Method to get the online status of a device
     * @return true if the dev is online, false otherwise
     */
    public boolean getOnlineStaus() {
        return onlineStatus;
    }


    /**
     * Method to connect a device to the online services
     */
    public void connectToOnlineServices() {
        this.onlineStatus = true;
    }


    /**
     * Method to check if a device is on or off
     * @return true if the device is on, off otherwise
     */
    public boolean getState() {
        return state;
    }


    /**
     * Method to turn on/off a device
     * @param state true to turn on the device, false otherwise
     */
    public void setState(@NotNull Device device, boolean state) throws Exception.DeviceOfflineException {
        if (device.getOnlineStaus()) {
            this.state = state;
        } else {
            throw new Exception.DeviceOfflineException("The device must be online to be turned on!");
        }
    }


    /**
     * Method to send a specific command to a device
     * @param command the command to execute
     * @throws Exception.DeviceOfflineException if the device is offline
     */
    public abstract void send(@NotNull String command) throws Exception.DeviceOfflineException;

}