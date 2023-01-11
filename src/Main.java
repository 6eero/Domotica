import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception.DeviceOfflineException {

        ControlHub controlHub = new ControlHub();

        Light light1 = new Light();
        Light light2 = new Light();
        Light light3 = new Light();
        Awning awning = new Awning();

        controlHub.addDevice(light1);
        controlHub.addDevice(light2);
        controlHub.addDevice(light3);
        controlHub.addDevice(awning);

        light1.connectToOnlineServices();
        light2.connectToOnlineServices();
        light3.connectToOnlineServices();
        awning.connectToOnlineServices();


        System.out.println(controlHub.statoImpianto());
        List<Device> devicesList = new ArrayList<>();
        devicesList.add(light1);
        devicesList.add(light2);
        devicesList.add(awning);
        System.out.println(controlHub.statoImpianto());


        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());

        Profilo profilo = controlHub.creaProfilo("notte", devicesList);
        controlHub.attivaProfilo(profilo);

        System.out.println();

        System.out.println("light 1 color: " + light1.getColor());
        System.out.println("light 2 color: " + light2.getColor());
        System.out.println("light 1 brightness: " + light1.getBrightness());
        System.out.println("light 2 brightness: " + light2.getBrightness());
        System.out.println("awnings opened: " + awning.getState());





    }

}