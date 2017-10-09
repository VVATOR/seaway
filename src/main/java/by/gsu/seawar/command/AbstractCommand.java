package by.gsu.seawar.command;

import by.gsu.seawar.Dispatcher;

public abstract class AbstractCommand implements ICommand {
    protected Dispatcher dispatcher;

    public AbstractCommand(Dispatcher dispatcher) {
        super();
        this.dispatcher = dispatcher;
    }

}
