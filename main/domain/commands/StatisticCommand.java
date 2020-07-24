package domain.commands;

import domain.entities.Wallet;
import domain.interfaces.Command;

public class StatisticCommand implements Command<EmptyInput> {

    private Wallet wallet;

    public StatisticCommand(Wallet wallet){
        this.wallet = wallet;
    }

    @Override
    public void execute() {
        System.out.println(wallet);
    }
}
