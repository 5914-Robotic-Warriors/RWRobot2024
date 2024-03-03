package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;

public class IntakeJoystickCMD extends Command {
  private final Intake intake;
  private final Conveyor conveyor;
  private final Supplier<Boolean> speed;

  public IntakeJoystickCMD(Intake intake, Conveyor conveyor, Supplier<Boolean> speed) {
    this.intake = intake;
    this.conveyor = conveyor;
    this.speed = speed;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    // System.out.println("\nIntakeJoystickCMD started\n");
  }

  @Override
  public void execute() {
    if (speed.get()) {
      intake.runIntake(.50);
    } else {
      intake.runIntake(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nIntakeJoystickCMD ended\n");
    intake.runIntake(0);
  }

  @Override
  public boolean isFinished() {
    if (!conveyor.getNote()){
      return true;
    }
    else{
      return false;
    }
  }
}
