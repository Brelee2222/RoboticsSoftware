
package frc.robot.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {
    TalonFX rightBack = new TalonFX(2);
    TalonFX rightFront = new TalonFX(1);
    TalonFX leftBack = new TalonFX(4);
    TalonFX leftFront = new TalonFX(3);

    double deadZone = 0.1;

    public DriveTrain() {
        leftBack.follow(leftFront);
        rightBack.follow(rightFront);
    }

  public void stop() {
    leftFront.set(ControlMode.PercentOutput, 0);
    rightBack.set(ControlMode.PercentOutput, 0);
  }

  public void setPercent(double percentLeft, double percentRight) {
    leftFront.set(ControlMode.PercentOutput, Math.abs(percentLeft) >= deadZone ? percentLeft : 0);
    rightBack.set(ControlMode.PercentOutput, Math.abs(percentRight) >= deadZone ? percentRight : 0);
  }
}
