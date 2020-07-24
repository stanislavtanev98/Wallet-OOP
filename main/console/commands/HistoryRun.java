package console.commands;

import domain.commands.HistoryCommand;
import domain.commands.HistorySavingConvertCommand;
import domain.entities.Wallet;

public class HistoryRun {

    public void history(Wallet wallet, int parseInt, HistorySavingConvertCommand historySavingConvertCommand) {
        new HistoryCommand(new HistoryCommand.Input(parseInt), wallet, historySavingConvertCommand).execute();
    }
}
