package console;

import console.commands.*;
import domain.commands.*;
import domain.entities.Wallet;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleRunner {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        Wallet wallet = new Wallet();
        var historyConverter = new HistorySavingConvertCommand();

        while(true) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");

            try {
                new CommandRunner().runCommands(wallet, historyConverter, tokens);
            } catch (IllegalStateException | IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }

    }

}
