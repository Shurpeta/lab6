package com.shurpeta;
import com.shurpeta.command.Command;
import com.shurpeta.command.TariffManager;
import java.util.LinkedHashMap;
import com.shurpeta.command.*;
import java.util.Map;

public class CommandInvoker {
    private TariffManager manager;

    public CommandInvoker() {
        this.manager = new TariffManager();
    }

    public Map<String, Command> getCommands() {
        Map<String, Command> commands = new LinkedHashMap<>();

        commands.put("view",  new ViewCommand(manager));
        commands.put("load",  new LoadCommand(manager));
        commands.put("add",    new AddCommand(manager));
        commands.put("delete", new DeleteCommand(manager));
        commands.put("save",  new SaveCommand(manager));
        commands.put("count", new CountCommand(manager));
        commands.put("sort",  new SortCommand(manager));
        commands.put("find",  new FindCommand(manager));


        return commands;
    }
}
