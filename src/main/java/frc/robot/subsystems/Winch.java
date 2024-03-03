// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Winch extends SubsystemBase {
  private final TalonFX winch = new TalonFX(27);

  public Winch() {
    winch.getConfigurator().apply(Robot.ctreConfigs.winchFXConfiguration);
  }

  public void runWinch(double speed){
    winch.set(speed);
  }

  @Override
  public void periodic() {
    
  }
}
