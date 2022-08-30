package net.bloxboss6.pjomod.util;

import net.bloxboss6.pjomod.command.ReturnParentageCommand;
import net.bloxboss6.pjomod.command.SetParentageCommand;
import net.bloxboss6.pjomod.event.ModPlayerEventCopyFrom;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCommands();
        registerEvents();
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetParentageCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnParentageCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
