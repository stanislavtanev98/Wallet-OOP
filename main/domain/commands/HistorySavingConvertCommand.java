package domain.commands;

import domain.interfaces.HistoryTransactionRepository;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class HistorySavingConvertCommand implements HistoryTransactionRepository {

    protected Deque<String> transactions = new ArrayDeque<>();

    public Deque<String> getTransactions() {
        return transactions;
    }

    public void saveTransaction(String transaction) {
        this.transactions.push(transaction);
    }
}
