package domain.commands;

import domain.interfaces.Command;

public class EndCommand implements Command<EmptyInput> {

    @Override
    public void execute() {
        System.out.println("You close your Wallet!");
        System.exit(0);
    }
}
