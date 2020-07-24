package console.commands;

import domain.commands.ExpenseCommand;
import domain.commands.HistorySavingConvertCommand;
import domain.entities.Wallet;

import java.math.BigDecimal;

public class ExpenseRun {

    public void expense(String[] tokens, Wallet wallet, HistorySavingConvertCommand historySavingConvertCommand) {
        if(tokens.length == 2){
            BigDecimal money = BigDecimal.valueOf(Double.parseDouble(tokens[1]));
            new ExpenseCommand(new ExpenseCommand.Input("others", money), wallet, historySavingConvertCommand).execute();
        } else {
            String type = tokens[1];
            BigDecimal money = BigDecimal.valueOf(Double.parseDouble(tokens[2]));
            new ExpenseCommand(new ExpenseCommand.Input(type, money), wallet, historySavingConvertCommand).execute();
        }
    }
}
