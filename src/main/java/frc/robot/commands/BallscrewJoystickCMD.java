package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Ballscrew;

public class BallscrewJoystickCMD extends Command {
    private final Ballscrew ballscrew;
    private final Supplier<Double> speed;

    public BallscrewJoystickCMD(Ballscrew ballscrew, Supplier<Double> speed) {
        this.ballscrew = ballscrew;
        this.speed = speed;
        addRequirements(ballscrew);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        ballscrew.setAngle(speed.get());
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
