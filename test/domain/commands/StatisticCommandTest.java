package domain.commands;

import domain.entities.Wallet;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticCommandTest {

    @Test
    public void test_statistic_execute_returns_correct_result(){
        StatisticCommand statisticCommand = new StatisticCommand(new Wallet());
        statisticCommand.execute();
    }

    @Test
    public void test_statistic_constructor(){
        StatisticCommand statisticCommand = new StatisticCommand(new Wallet());
    }

}