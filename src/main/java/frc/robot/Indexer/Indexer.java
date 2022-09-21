
package frc.robot.Indexer;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class Indexer extends SubsystemBase {
  TalonFX bottomMotor = new TalonFX(6);
  TalonFX topMotor = new TalonFX(7);

  @Override
  public void periodic() {

  }

  public void stop() {
    bottomMotor.set(ControlMode.PercentOutput, 0);
    topMotor.set(ControlMode.PercentOutput, 0);
  }

  public void setPercent(double percent) {
    bottomMotor.set(ControlMode.PercentOutput, percent);
    topMotor.set(ControlMode.PercentOutput, percent);
  }

  public Command commandStop() {
    return new InstantCommand(this::stop);
  }

  public Command commandSetPercent(double percent) {
    return new InstantCommand(() -> this.setPercent(percent), this);
  }
}
