// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Spoiler;

public class SpoilerPId extends Command {
  private final Spoiler spoiler;
  private final PIDController pidController;

  public SpoilerPId(Spoiler spoiler, double setpoint) {
    this.spoiler = spoiler;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(5);
    addRequirements(spoiler);
  }

  @Override
  public void initialize() {
    pidController.reset();
  }

  @Override
  public void execute() {
    double speed = pidController.calculate(spoiler.getSpoilerEncoder());
    spoiler.set(speed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
