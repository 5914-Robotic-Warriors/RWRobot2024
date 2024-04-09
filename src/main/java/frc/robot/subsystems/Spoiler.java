// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Spoiler extends SubsystemBase {
  private final TalonFX spoiler = new TalonFX(49);
  private final DutyCycleEncoder spoilerEncoder = new DutyCycleEncoder(1);

  /** Creates a new Spoiler. */
  public Spoiler() {
    spoiler.getConfigurator().apply(Robot.ctreConfigs.spoilerFXConfig);
    // spoiler.setPosition(80);
  }

  public void set(double speed) {
    spoiler.set(speed);
  }

  public double getSpoilerEncoder() {
    return spoilerEncoder.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("AmpSpoiler", spoilerEncoder.getAbsolutePosition());
  }
}
