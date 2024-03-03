package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;

public class IntakeAuto extends Command {
  private final Intake intake;
  private final Conveyor conveyor;

  public IntakeAuto(Intake intake, Conveyor conveyor) {
    this.intake = intake;
    this.conveyor = conveyor;
    addRequirements(intake, conveyor);
  }

  @Override
  public void initialize() {
    // System.out.println("\nIntakeJoystickCMD started\n");
  }

  @Override
  public void execute() {
      intake.runIntake(.75);
      conveyor.setConveyor(.15);
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nIntakeJoystickCMD ended\n");
    intake.runIntake(0);
    conveyor.setConveyor(0);
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
