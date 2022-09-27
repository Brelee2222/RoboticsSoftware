package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.DriveTrain.TankControl;
import frc.robot.Indexer.IndexerCommand;
import frc.robot.Indexer.Indexer;
import frc.robot.Intake.Intake;
import frc.robot.Intake.IntakeSpinCommand;
import frc.robot.Shooter.ShootSequence;
import frc.robot.Shooter.Shooter;
import frc.robot.Shooter.ShooterCommand;
import frc.robot.DriveTrain.DriveTrain;
public class RobotContainer {
    DriveTrain driverTrain = new DriveTrain();
    XboxController controller = new XboxController(0);
    Intake intake = new Intake();
    Shooter shooter = new Shooter();
    Indexer indexer = new Indexer();
    RobotContainer() {
        driverTrain.setDefaultCommand(new TankControl(driverTrain));

        new Trigger(controller::getLeftBumper).whileActiveOnce(new ShootSequence(intake, indexer, shooter));
    }
}
