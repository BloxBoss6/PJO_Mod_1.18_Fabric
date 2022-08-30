package net.bloxboss6.pjomod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.bloxboss6.pjomod.util.IEntityDataSaver;
import net.minecraft.command.argument.MessageArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;

public class SetParentageCommand {
    private static List<String> dieties = List.of(
            "Ares",
            "Aphrodite",
            "Apollo",
            "Artemis",
            "Athena",
            "Demeter",
            "Dionysus",
            "Hades",
            "Hephaestus",
            "Hera",
            "Hermes",
            "Poseidon",
            "Zeus");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        LiteralArgumentBuilder literalArgumentBuilder = (LiteralArgumentBuilder)CommandManager.literal("parentage");
        for (String diety : dieties) {
            literalArgumentBuilder.then(CommandManager.literal("set").then(CommandManager.literal(diety)
                    .executes(context -> SetParentageCommand.run(context, diety))));
        }
        dispatcher.register(literalArgumentBuilder);
    }

    public static int run(CommandContext<ServerCommandSource> context, String parent) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();

        player.getPersistantData().putString("parentage", parent);

        context.getSource().sendFeedback(new TranslatableText("command.pjomod.parentage.set", parent), true);
        return 1;
    }
}
