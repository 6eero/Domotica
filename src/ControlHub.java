import org.jetbrains.annotations.NotNull;
import java.util.*;

public class ControlHub {

    private final List<Device> devicesList = new ArrayList<>();


    /**
     * Method to add a device to the device list of the home
     * @param device the one to add
     */
    public void addDevice(@NotNull Device device) {
        devicesList.add(device);
    }


    /**
     * Method to know which device is on and which is off
     * @return two lists, one with the devices on, the other with those off
     */
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
    public void inviaComando(@NotNull Device device, @NotNull String command) throws Exception.DeviceOfflineException {
        device.send(device, command);
    }


    /**
     * Method to create a new profile
     * @param nomeProfilo the name of the profile
     * @param listaDispositivi the list of devices thate uses the profile
     * @return a new profile, euqipped with a name and a list of devices
     */
    public Profilo creaProfilo(@NotNull String nomeProfilo, @NotNull List<Device> listaDispositivi) {
        return new Profilo(nomeProfilo, listaDispositivi);
    }


    /**
     * Method to activate a profile
     * @param profilo the profile to activate
     * @throws Exception.DeviceOfflineException if some devices is oflline
     */
    public void attivaProfilo(@NotNull Profilo profilo) throws Exception.DeviceOfflineException {

        if (profilo.getNome().equals("giorno")) {
            profilo.profiloGiorno();

        } else if (profilo.getNome().equals("notte")) {
            profilo.profiloNotte();
        }


    }
}
