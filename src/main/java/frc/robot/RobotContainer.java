// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.command.FireAMP;
import frc.robot.command.LowerLeftDart;
import frc.robot.command.LowerRightDart;
import frc.robot.command.RaiseLeftDart;
import frc.robot.command.RaiseRightDart;
import frc.robot.subsystems.AMPRoller;
import frc.robot.subsystems.DART;

public class RobotContainer {
  /** Creates a new RobotContainer. */
  public RobotContainer() {
    // Use addRequirements() here to declare subsystem dependencies.
    private final XboxController xbox = new XboxController(Constants.XBOX_CONTROLLER_PORT);
    private final AMPRoller Movement_Roller = new Roller();
    private final DART m_Dart = new Dart();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
    final JoystickButton buttonLB = new JoystickButton(xbox, Constants.joystickLBButton);
    final JoystickButton buttonRB = new JoystickButton(xbox, Constants.joystickRBButton);
    final 



    buttonLB.whileTrue(new LowerLeftDart(Dart));
    buttonRB.whileTrue(new RaiseLeftDart(Dart));
    
  }

}
