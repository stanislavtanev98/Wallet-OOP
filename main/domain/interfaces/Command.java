package domain.interfaces;

import domain.commands.EmptyInput;
import domain.entities.Wallet;

public interface Command<T extends EmptyInput> {

    void execute();
}
