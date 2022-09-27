package frc.robot.Shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Intake.Intake;
import frc.robot.Intake.IntakeSpinCommand;
import frc.robot.Indexer.Indexer;
import frc.robot.Indexer.IndexerCommand;

public class ShootSequence extends SequentialCommandGroup{
    XboxController controller = new XboxController(0);
    public ShootSequence(Intake intake, Indexer indexer, Shooter shooter) {
        addRequirements(intake, indexer, shooter);
        addCommands(new IntakeSpinCommand(intake, 0.5), new IndexerCommand(indexer), new ShooterCommand(shooter));
    }
}
