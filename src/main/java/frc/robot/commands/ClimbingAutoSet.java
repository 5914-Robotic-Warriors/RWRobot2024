// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.Ballscrew;

public class ClimbingAutoSet extends Command {
  private final Ballscrew ballscrew;
  private final PIDController pidController;

  public ClimbingAutoSet(Ballscrew ballscrew, double setpoint) {
    this.ballscrew = ballscrew;
    this.pidController = new PIDController(setpoint, setpoint, setpoint);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(5);
    addRequirements(ballscrew);
  }

  @Override
  public void initialize() {
    pidController.reset();
  }

  @Override
  public void execute() {
    double speed = pidController.calculate(ballscrew.getBallscrewEncoder());
    ballscrew.setAngle(speed);
  }

  @Override
  public void end(boolean interrupted) {
    ballscrew.setAngle(0);
  }

  @Override
  public boolean isFinished() {
    if (pidController.atSetpoint()) {
      return true;
    } else {
      return false;
    }
  }
}
