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
  /** Creates a new SpoilerPId. */
  public SpoilerPId(Spoiler spoiler, double setpoint) {
    this.spoiler = spoiler;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(5);
    addRequirements(spoiler);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = pidController.calculate(spoiler.getSpoilerEncoder());
    spoiler.set(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
