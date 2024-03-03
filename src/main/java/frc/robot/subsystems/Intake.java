package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Intake extends SubsystemBase {
    private final TalonFX intake1 = new TalonFX(21);
    private final TalonFX intake2 = new TalonFX(4);

    public Intake() {
        intake1.getConfigurator().apply(Robot.ctreConfigs.intakeFXConfig);

        intake2.setControl(new Follower(intake1.getDeviceID(), false));
    }

    public void runIntake(double speed){
        intake1.set(speed);
        
    }
}
