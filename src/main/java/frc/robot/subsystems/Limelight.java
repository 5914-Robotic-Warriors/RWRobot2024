// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.BallscrewPID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Limelight extends SubsystemBase {

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double angle;
  double distance;
  double power;
  double Ballscrewangle;

  public Limelight() {

  }

  public double calculateDistance(){
    angle = (Constants.T_Cam + ty.getDouble(0.0)) * Math.PI/180.0;
    distance = Constants.FieldConstants.H_Tag/Math.tan(angle);

    return distance;
  }


  @Override
  public void periodic() {
  
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Distance from AprilTag:", calculateDistance());

    if ((distance >=0) || (distance <63 )) {
    //Ballscrewangle = BallscrewPID

    } else if( (distance >=63 )  ||  (distance <69 ) ) {
      

    } else if( (distance >=42 )  ||  (distance <45 ) ) {
       

    } else if( (distance >=45 )  ||  (distance <48 ) ) {
       

    } else if( (distance >=48 )  ||  (distance <51 ) ) {
     

    } else if( (distance >=51 )  ||  (distance <54 ) ) {


    } else if( (distance >=54 )  ||  (distance <57 ) ) {


    } else if( (distance >=57 )  ||  (distance <60 ) ) {


    } else if( (distance >=60 )  ||  (distance <63 ) ) {
      

    } else if( (distance >=63 )  ||  (distance <66 ) ) {
      

    } else if( (distance >=66 )  ||  (distance <69 ) ) { 


    } else if( (distance >=69 )  ||  (distance <72 ) ) {


    } else if( (distance >=72 )  ||  (distance <75 ) ) {


    } else if( (distance >=75 )  ||  (distance <78 ) ) {


    } else if( (distance >=78 )  ||  (distance <81 ) ) {


    } else if( (distance >=81 )  ||  (distance <84 ) ) {


    } else if( (distance >=84 )  ||  (distance <87 ) ) {


    } else if( (distance >=87 )  ||  (distance <90 ) ) {


    } else if( (distance >=90 )  ||  (distance <93 ) ) {


    } else if( (distance >=93 )  ||  (distance <96 ) ) {


    } else if( (distance >=96 )  ||  (distance <99 ) ) {


    } else if( (distance >=99 )  ||  (distance <102 ) ) {


    } else if( (distance >=102 )  ||  (distance <105 ) ) {


    } else if( (distance >=105 )  ||  (distance <108 ) ) {


    } else if( (distance >=105 )  ||  (distance <108 ) ) {


    } else if( (distance >=105 )  ||  (distance <108 ) ) {


    } else if( (distance >=108 )  ||  (distance <111 ) ) {


    } else if( (distance >=111 )  ||  (distance <114 ) ) {


    } else if( (distance >=114 )  ||  (distance <117 ) ) {


    } else if( (distance >=117 )  ||  (distance <120 ) ) {


    } else if( (distance >=120 )  ||  (distance <123 ) ) {


    } else if( (distance >=123 )  ||  (distance <126 ) ) {


    } else if( (distance >=126 )  ||  (distance <129 ) ) {


    } else if( (distance >=129 )  ||  (distance <132 ) ) {


    } else if( (distance >=132 )  ||  (distance <135 ) ) {


    } else if( (distance >=135 )  ||  (distance <138 ) ) {


    } else if( (distance >=138 )  ||  (distance <141 ) ) {


    } else if( (distance >=141 )  ||  (distance <144 ) ) {


    } else if( (distance >=144 )  ||  (distance <147 ) ) {


    } else if( (distance >=147 )  ||  (distance <150 ) ) {


    } else if( (distance >=150 )  ||  (distance <153 ) ) {

      
    } else if( (distance >=153 )  ||  (distance <156 ) ) {


    } else if( (distance >=156 )  ||  (distance <159 ) ) {

    
    } else if( (distance >=159 )  ||  (distance <162 ) ) {


    } else if( (distance >=162 )  ||  (distance <165 ) ) {


    } else if( (distance >=165 )  ||  (distance <168 ) ) {


    } else if( (distance >=168 )  ||  (distance <171 ) ) {


    } else if( (distance >=171 )  ||  (distance <174 ) ) {


    } else if( (distance >=174 )  ||  (distance <177 ) ) {


    } else if( (distance >=177 )  ||  (distance <180 ) ) {


    } else if( (distance >=180 )  ||  (distance <183 ) ) {


    } else if( (distance >=183 )  ||  (distance <186 ) ) {


    } else if( (distance >=186 )  ||  (distance <189 ) ) {


    } else if( (distance >=189 )  ||  (distance <192 ) ) {


    } else if( (distance >=192 )  ||  (distance <195 ) ) {


    } else if( (distance >=195 )  ||  (distance <198 ) ) {


    } else if( (distance >=198 )  ||  (distance <201 ) ) {


    } else if( (distance >=201 )  ||  (distance <204 ) ) {


    } else if( (distance >=204 )  ||  (distance <207 ) ) {


    } else if( (distance >=207 )  ||  (distance <210 ) ) {


    } else if( (distance >=210 )  ||  (distance <213 ) ) {


    } else if( (distance >=213 )  ||  (distance <216 ) ) {


    } else if( (distance >=216 )  ||  (distance <219 ) ) {


    } else if( (distance >=219 )  ||  (distance <222 ) ) {


    } else if( (distance >=222 )  ||  (distance <225 ) ) {


    } else if( (distance >=225 )  ||  (distance <228 ) ) {


    } else if( (distance >=228 )  ||  (distance <231 ) ) {


    } else if( (distance >=231 )  ||  (distance <234 ) ) {


    } else if( (distance >=234 )  ||  (distance <237 ) ) {


    } else if( (distance >=237 )  ||  (distance <240 ) ) {


    } else if( (distance >=114 )  ||  (distance <243 ) ) {


    } else if( (distance >=243 )  ||  (distance <246 ) ) {


    } else if( (distance >=246 )  ||  (distance <249 ) ) {


    } else if( (distance >=249 )  ||  (distance <252 ) ) {


    } else if( (distance >=252 )  ||  (distance <255 ) ) {


    } else if( (distance >=255 )  ||  (distance <258 ) ) {


    } else if( (distance >=243 )  ||  (distance <261 ) ) {

    
    } else if( (distance >=261 )  ||  (distance <264 ) ) {


    } else if( (distance >=264 )  ||  (distance <267 ) ) {


    } else if( (distance >=267 )  ||  (distance <270 ) ) {


    } else if( (distance >=270 )  ||  (distance <273 ) ) {


    } else if( (distance >=273 )  ||  (distance <276 ) ) {


    } else if( (distance >=276 )  ||  (distance <279 ) ) {


    } else if( (distance >=279 )  ||  (distance <282 ) ) {


    } else if( (distance >=282 )  ||  (distance <285 ) ) {


    } else if( (distance >=285 )  ||  (distance <288 ) ) {
        
    }else{

    }
  }
}
