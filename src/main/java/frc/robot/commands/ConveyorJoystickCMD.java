package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import java.util.function.Supplier;

public class ConveyorJoystickCMD extends Command {
  private final Conveyor conveyor;
  private final Supplier<Boolean> speed;

  public ConveyorJoystickCMD(Conveyor conveyor, Supplier<Boolean> speed) {
    this.conveyor = conveyor;
    this.speed = speed;
    addRequirements(conveyor);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (speed.get()) {
      conveyor.setConveyor(.15);
    } else {
      conveyor.setConveyor(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    conveyor.setConveyor(0);
  }

  @Override
  public boolean isFinished() {
    if (!conveyor.getNote()) {
      return true;
    } else {
      return false;
    }
  }
}
