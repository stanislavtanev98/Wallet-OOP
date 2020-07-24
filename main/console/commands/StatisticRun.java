package console.commands;

import domain.commands.StatisticCommand;
import domain.entities.Wallet;

public class StatisticRun {

    public void statistic(Wallet wallet) {
        new StatisticCommand(wallet).execute();
    }
}
