// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase {

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tz = table.getEntry("tz");

  double angle;
  double distance;
  double power;
  double Ballscrewangle;
  static double xoffset;
  double angleoffset;
  double aimed;

  public Limelight() {
  }

  public double calculateDistance() {
    angle = (Constants.T_Cam + ty.getDouble(0.0)) * Math.PI / 180.0;
    distance = (Constants.FieldConstants.H_Tag / Math.tan(angle));

    return distance;
  }

  public double calculateTurn() {
    xoffset = (Constants.T_Cam + tx.getDouble(0.0)) * Math.PI / 180.0;

    return xoffset;
  }

  public static boolean Aimed() {
    if ((xoffset >= 55) && (xoffset <= 65)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void periodic() {
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double z = tz.getDouble(0.0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Limelightz", z);
    SmartDashboard.putNumber("Distance from AprilTag:", calculateDistance());
    SmartDashboard.putNumber("AutoTurn", calculateTurn());
  }
}
