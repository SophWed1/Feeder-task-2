// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder.BackendKind;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Shooter extends SubsystemBase {

  TalonFX BackShooter;
  TalonFX FrontShooter;
  TalonFX LeftShooter;

  /** Creates a new Shooter. */
  public Shooter() {
    BackShooter = new TalonFX(7);
    BackShooter.setInverted(true);//check if this is correct
    BackShooter.setNeutralMode(NeutralMode.Coast);

    FrontShooter = new TalonFX(8);
    FrontShooter.setInverted(false);
    FrontShooter.setNeutralMode(NeutralMode.Coast);

    //note that this shooter with device number 35 is broken and cannot spin 
    LeftShooter = new TalonFX(35);
    LeftShooter.setInverted(false);
    LeftShooter.setNeutralMode(NeutralMode.Coast);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ShooterSpin(double speed){
    BackShooter.set(TalonFXControlMode.PercentOutput, speed);
    FrontShooter.set(TalonFXControlMode.PercentOutput, speed);
    LeftShooter.set(TalonFXControlMode.PercentOutput, speed);
  }

  public void StopShooter(){
    BackShooter.set(TalonFXControlMode.PercentOutput, 0);
    FrontShooter.set(TalonFXControlMode.PercentOutput, 0);
    LeftShooter.set(TalonFXControlMode.PercentOutput, 0);
  }

}
