
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Flywheel;

public class FlywheelAuto extends Command {
  private final Flywheel flywheel;
  private final Timer timer;
  private final Conveyor conveyor;

  public FlywheelAuto(Flywheel flywheel, Conveyor conveyor, Timer timer) {
    this.flywheel = flywheel;
    this.timer = timer;
    this.conveyor = conveyor;
    addRequirements(flywheel, conveyor);
  }

  @Override
  public void initialize() {
    // System.out.println("\nFlywheelJoystickCMD started\n");
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    flywheel.runFlywheel(.75);
    flywheel.runFlywheel2(.75);
    conveyor.setConveyor(.15);
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nFlywheelJoystickCMD ended\n");
    flywheel.runFlywheel(0);
    flywheel.runFlywheel2(0);
    conveyor.setConveyor(0);
  }

  @Override
  public boolean isFinished() {
    if (timer.get() >= 1) {
      return true;
    } else {
      return false;
    }
  }
}
