
package frc.robot.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class Shooter extends SubsystemBase {
  TalonFX RearMotor = new TalonFX(8);
  TalonFX FrontMotor = new TalonFX(9);

  @Override
  public void periodic() {

  }

  public void stop() {
    RearMotor.set(ControlMode.PercentOutput, 0);
    FrontMotor.set(ControlMode.PercentOutput, 0);
  }

  public void setPercent(double percent) {
    RearMotor.set(ControlMode.PercentOutput, -percent);
    FrontMotor.set(ControlMode.PercentOutput, -percent);
  }

  public Command commandStop() {
    return new InstantCommand(this::stop);
  }

  public Command commandSetPercent(double percent) {
    return new InstantCommand(() -> this.setPercent(percent), this);
  }
}
