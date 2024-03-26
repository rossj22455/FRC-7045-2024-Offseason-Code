// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.AMPRoller;

public class FireAMP extends Command {
  /** Creates a new RaiseLeftDart. */
  private final AMPRoller Movement_Roller;
  private static double Movement_Speed;
  public FireAMP(final AMPRoller Roller, double Speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    Movement_Roller = Roller;
    Movement_Speed = Speed;
    addRequirements(Roller);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Constants.kDebug) {
        system.out.print("Fire AMP Called")
        system.out.println();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Roller.RollF(Movement_Speed);
    if (Constants.kDebug) {
        system.out.print("AmpFire Moving")
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     Movement_Roller.Stop();
      SmartDashboard.putNumber("AMP Output", Movement_Speed);    //Rollers forward while pressed
      if (Constants.kDebug) {

        System.out.print("AMP Roller OUTPUT Speed = ");
        System.out.format("%.2f", Movement_Speed);
        System.out.println("");
       }
  }

  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
