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
import frc.robot.subsystems.Limelight;

public class BallscrewAutoSet extends Command {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double angle;
  // double distance;
  double power;
  double Ballscrewangle;
  private final Ballscrew ballscrew;
  private final PIDController pidController;
  private final Conveyor conveyor;
  private final Limelight limelight;

  /** Creates a new BallscrewPID. */
  public BallscrewAutoSet(Ballscrew ballscrew, Conveyor conveyor, Limelight limelight) {
    this.ballscrew = ballscrew;
    this.conveyor = conveyor;
    this.limelight = limelight;
    // this.distance = distance;
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

      if(!conveyor.getNote()){
      pidController.setSetpoint(45);
      /*} 
     
    if ((limelight.calculateDistance() <= 45) && (!conveyor.getNote())) {
      pidController.setSetpoint(42);
    }

    else if ((limelight.calculateDistance() > 45) && (limelight.calculateDistance() <= 61) && (!conveyor.getNote())) {
      pidController.setSetpoint(31);
    }

    else if ((limelight.calculateDistance() > 61) && (limelight.calculateDistance() <= 71) && (!conveyor.getNote())) {
      pidController.setSetpoint(24);
    }

    else if ((limelight.calculateDistance() > 71) && (limelight.calculateDistance() <= 78) && (!conveyor.getNote())) {
      pidController.setSetpoint(18);
    }

    else if ((limelight.calculateDistance() > 78) && (limelight.calculateDistance() <= 87) && (!conveyor.getNote())) {
      pidController.setSetpoint(15);
    }
    
    else if ((limelight.calculateDistance() > 87) && (limelight.calculateDistance() <= 92) && (!conveyor.getNote())) {
      pidController.setSetpoint(12);*/
    
    } else {
      pidController.setSetpoint(-5);
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
    if (pidController.atSetpoint()) {
      return true;
    } else {
      return false;
    }
  }
}
