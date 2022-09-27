package frc.robot.Indexer;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexerCommand extends CommandBase {
    Indexer indexer;
    IndexerCommand(Indexer indexer) {
        this.indexer = indexer;
    }

    @Override
    public void execute() {
        indexer.setPercent(0.5);
    }

    public void stop() {
        indexer.setPercent(0);
    }
}