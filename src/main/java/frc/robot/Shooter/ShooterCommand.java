package frc.robot.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterCommand extends CommandBase{
    Shooter shooter;
    public ShooterCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setPercent(0.5);
    }
    @Override
    public void end(boolean interruptable) {
        shooter.setPercent(0);
    }
}