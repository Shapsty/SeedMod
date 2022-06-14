package com.Mod.Client.command;

import com.Mod.Client.SeedMod;
import com.Mod.Client.command.Commands.CmdListCommand;
import com.Mod.Client.command.Commands.PrefixCommand;
import com.Mod.Client.command.Commands.ShowWorldChanges;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

public class CommandManager {
    public static String COMMANDPREFIX = ";";
    public static final ArrayList<Command> commands = new ArrayList<>();

    public CommandManager(){
        //init all commands via addCommand method
        MinecraftForge.EVENT_BUS.register(this);
        SeedMod.EVENT_BUS.subscribe(this);

        addCommand(new ShowWorldChanges());
        addCommand(new PrefixCommand());
        addCommand(new CmdListCommand());
    }

    public static void addCommand(Command command) {
        commands.add(command);
    }

    public static ArrayList<Command> getCommands() {
        return commands;
    }

    public static String getCommandPrefix() {
        return COMMANDPREFIX;
    }

    public static void setCommandPrefix(String prefix) {
        COMMANDPREFIX = prefix;
    }
}
