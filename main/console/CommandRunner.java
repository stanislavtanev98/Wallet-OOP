package console;

import console.commands.*;
import domain.commands.HistorySavingConvertCommand;
import domain.entities.Wallet;

import java.math.BigDecimal;

public class CommandRunner {

    public void runCommands(Wallet wallet, HistorySavingConvertCommand historyConverter, String[] tokens) {
        switch (tokens[0]) {
            case "Income":
                // Income {amount of money}
                BigDecimal moneyToAdd = BigDecimal.valueOf(Double.parseDouble(tokens[1]));
                new IncomeRun().income(moneyToAdd, wallet, historyConverter);
                break;
            case "Expense":
                // Expense {amount of money}
                // Expense {product} {amount of money}
                new ExpenseRun().expense(tokens, wallet, historyConverter);
                System.out.println("You have " + wallet.getTotalAmount() + " euro left!");
                break;
            case "Statistic":
                // Statistic
                new StatisticRun().statistic(wallet);
                break;
            case "History":
                // History {the last N transactions}
                int nTransaction = Integer.parseInt(tokens[1]);
                new HistoryRun().history(wallet, nTransaction, historyConverter);
                break;
            case "End":
                // End
                new EndRun().end();
                break;
            default:
                throw new IllegalStateException("You have written wrong command!" + "\n" + "Please try again:");
        }
    }
}
