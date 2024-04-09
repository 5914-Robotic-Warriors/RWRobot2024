// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class AimBotExE extends Command {

  double xoffset;
  double targetangle;

  public AimBotExE() {
    addRequirements(RobotContainer.s_Swerve);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    RobotContainer.s_Swerve.drive(new Translation2d(0, 0), -0.25, true, true);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.s_Swerve.drive(new Translation2d(0, 0), 0, true, true);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
