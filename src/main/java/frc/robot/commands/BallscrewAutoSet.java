// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Ballscrew;
import frc.robot.subsystems.Conveyor;

public class BallscrewAutoSet extends Command {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double angle;
  double power;
  double Ballscrewangle;
  private final Ballscrew ballscrew;
  private final PIDController pidController;
  private final Conveyor conveyor;

  public BallscrewAutoSet(Ballscrew ballscrew, Conveyor conveyor) {
    this.ballscrew = ballscrew;
    this.conveyor = conveyor;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setTolerance(5);
    addRequirements(ballscrew);
  }

  @Override
  public void initialize() {
    pidController.reset();
  }

  @Override
  public void execute() {

    if (!conveyor.getNote()) {
      pidController.setSetpoint(45);
    } else {
      pidController.setSetpoint(-5);
    }
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
