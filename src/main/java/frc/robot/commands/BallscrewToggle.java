package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class BallscrewToggle extends Command {

    public boolean ballscrewToggle = true;
    private boolean runOnce = true;

    public BallscrewToggle() {
        
    }

    public boolean getBallscrewToggle(){
        return ballscrewToggle;
    }

    public void toggleBool(){
        ballscrewToggle = !ballscrewToggle;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (runOnce){
            ballscrewToggle = !ballscrewToggle;
        }
    }

    @Override
    public void end(boolean interrupted) {
        runOnce = false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
