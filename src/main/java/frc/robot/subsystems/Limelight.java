// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.opencv.core.Mat;

import com.ctre.phoenix.led.CANdle;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.BallscrewPID;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AimBotExE;

public class Limelight extends SubsystemBase {
  private final CANdle candle = new CANdle(33);
   DigitalInput input = new DigitalInput(0);
  
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

public boolean getNote(){
        return input.get();
    }

  public double calculateTurn() {
    xoffset = (Constants.T_Cam + tx.getDouble(0.0)) * Math.PI / 180.0;

    return xoffset;
  }

  public static boolean Aimed(){
    if((xoffset >=55) && (xoffset <=65)){
      return true;
    }else{
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
    SmartDashboard.putBoolean("Note sensor", getNote());
    
    if (getNote()){
      candle.setLEDs(0,255,0);
    }
    else if(!getNote()){
      candle.setLEDs(255,0,0);

    }else{
      candle.setLEDs(0,0,255);
    }

  }
}
