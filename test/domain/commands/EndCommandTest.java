package domain.commands;

import console.commands.EndRun;
import domain.entities.Wallet;
import junit.framework.AssertionFailedError;
import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EndCommandTest {

//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final PrintStream originalErr = System.err;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
//    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void test_end_command_ends_the_program(){
        // GIVEN
        EndCommand endCommand = new EndCommand();

        // WHEN
        exit.expectSystemExit();
        endCommand.execute();

        // THEN the program stops
    }

    @Test
    public void test_end_command_ends_the_program_with_status_0(){
        // GIVEN
        EndCommand endCommand = new EndCommand();

        // WHEN
        exit.expectSystemExitWithStatus(0);
        endCommand.execute();

        // THEN the program stops
    }


}