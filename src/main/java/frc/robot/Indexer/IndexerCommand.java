package frc.robot.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexerCommand extends CommandBase {
    Indexer indexer;
    public IndexerCommand(Indexer indexer) {
        this.indexer = indexer;
        addRequirements(indexer);
    }

    @Override
    public void execute() {
        indexer.setPercent(0.5);
    }

    public void end(boolean interruptable) {
        indexer.setPercent(0);
    }
}
