package by.gsu.seawar.command;

import by.gsu.seawar.Dispatcher;

public class CommandFactory {

    public static ICommand newCommand(Dispatcher dispatcher) {
        CommandName command = CommandName.valueOf(dispatcher.getRequest().getParameter("action").toUpperCase());
        return command.getCommand(dispatcher);
    }

}
 