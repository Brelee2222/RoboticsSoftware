package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;


import frc.robot.Intake.Intake;
import frc.robot.DriveTrain.TankControl;
import frc.robot.DriveTrain.DriveTrain;
import frc.robot.Indexer.Indexer;
import frc.robot.Shooter.Shooter;

public class RobotContainer {
    Intake intake = new Intake();
    Indexer indexer = new Indexer();
    Shooter shooter = new Shooter();
    DriveTrain driverTrain = new DriveTrain();
    XboxController controller = new XboxController(0);
    RobotContainer() {
        driverTrain.setDefaultCommand(new TankControl(driverTrain));
        new Trigger(() -> controller.getLeftBumper()).whenActive(() -> {intake.commandSetFold(false);indexer.setPercent(1);shooter.setPercent(1);}).whenInactive(() -> {intake.commandSetFold(true);indexer.stop();shooter.stop();});    
    }
}
