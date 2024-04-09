// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Winch;

public class ClimbingWinchCMD extends Command {
  private final Winch winch;
  private final Double speed;

  public ClimbingWinchCMD(Winch winch, Double speed) {
    this.winch = winch;
    this.speed = speed;
    addRequirements(winch);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    winch.runWinch(speed);
  }

  @Override
  public void end(boolean interrupted) {
    winch.runWinch(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
