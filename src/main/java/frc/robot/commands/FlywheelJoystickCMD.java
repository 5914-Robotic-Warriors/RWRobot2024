
package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Flywheel;

public class FlywheelJoystickCMD extends Command {
  private final Flywheel flywheel;
  private final Supplier<Boolean> speed;

  public FlywheelJoystickCMD(Flywheel flywheel, Supplier<Boolean> speed) {
    this.flywheel = flywheel;
    this.speed = speed;
    addRequirements(flywheel);

  }

  @Override
  public void initialize() {
    // System.out.println("\nFlywheelJoystickCMD started\n");
  }

  @Override
  public void execute() {

    if (speed.get()) {
      flywheel.runFlywheel(.75);
      flywheel.runFlywheel2(.75);
    } else {
      flywheel.runFlywheel(0);
      flywheel.runFlywheel2(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nFlywheelJoystickCMD ended\n");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
