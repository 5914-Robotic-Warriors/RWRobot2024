
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;

public class ConveyorShootCMD extends Command {
  private final Conveyor conveyor;

  public ConveyorShootCMD(Conveyor conveyor) {
    this.conveyor = conveyor;
    addRequirements(conveyor);
  }

  @Override
  public void initialize() {
    // System.out.println("\nConveyorJoystickCMD started\n");
  }

  @Override
  public void execute() {
    conveyor.setConveyor(.15);
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nCOnveyorJoystickCMD ended\n");
    conveyor.setConveyor(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
