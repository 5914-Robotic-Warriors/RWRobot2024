package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Ballscrew extends SubsystemBase {
    private final TalonFX ballScrew = new TalonFX(1);

    public boolean ballscrewToggle = true;

    public Ballscrew(){
        ballScrew.getConfigurator().apply(Robot.ctreConfigs.ballscrewFXConfig);
        ballScrew.setPosition(80);
    }
    
    public void setAngle(double angle){
        ballScrew.set(angle);
    }

    public double getBallscrewEncoder(){
        return ballScrew.getPosition().getValueAsDouble();
    }

    public boolean getBallscrewToggle(){
        return ballscrewToggle;
    }

    public void toggleBool(){
        ballscrewToggle = !ballscrewToggle;
    }

    @Override
    public void periodic(){
       SmartDashboard.putNumber("Ballscrew encoder: ", ballScrew.getPosition().getValueAsDouble());
    }

    //SmartDashboard.putNumber("Ballscrew angle", getPosition().angle.getDegrees());
}
