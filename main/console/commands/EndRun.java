package console.commands;

import domain.commands.EndCommand;
import domain.entities.Wallet;

public class EndRun {

    public void end() {
        new EndCommand().execute();
    }
}
