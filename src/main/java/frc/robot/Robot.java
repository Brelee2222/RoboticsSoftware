
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Intake.Intake;
import frc.robot.DriveTrain.DriveTrain;
import frc.robot.Indexer.Indexer;
import frc.robot.Shooter.Shooter;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Robot extends TimedRobot {

  XboxController controller = new XboxController(0);

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    Intake intake = new Intake();
    Indexer indexer = new Indexer();
    Shooter shooter = new Shooter();
    DriveTrain driverTrain = new DriveTrain();
    Trigger leftBumper = new Trigger(() -> controller.getLeftBumper());
    Trigger driver = new Trigger();
    driver.whenActive(() -> driverTrain.setPercent(controller.getLeftY(), controller.getRightY()));
    leftBumper.whenActive(() -> {intake.commandSetFold(false);indexer.setPercent(1);shooter.setPercent(1);}).whenInactive(() -> {intake.commandSetFold(true);indexer.stop();shooter.stop();});

  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
