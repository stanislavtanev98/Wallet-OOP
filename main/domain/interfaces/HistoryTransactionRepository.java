package domain.interfaces;

import java.util.Deque;
import java.util.List;

public interface HistoryTransactionRepository {

    Deque<String> getTransactions();

    void saveTransaction(String transaction);
}
