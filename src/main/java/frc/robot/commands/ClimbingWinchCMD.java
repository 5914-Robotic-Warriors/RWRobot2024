// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Winch;
import java.util.function.Supplier;

public class ClimbingWinchCMD extends Command {
  private final Winch winch;
  private final Double speed;
  
  public ClimbingWinchCMD(Winch winch, Double speed) {
    this.winch = winch;
    this.speed = speed;
    addRequirements(winch);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winch.runWinch(speed);
   /*  if (speed.get()) {
      winch.runWinch(.1);
    } else {
      winch.runWinch(0);
    }*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    winch.runWinch(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
