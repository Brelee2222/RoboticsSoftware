package frc.robot.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankControl extends CommandBase {
    XboxController controller = new XboxController(0);
    DriveTrain drive;

    public TankControl(DriveTrain drive) {
        addRequirements(drive);
        this.drive = drive;
    }

    @Override
    public void initialize() {
        drive.setPercent(0, 0);
    }

    @Override
    public void end(boolean interrupted) {
        drive.setPercent(0, 0);
    }

    public void execute() {
        drive.setPercent(controller.getLeftY(), controller.getRightY());
    }
}
