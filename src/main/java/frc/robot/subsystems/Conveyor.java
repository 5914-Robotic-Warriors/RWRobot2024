package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Conveyor extends SubsystemBase {
    DigitalInput input = new DigitalInput(0);
    private final TalonFX conveyor1 = new TalonFX(9);
    private final TalonFX conveyor2 = new TalonFX(24);
    private final CANdle candle = new CANdle(33);
    

    public Conveyor() {
        conveyor1.getConfigurator().apply(Robot.ctreConfigs.conveyorFXConfig);
        conveyor2.getConfigurator().apply(Robot.ctreConfigs.flywheelFXConfig);
        conveyor2.setControl(new Follower(conveyor1.getDeviceID(), true));
    }

    public void setConveyor(double speed) {
        conveyor1.set(speed);
    }

    public boolean getNote(){
        return input.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("NoteSensor", getNote());
        if (!getNote()){
            candle.setLEDs(0, 255, 0);
        }
        else{
            candle.setLEDs(255, 0, 0);
        }
    }
}
