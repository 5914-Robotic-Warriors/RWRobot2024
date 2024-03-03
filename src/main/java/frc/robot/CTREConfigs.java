package frc.robot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public final class CTREConfigs {
    public TalonFXConfiguration swerveAngleFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration swerveDriveFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration intakeFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration ballscrewFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration flywheelFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration flywheel2FXConfig = new TalonFXConfiguration();
    public CANcoderConfiguration swerveCANcoderConfig = new CANcoderConfiguration();
    public TalonFXConfiguration conveyorFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration winchFXConfiguration = new TalonFXConfiguration();

    public CTREConfigs(){
        // Intake config
        intakeFXConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        conveyorFXConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        //Winch config
        winchFXConfiguration.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        // Ballscrew config
        ballscrewFXConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        ballscrewFXConfig.HardwareLimitSwitch.ReverseLimitAutosetPositionEnable = true;
        ballscrewFXConfig.HardwareLimitSwitch.ReverseLimitAutosetPositionValue = 0;
        ballscrewFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        ballscrewFXConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        ballscrewFXConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = 206;

        //Flywheel1 config
        flywheelFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        flywheelFXConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        //Flywheel2 config
        flywheel2FXConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        flywheel2FXConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        /** Swerve CANCoder Configuration */
        swerveCANcoderConfig.MagnetSensor.SensorDirection = Constants.Swerve.cancoderInvert;

        /** Swerve Angle Motor Configurations */
        /* Motor Inverts and Neutral Mode */
        swerveAngleFXConfig.MotorOutput.Inverted = Constants.Swerve.angleMotorInvert;
        swerveAngleFXConfig.MotorOutput.NeutralMode = Constants.Swerve.angleNeutralMode;

        /* Gear Ratio and Wrapping Config */
        swerveAngleFXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.angleGearRatio;
        swerveAngleFXConfig.ClosedLoopGeneral.ContinuousWrap = true;
        
        /* Current Limiting */
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.angleEnableCurrentLimit;
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentLimit = Constants.Swerve.angleCurrentLimit;
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Swerve.angleCurrentThreshold;
        swerveAngleFXConfig.CurrentLimits.SupplyTimeThreshold = Constants.Swerve.angleCurrentThresholdTime;

        /* PID Config */
        swerveAngleFXConfig.Slot0.kP = Constants.Swerve.angleKP;
        swerveAngleFXConfig.Slot0.kI = Constants.Swerve.angleKI;
        swerveAngleFXConfig.Slot0.kD = Constants.Swerve.angleKD;

        /** Swerve Drive Motor Configuration */
        /* Motor Inverts and Neutral Mode */
        swerveDriveFXConfig.MotorOutput.Inverted = Constants.Swerve.driveMotorInvert;
        swerveDriveFXConfig.MotorOutput.NeutralMode = Constants.Swerve.driveNeutralMode;

        /* Gear Ratio Config */
        swerveDriveFXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.driveGearRatio;

        /* Current Limiting */
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.driveEnableCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimit = Constants.Swerve.driveCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Swerve.driveCurrentThreshold;
        swerveDriveFXConfig.CurrentLimits.SupplyTimeThreshold = Constants.Swerve.driveCurrentThresholdTime;

        /* PID Config */
        swerveDriveFXConfig.Slot0.kP = Constants.Swerve.driveKP;
        swerveDriveFXConfig.Slot0.kI = Constants.Swerve.driveKI;
        swerveDriveFXConfig.Slot0.kD = Constants.Swerve.driveKD;

        /* Open and Closed Loop Ramping */
        swerveDriveFXConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;
        swerveDriveFXConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;

        swerveDriveFXConfig.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
        swerveDriveFXConfig.ClosedLoopRamps.VoltageClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
    }
}