package net.bloxboss6.pjomod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.bloxboss6.pjomod.util.IEntityDataSaver;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

public class ReturnParentageCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("parentage").then(CommandManager.literal("get").executes(ReturnParentageCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();

        String parent = player.getPersistantData().getString("parentage");

        if (parent.length() != 0) {
            context.getSource().sendFeedback(new TranslatableText("command.pjomod.parentage.get", parent), true);
            return 1;
        } else {
            context.getSource().sendFeedback(new TranslatableText("command.pjomod.parentage.error"), true);
            return -1;
        }
    }
}
