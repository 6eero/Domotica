package com.gero;

import com.gero.smarthome.*;
import com.gero.smarthome.device.Camera;
import com.gero.smarthome.exceptions.Exception;
import com.gero.smarthome.device.Awning;
import com.gero.smarthome.device.ElectricGate;
import com.gero.smarthome.device.Light;
import com.gero.smarthome.profile.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception.DeviceOfflineException {

        ControlHub controlHub = new ControlHub();

        Light light1 = new Light();
        Light light2 = new Light();
        Light light3 = new Light();
        Awning awning = new Awning();
        ElectricGate electricGate = new ElectricGate();
        Camera camera = new Camera();

        controlHub.addDeviceToTheHome(light1);
        controlHub.addDeviceToTheHome(light2);
        controlHub.addDeviceToTheHome(light3);
        controlHub.addDeviceToTheHome(awning);
        controlHub.addDeviceToTheHome(electricGate);
        controlHub.addDeviceToTheHome(camera);

        controlHub.connectToOnlineServices(light1);
        controlHub.connectToOnlineServices(light2);
        controlHub.connectToOnlineServices(light3);
        controlHub.connectToOnlineServices(awning);
        controlHub.connectToOnlineServices(electricGate);
        controlHub.connectToOnlineServices(camera);


        System.out.println(controlHub.statoImpianto());

        ArrayList<Device> devListOfAProfile = new ArrayList<>();
        devListOfAProfile.add(light1);
        devListOfAProfile.add(light2);
        devListOfAProfile.add(awning);
        devListOfAProfile.add(electricGate);

        System.out.println(controlHub.statoImpianto());


        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());
        System.out.println("the gate is opened: " + electricGate.getState());
        System.out.println("the camera is on: " + camera.getState());


        //Profile profileNight = new ProfileNight(devListOfAProfile);
        Profile profiloDay = new ProfileDay(devListOfAProfile);
        controlHub.attivaProfilo(devListOfAProfile, profiloDay);

        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());
        System.out.println("the gate is opened: " + electricGate.getState());
        System.out.println("the camera is on: " + camera.getState());





    }

}