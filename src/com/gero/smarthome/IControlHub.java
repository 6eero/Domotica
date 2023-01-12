package com.gero.smarthome;

import com.gero.smarthome.exceptions.Exception;
import com.gero.smarthome.profile.Profile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IControlHub {

    void addDeviceToTheHome(@NotNull Device device);

    Map<String, List<Device>> statoImpianto();

    void inviaComando(@NotNull Device device, @NotNull String command) throws Exception.DeviceOfflineException;

    void attivaProfilo(ArrayList<Device> devListOfAProfile, @NotNull Profile profilo) throws Exception.DeviceOfflineException;

    void connectToOnlineServices(@NotNull Device device);
}
