// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class ColourSensor extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */ 
  private final ColorSensorV3 m_ColorSensor; 

  /** Creates a new ColourSensor. */
  public ColourSensor() {
    m_ColorSensor = new ColorSensorV3(i2cPort);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Red", detectColor().red);
    SmartDashboard.putNumber("Green", detectColor().green);
    SmartDashboard.putNumber("Blue", detectColor().blue);
    SmartDashboard.putNumber("IR", getIR());
  }
  /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */
  public Color detectColor(){
    return m_ColorSensor.getColor();
  }

      /**
     * The sensor returns a raw IR value of the infrared light detected.
     */
  public int getIR(){
    return m_ColorSensor.getIR();
  }

}