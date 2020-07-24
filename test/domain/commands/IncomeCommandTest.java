package domain.commands;

import domain.entities.Wallet;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IncomeCommandTest {

    @Test(expected = IllegalStateException.class)
    public void test_income_command_throws_when_money_are_negative_number(){
        // GIVEN
        IncomeCommand incomeCommand = new IncomeCommand(
                new IncomeCommand.Input(BigDecimal.valueOf(-10)),
                new Wallet(),
                new HistorySavingConvertCommand()
        );

        // WHEN
        incomeCommand.execute();

        //THEN throws exception
    }

    @Test(expected = IllegalStateException.class)
    public void test_income_command_throws_when_money_are_between_0_and_0_99(){
        // GIVEN
        IncomeCommand incomeCommand = new IncomeCommand(
                new IncomeCommand.Input(BigDecimal.valueOf(0)),
                new Wallet(),
                new HistorySavingConvertCommand()
        );

        // WHEN
        incomeCommand.execute();

        //THEN throws exception
    }

    @Test
    public void test_income_command_add_money_properly_when_the_amount_is_higher_than_1(){
        // GIVEN
        IncomeCommand incomeCommand = new IncomeCommand(
                new IncomeCommand.Input(BigDecimal.valueOf(2)),
                new Wallet(),
                new HistorySavingConvertCommand()
        );

        // WHEN
        incomeCommand.execute();
    }

}