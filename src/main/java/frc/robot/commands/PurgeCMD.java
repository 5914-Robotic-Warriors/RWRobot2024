package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;

public class PurgeCMD extends Command {
  private final Intake intake;
  private final Conveyor conveyor;
  private final double speed;

  public PurgeCMD(Intake intake, Conveyor conveyor, double speed) {
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
      intake.runIntake(speed);
      conveyor.setConveyor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    // System.out.println("\nIntakeJoystickCMD ended\n");
    intake.runIntake(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
