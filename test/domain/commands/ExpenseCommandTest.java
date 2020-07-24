package domain.commands;

import domain.entities.Wallet;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ExpenseCommandTest {

    @Test(expected = IllegalStateException.class)
    public void test_execute_throws_when_money_are_negative(){
        // GIVEN
        ExpenseCommand expenseCommand = new ExpenseCommand(
                new ExpenseCommand.Input("Food", BigDecimal.valueOf(-1)),
                new Wallet(),
                new HistorySavingConvertCommand()
        );

        // WHEN
        expenseCommand.execute();

        // THEN throws exception
    }

    @Test(expected = IllegalStateException.class)
    public void test_execute_throws_when_wallet_do_not_have_enough_money(){
        // GIVEN
        Wallet wallet = new Wallet();
        wallet.setTotalAmount(BigDecimal.valueOf(20));
        ExpenseCommand expenseCommand = new ExpenseCommand(
                new ExpenseCommand.Input("Food", BigDecimal.valueOf(30)),
                wallet,
                new HistorySavingConvertCommand()
        );

        // WHEN
        expenseCommand.execute();

        // THEN throws exception
    }

    @Test
    public void test_execute_subtract_30_from_wallet_with_amount_50_returns_20(){
        // GIVEN
        Wallet wallet = new Wallet();
        wallet.setTotalAmount(BigDecimal.valueOf(50));
        ExpenseCommand expenseCommand = new ExpenseCommand(
                new ExpenseCommand.Input("Food", BigDecimal.valueOf(30)),
                wallet,
                new HistorySavingConvertCommand()
        );

        // WHEN
        expenseCommand.execute();

        // THEN
        Assert.assertEquals(20, wallet.getTotalAmount().intValue());
    }

}