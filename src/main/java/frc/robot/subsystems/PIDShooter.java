// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class PIDShooter extends PIDSubsystem {
  private final TalonFX BackShooter = new TalonFX(7);
  //PIDController pid;
  double encoderOffset;

  //private final SimpleMotorFeedforward m_shooterFeedForward = new SimpleMotorFeedforward(getMeasurement(), getSetpoint());

  /** Creates a new PIDShooter. */
  public PIDShooter() {
    
    super(
        // The PIDController used by the subsystem
         new PIDController(0.01, 0, 0));

         BackShooter.setInverted(true);
         BackShooter.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() {
      super.periodic();
      SmartDashboard.putNumber("Encoder value: ", BackShooter.getSelectedSensorPosition());
  }

  @Override
  public void useOutput(double output, double setpoint) {//setpoint: target position; output: power/speed required
    // Use the output here
    //BackShooter.set(TalonFXControlMode.PercentOutput, output);

    BackShooter.set(TalonFXControlMode.PercentOutput, setpoint);
    // m_shooterMotor.setVoltage(output + m_shooterFeedforward.calculate(setpoint));
  
  }

  public void resetEncoders(){
    encoderOffset = BackShooter.getSelectedSensorPosition();
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return BackShooter.getSelectedSensorPosition() - encoderOffset;
  }
}
