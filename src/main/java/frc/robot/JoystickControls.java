package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class JoystickControls extends TimedRobot {
    TalonFX leftBack = new TalonFX(2);
    TalonFX leftFront = new TalonFX(1);
    TalonFX rightBack = new TalonFX(4);
    TalonFX rightFront = new TalonFX(3);
  
    XboxController controller = new XboxController(0);
  
    double deadZone = 0.1;

    void setDrive(TalonFX motor, double value) {
        if(Math.abs(value) < deadZone) {
            motor.setNeutralMode(NeutralMode.Coast);
            motor.set(ControlMode.PercentOutput, value);
        } else {
            motor.setNeutralMode(NeutralMode.Brake);
            motor.set(ControlMode.PercentOutput, 0);
        }
    }

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
        double currentControllerX = controller.getLeftX();
        double rightDrive = controller.getLeftY();
        double leftDrive = (rightDrive =- currentControllerX) + currentControllerX;

        setDrive(leftFront, leftDrive);
        setDrive(rightFront, -rightDrive);
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
  
