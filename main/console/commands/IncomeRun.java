package console.commands;

import domain.commands.HistorySavingConvertCommand;
import domain.commands.IncomeCommand;
import domain.entities.Wallet;

import java.math.BigDecimal;

public class IncomeRun {

    public void income(BigDecimal money, Wallet wallet, HistorySavingConvertCommand historySavingConvertCommand) {
        new IncomeCommand(new IncomeCommand.Input(money), wallet, historySavingConvertCommand).execute();
    }
}
