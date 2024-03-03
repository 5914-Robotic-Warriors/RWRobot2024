// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Ballscrew;
import frc.robot.subsystems.Conveyor;

public class BallscrewAutoSet extends Command {
  private final Ballscrew ballscrew;
  private final PIDController pidController;
  private final Conveyor conveyor;

  /** Creates a new BallscrewPID. */
  public BallscrewAutoSet(Ballscrew ballscrew, Conveyor conveyor) {
    this.ballscrew = ballscrew;
    this.conveyor = conveyor;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setTolerance(5);
    addRequirements(ballscrew);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(conveyor.getNote()){
      pidController.setSetpoint(-6.25);
      //ballscrew.setAngle(-1);
    }
    else{
      pidController.setSetpoint(85.25);
    }
    double speed = pidController.calculate(ballscrew.getBallscrewEncoder());
    ballscrew.setAngle(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ballscrew.setAngle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (pidController.atSetpoint()){
      return true;
    }
    else {
      return false;
    }
  }
}
