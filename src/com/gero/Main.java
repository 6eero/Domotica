package com.gero;

import com.gero.smarthome.*;
import com.gero.smarthome.exceptions.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // istanzia nuovo hub
        IControlHub controlHub = new ControlHub();

        // crea alcuni device
        Light light1 = new Light();
        Light light2 = new Light();
        Light light3 = new Light();
        Awning awning = new Awning();
        ElectricGate electricGate = new ElectricGate();
        Camera camera = new Camera();

        controlHub.configuraCasa(Arrays.asList(light1, light2, light3, awning, electricGate, camera));

        Profile profilo1 = new SmarthomeProfile("Profilo 1");
        profilo1.addCommand(light1, "brightness:high");
        profilo1.addCommand(light2, "brightness:low");
        profilo1.addCommand(light3, "brightness:high");
        profilo1.addCommand(awning, "open");

        Profile profilo2 = new SmarthomeProfile("Profilo 2");
        profilo2.addCommand(light1, "brightness:low");
        profilo2.addCommand(light2, "brightness:low");
        profilo2.addCommand(light3, "brightness:high");
        profilo2.addCommand(awning, "close");

        controlHub.aggiungiProfilo(profilo1);
        controlHub.aggiungiProfilo(profilo2);


        System.out.println("Stato iniziale: " + controlHub.statoImpianto());

        try {
            controlHub.inviaComando(light1, "color:#f00");
        } catch (ExecutionFailedException e) {
            System.out.println("light1 non ha eseguito il comando");
        }
        System.out.println("Dopo 1 comando: " + controlHub.statoImpianto());


        try {
            controlHub.attivaProfilo("Profilo 1");
        } catch (ExecutionFailedException e) {
            System.out.println("Errore: alcuni device non hanno eseguito i comandi:\n\t" + e.getMessage());
        }

        System.out.println("Profilo 1: " + controlHub.statoImpianto());

        try {
            controlHub.attivaProfilo("Profilo 2");
        } catch (ExecutionFailedException e) {
            System.out.println("Errore: alcuni device non hanno eseguito i comandi:\n\t" + e.getMessage());
        }

        System.out.println("Profilo 2: " + controlHub.statoImpianto());
    }
}