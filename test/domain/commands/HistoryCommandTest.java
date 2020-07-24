package domain.commands;

import domain.entities.Wallet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HistoryCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

//    @Test
//    public void out() {
//        System.out.print("hello");
//        assertEquals("hello", outContent.toString());
//    }
//
//    @Test
//    public void err() {
//        System.err.print("hello again");
//        assertEquals("hello again", errContent.toString());
//    }

    @Test(expected = IllegalArgumentException.class)
    public void test_history_command_execute_throws_when_deque_is_empty(){
        HistoryCommand historyCommand = new HistoryCommand(
                new HistoryCommand.Input(3),
                new Wallet(),
                new HistorySavingConvertCommand()
        );

        historyCommand.execute();
    }

    @Test
    public void test_history_command_execute_returns_1_transaction_when_the_are_3(){
        var historyConverter = new HistorySavingConvertCommand();
        historyConverter.saveTransaction("transaction");
        historyConverter.saveTransaction("transaction2");
        historyConverter.saveTransaction("transaction3");
        HistoryCommand historyCommand = new HistoryCommand(
                new HistoryCommand.Input(1),
                new Wallet(),
                historyConverter
        );

        historyCommand.execute();
        assertEquals("transaction3", outContent.toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_history_command_constructor_throws_when_numbers_to_show_is_negative_number(){
        HistoryCommand historyCommand = new HistoryCommand(
                new HistoryCommand.Input(-2),
                new Wallet(),
                new HistorySavingConvertCommand()
        );
    }

    @Test
    public void constructor_test(){
        HistoryCommand historyCommand = new HistoryCommand(
                new HistoryCommand.Input(3),
                new Wallet(),
                new HistorySavingConvertCommand()
        );
    }

}