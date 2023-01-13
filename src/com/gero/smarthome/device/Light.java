package com.gero.smarthome.device;

import com.gero.smarthome.Device;
import com.gero.smarthome.exceptions.Exception;
import org.jetbrains.annotations.NotNull;

public class Light extends Device {

    private String color;
    private int brightness;


    /**
     * Constructor method to add a new light to the control panel.
     * The new light will be white, with an intensity of 0 since it
     * will be turned off and offline by default.
     */
    public Light() throws Exception.DeviceOfflineException {
        this.color = "white";
        this.brightness = 0;
    }


    /**
     * Method to get the color of a light
     * @return the color
     */
    public String getColor() {
        return color;
    }


    /**
     * Method to get the brightness of a light
     * @return the brightness value
     */
    public int getBrightness() {
        return brightness;
    }


    /**
     * Method to change the color of a light
     * @param color the new color
     */
    public void changeColor(@NotNull String color) {
        this.color = color;
    }


    /**
     * Method to change the brightness of a light
     * @param brightness != null and it must be 0 <= brightness level <= 100.
     *                   it rapresents the new value of the brightness
     */
    public void changeBrightness(int brightness) {
        if (brightness <= 100 && brightness >= 0) {
            this.brightness = brightness;
        }
    }


    /**
     * Method to send a command to a device (light)
     * @param command the command to send to the light
     * @throws Exception.DeviceOfflineException if the device is offline
     */
    @Override
    public void send(@NotNull String command) throws Exception.DeviceOfflineException {

        switch (command) {

            case "on" -> {
                this.setState(this,  true);
            }

            case "off" -> {
                this.setState(this,false);
            }

            case "set the lights to minimum brightness" -> {
                this.changeBrightness(15);
            }

            case "set the lights to maximum brightness" -> {
                this.changeBrightness(100);
            }

            case "change color to white" -> {
                this.changeColor("white");
            }

            case "change color to red" -> {
                this.changeColor("red");
            }

        }
    }

}
