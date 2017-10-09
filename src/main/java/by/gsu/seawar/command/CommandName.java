package by.gsu.seawar.command;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.command.impl.CreatePlayCommand;
import by.gsu.seawar.command.impl.CreateWaitCommand;
import by.gsu.seawar.command.impl.FireCommand;
import by.gsu.seawar.command.impl.LoginCommand;
import by.gsu.seawar.command.impl.LogoutCommand;
import by.gsu.seawar.command.impl.PlayCommand;
import by.gsu.seawar.command.impl.RegistryCommand;
import by.gsu.seawar.command.impl.RejectCommand;
import by.gsu.seawar.command.impl.SurrenderCommand;
import by.gsu.seawar.command.impl.UnknownCommand;
import by.gsu.seawar.command.impl.VerifyCommand;

public enum CommandName {

    TO_DASHBOARD {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new ToDashboardCommand(dispatcher);
        }
    },
    CREATE_WAIT {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new CreateWaitCommand(dispatcher);
        }
    },
    VERIFY {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new VerifyCommand(dispatcher);
        }
    },
    REJECT {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new RejectCommand(dispatcher);
        }
    },
    SURRENDER {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new SurrenderCommand(dispatcher);
        }
    },
    CREATE_PLAY {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new CreatePlayCommand(dispatcher);
        }
    },
    CREATE_FIELD {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new CreateFieldCommand(dispatcher);
        }
    },
    PLAY {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new PlayCommand(dispatcher);
        }
    },
    CHECKING_FILL_FIELDS_ENEMY {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new CheckFillFieldsOfEnemyCommand(dispatcher);
        }
    },
    LOGOUT {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new LogoutCommand(dispatcher);
        }
    },
    LOGIN {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new LoginCommand(dispatcher);
        }
    },
    REGISTRY {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new RegistryCommand(dispatcher);
        }
    },
    FIRE {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new FireCommand(dispatcher);
        }
    },
    UNKNOWN {
        public ICommand getCommand(Dispatcher dispatcher) {
            return new UnknownCommand();
        }
    };

    public abstract ICommand getCommand(Dispatcher dispatcher);

}
