
package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Flywheel;

public class FlywheelAmp extends Command {
  private final Flywheel flywheel;
  // private final Supplier<Boolean> speed;

  public FlywheelAmp(Flywheel flywheel/* , Supplier<Boolean> speed */) {
    this.flywheel = flywheel;
    // this.speed = speed;
    addRequirements(flywheel);

  }

  @Override
  public void initialize() {
    // System.out.println("\nFlywheelJoystickCMD started\n");
  }

  @Override
  public void execute() {

    /*
     * if (speed.get()) {
     * flywheel.runFlywheel(.25);
     * flywheel.runFlywheel2(.05);
     * } else {
     * flywheel.runFlywheel(0);
     * flywheel.runFlywheel2(0);
     * }
     */

    flywheel.runFlywheel(.175);
    flywheel.runFlywheel2(.125);
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
