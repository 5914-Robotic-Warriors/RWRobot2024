
package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Spoiler;
import edu.wpi.first.math.controller.PIDController;


public class FlywheelAmp extends Command {
  private final Flywheel flywheel;
  private final PIDController pidController;
 
  // private final Supplier<Boolean> speed;

  public FlywheelAmp(Flywheel flywheel) {
    this.flywheel = flywheel;
    // this.speed = speed;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setTolerance(5);
    addRequirements(flywheel);  

  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    //pidController.setSetpoint(-31);
    

    flywheel.runFlywheel(.3);
    flywheel.runFlywheel2(.0);
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nFlywheelJoystickCMD ended\n");
    flywheel.runFlywheel(0);
    flywheel.runFlywheel2(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
