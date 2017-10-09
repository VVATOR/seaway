package by.gsu.seawar.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.command.AbstractCommand;

public class LogoutCommand extends AbstractCommand {

    public LogoutCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    public void exec() {
        final HttpServletRequest request = dispatcher.getRequest();
        request.getSession().invalidate();
        dispatcher.setView("index.jsp");
    }
}
