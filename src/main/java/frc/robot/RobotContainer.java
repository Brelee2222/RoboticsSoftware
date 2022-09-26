package frc.robot;

import frc.robot.Intake.Intake;
import frc.robot.DriveTrain.DriveTrain;
import frc.robot.Indexer.Indexer;
import frc.robot.Shooter.Shooter;

public class RobotContainer {
    Intake intake = new Intake();
    Indexer indexer = new Indexer();
    Shooter shooter = new Shooter();
    DriveTrain driverTrain = new DriveTrain();
}
