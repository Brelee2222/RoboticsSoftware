
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class TankControl extends TimedRobot {

  TalonFX rightBack = new TalonFX(2);
  TalonFX rightFront = new TalonFX(1);
  TalonFX leftBack = new TalonFX(4);
  TalonFX leftFront = new TalonFX(3);

  XboxController controller = new XboxController(0);

  double deadZone = 0.1;

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
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  @Override
  public void teleopPeriodic() {
    double currentLeftControllerY = controller.getLeftY();
    currentLeftControllerY = Math.abs(currentLeftControllerY) < deadZone ? 0 : currentLeftControllerY;
    double currentRightControllerY = controller.getRightY();
    currentRightControllerY = Math.abs(currentRightControllerY) < deadZone ? 0 : currentRightControllerY;
    rightFront.set(ControlMode.PercentOutput, currentLeftControllerY/-2);
    leftFront.set(ControlMode.PercentOutput, currentRightControllerY/2);
    if(currentRightControllerY == 0)
      leftFront.setNeutralMode(NeutralMode.Brake);
    else {
      leftFront.setNeutralMode(NeutralMode.Coast);
    }
    if(currentLeftControllerY == 0)
      rightFront.setNeutralMode(NeutralMode.Brake);
    else {
      rightFront.setNeutralMode(NeutralMode.Coast);
    }
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
