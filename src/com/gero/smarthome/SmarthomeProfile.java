package com.gero.smarthome;

import com.gero.smarthome.exceptions.ExecutionFailedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmarthomeProfile implements Profile {
    private final Map<Device, List<String>> commands;
    private final String name;

    public SmarthomeProfile(String name) {
        // HashMap supports clear()
        commands = new HashMap<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean removeDevice(Device device) {
        return commands.remove(device) != null;
    }

    @Override
    public void removeAllDevices() {
        commands.clear();
    }

    @Override
    public boolean addCommand(Device device, String command) {
        List<String> deviceCommands = commands.get(device);
        if (deviceCommands == null) {
            deviceCommands = new ArrayList<>(1);
            deviceCommands.add(command);
            commands.put(device, deviceCommands);
            return true;
        }

        if (!deviceCommands.contains(command)) {
            deviceCommands.add(command);
            commands.put(device, deviceCommands);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeCommand(Device device, String command) {
        List<String> deviceCommands = commands.get(device);
        if (deviceCommands == null)
            return false;

        return deviceCommands.remove(command);
    }

    @Override
    public void enableProfile() throws ExecutionFailedException {
        // using forEach() I cannot throw exceptions through lambda
        for (Device device : commands.keySet()) {
            for (String command : commands.get(device)) {
                device.sendCommand(command);
            }
        }
    }
}
