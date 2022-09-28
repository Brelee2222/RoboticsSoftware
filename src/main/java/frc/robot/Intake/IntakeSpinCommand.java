package frc.robot.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeSpinCommand extends CommandBase {
    double speed;

    Intake intake;

    public IntakeSpinCommand(Intake intake, double speed) {
        this.intake = intake;
        this.speed = speed;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setFold(false);
        intake.setPercent(this.speed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setFold(true);
    }

    @Override
    public void execute() {
    }
}