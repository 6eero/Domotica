package com.gero;

import com.gero.smarthome.*;
import com.gero.smarthome.exceptions.Exception;
import com.gero.smarthome.device.Awning;
import com.gero.smarthome.device.ElectricGate;
import com.gero.smarthome.device.Light;
import com.gero.smarthome.profile.Profili;
import com.gero.smarthome.profile.Profilo;

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

        controlHub.addDevice(light1);
        controlHub.addDevice(light2);
        controlHub.addDevice(light3);
        controlHub.addDevice(awning);
        controlHub.addDevice(electricGate);

        light1.connectToOnlineServices();
        light2.connectToOnlineServices();
        light3.connectToOnlineServices();
        awning.connectToOnlineServices();
        electricGate.connectToOnlineServices();


        System.out.println(controlHub.statoImpianto());
        List<Device> devicesList = new ArrayList<>();
        devicesList.add(light1);
        devicesList.add(light2);
        devicesList.add(awning);
        devicesList.add(electricGate);
        System.out.println(controlHub.statoImpianto());


        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());
        System.out.println("the gate is opened: " + electricGate.getState());

        Profilo profilo = controlHub.creaProfilo(String.valueOf(Profili.giorno), devicesList);
        controlHub.attivaProfilo(profilo);

        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());
        System.out.println("the gate is opened: " + electricGate.getState());





    }

}