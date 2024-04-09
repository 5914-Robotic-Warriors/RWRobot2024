// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Spoiler;

public class SpoilerTest extends Command {
  private final Spoiler spoiler;
    private final Supplier<Double> speed;
  /** Creates a new SpoilerTest. */
  public SpoilerTest(Spoiler spoiler, Supplier<Double> speed) {
    this.spoiler = spoiler;
        this.speed = speed;
        addRequirements(spoiler);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    spoiler.set(speed.get() * 0.50);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
