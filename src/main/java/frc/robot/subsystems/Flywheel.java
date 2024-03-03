package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Flywheel extends SubsystemBase {
    private final TalonFX flywheel1 = new TalonFX(2);
    private final TalonFX flywheel2 = new TalonFX(3);

    public Flywheel() {
        flywheel2.setControl(new Follower(flywheel1.getDeviceID(), true));
        flywheel1.getConfigurator().apply(Robot.ctreConfigs.flywheelFXConfig);
        flywheel2.getConfigurator().apply(Robot.ctreConfigs.flywheel2FXConfig); 
    }

    public void runFlywheel(double speed){
        flywheel1.set(speed);
    }

    public void runFlywheel2(double speed){
        flywheel2.set(speed);
    }
}
