// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DART;

public class LowerLeftDart extends Command {
  /** Creates a new RaiseLeftDart. */
  private final DART Dart;
  public LowerLeftDart(DART mdart) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    Dart = mdart;
    addRequirements(mdart);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Dart.Lower();

    System.out.println("RightDart Lower");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Dart.RightLowered()) {
      if (Constants.kDebug) {
        System.out.println("RightHallEffect Sensor Triggered Lower");
      }
      return true;
    } else {
      return false;
    }
  }
}
