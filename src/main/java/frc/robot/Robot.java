
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;


import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Robot extends TimedRobot {

  RobotContainer robotContainer;
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
    Trigger leftBumper = new Trigger(() -> controller.getLeftBumper());
    Trigger driver = new Trigger(() -> true);
    driver.whenActive(() -> robotContainer.driverTrain.setPercent(controller.getLeftY(), controller.getRightY()));
    leftBumper.whenActive(() -> {robotContainer.intake.commandSetFold(false);robotContainer.indexer.setPercent(1);robotContainer.shooter.setPercent(1);}).whenInactive(() -> {robotContainer.intake.commandSetFold(true);robotContainer.indexer.stop();robotContainer.shooter.stop();});

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
