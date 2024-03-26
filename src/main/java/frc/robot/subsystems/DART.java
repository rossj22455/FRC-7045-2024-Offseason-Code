// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.hal.simulation.AnalogOutDataJNI;
import edu.wpi.first.wpilibj.AnalogInput;

public class DART extends SubsystemBase {
  /** Creates a new Actuators. */
  

  public CANSparkMax LeftDart = new CANSparkMax(Constants.LeftDart_ID, MotorType.kBrushless);
  public CANSparkMax RightDart = new CANSparkMax(Constants.RightDart_ID, MotorType.kBrushless);
  public static double Speed = Constants.DartSpeed;
  public RelativeEncoder LeftEncoder;
  public RelativeEncoder RightEncoder;

  public AnalogInput DART = new AnalogInput(Constants.DIO_Potentiomator);
  public int AnalogPos;

  public DigitalInput UpperLimitR = new DigitalInput(Constants.DIO_HALL_EFFECT_UPPER_LEFT);
  public DigitalInput UpperLimitL = new DigitalInput(Constants.DIO_HALL_EFFECT_UPPER_RIGHT);
  public DigitalInput LowerLimitR = new DigitalInput(Constants.DIO_HALL_EFFECT_RETRACTED_RIGHT);
  public DigitalInput LowerLimitL = new DigitalInput(Constants.DIO_HALL_EFFECT_RETRACTED_LEFT);

  public DART() {

    super();

    LeftDart.restoreFactoryDefaults();
    RightDart.restoreFactoryDefaults();
    LeftDart.setOpenLoopRampRate(Constants.kOpenLoopRampRate);
    RightDart.setOpenLoopRampRate(Constants.kOpenLoopRampRate);
    LeftDart.setInverted(false);
    RightDart.setInverted(false);
    LeftDart.setIdleMode(IdleMode.kBrake);
    RightDart.setIdleMode(IdleMode.kBrake);
    LeftDart.setSmartCurrentLimit(60);
    RightDart.setSmartCurrentLimit(60);
    LeftEncoder = LeftDart.getEncoder();
    RightEncoder = RightDart.getEncoder();

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void Raise() {
    LeftDart.set(Speed);
  }

  public void Lower() {
    LeftDart.set(-Speed);
  }

  public void Stop() {
    LeftDart.set(0);
  }

  public boolean LeftLowered() {
    if (UpperLimitL.get() == false && LowerLimitL.get() == true) {
      return true;
    } else {
      return false;
    }
    }

  public boolean RightLowered() {
    if (UpperLimitR.get() == false && LowerLimitR.get() == true) {
      return true;
    } else {
      return false;
    }
    }

  public boolean RightRaised() {
    if (UpperLimitR.get() == true && LowerLimitR.get() == false) {
      return true;
    } else {
      return false;
    }
  }

  public boolean LeftRaised() {
    if (UpperLimitL.get() == true && LowerLimitL.get() == false) {
      return true;
    } else {
      return false;
    }
  }
}


