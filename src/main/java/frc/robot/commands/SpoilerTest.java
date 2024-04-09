// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Spoiler;

public class SpoilerTest extends Command {
  private final Spoiler spoiler;
  private final Supplier<Double> speed;

  public SpoilerTest(Spoiler spoiler, Supplier<Double> speed) {
    this.spoiler = spoiler;
    this.speed = speed;
    addRequirements(spoiler);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    spoiler.set(speed.get() * 0.50);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
