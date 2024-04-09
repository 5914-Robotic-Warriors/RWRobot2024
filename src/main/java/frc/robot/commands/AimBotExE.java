// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import frc.robot.subsystems.Swerve;
import frc.robot.Constants;
import frc.robot.subsystems.Limelight;
import java.util.function.Supplier;

public class AimBotExE extends Command {

  double xoffset;
  double targetangle;

  /** Creates a new AimBotExE. */
  public AimBotExE(/*Limelight limelight, Supplier<Boolean> Aimed*/) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.s_Swerve);
    //addRequirements(limelight);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // RobotContainer.s_Swerve.resetAutoRotatePID();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*if ((limelight.calculateTurn() >=55)){
      return Aimed;
    }
    else{
      return false;
    }*/
    RobotContainer.s_Swerve.drive(new Translation2d(0, 0), -0.25, true, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.s_Swerve.drive(new Translation2d(0, 0), 0, true, true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
