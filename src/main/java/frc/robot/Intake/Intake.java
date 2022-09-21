
package frc.robot.Intake;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class Intake extends SubsystemBase {
  IntakeSpinCommand spin = new IntakeSpinCommand(this, 0.5); 

  TalonFX intakeMotor = new TalonFX(5);
  Solenoid solenoid = new Solenoid(20, PneumaticsModuleType.REVPH, 3);

  XboxController controller = new XboxController(0);

  @Override
  public void periodic() {

  }

  public void stop() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
  }

  public void setFold(boolean up) {
    solenoid.set(!up);
    if(up)
      stop();
    else
      setPercent(1);
  }

  public void setPercent(double percent) {
    intakeMotor.set(ControlMode.PercentOutput, percent);
  }

  public Command commandStop() {
    return new InstantCommand(this::stop);
  }

  public Command commandSetFold(boolean isUp) {
    return new InstantCommand(() -> this.setFold(isUp));
  }

  public Command commandSetPercent(double percent) {
    return new InstantCommand(() -> this.setPercent(percent), this);
  }
}
