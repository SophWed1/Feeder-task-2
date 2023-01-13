// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Feeder.FeedBall;
import frc.robot.commands.Feeder.FeederControlledByJoystick;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.PIDShooter;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Feeder feeder = new Feeder();
  private final Shooter shooter = new Shooter();
  private final PIDShooter PIDshooter = new PIDShooter();

  private final XboxController m_joystick = new XboxController(1);

  private CommandXboxController controller = new CommandXboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //feeder.setDefaultCommand(new FeederControlledByJoystick(feeder, () -> controller.getLeftX())); //TODO make this like 8.0
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* 
    Trigger aButton = controller.a();
    aButton.whileTrue(new FeedBall(feeder));
    */

    //JoystickButton B = new JoystickButton(m_joystick, 2);
    
    Trigger RT = controller.axisGreaterThan(3, 0);
    JoystickButton A = new JoystickButton(m_joystick, 1);
    JoystickButton B = new JoystickButton(m_joystick, 2);

    RT.onTrue(Commands.startEnd(() -> shooter.ShooterSpin(controller.getRightTriggerAxis()), () -> shooter.ShooterSpin(0), shooter));
    RT.onFalse(Commands.startEnd(() -> shooter.StopShooter(), () -> shooter.StopShooter(), shooter));

    A.onTrue(Commands.startEnd(() -> feeder.spinFeeder(0.65), () -> feeder.spinFeeder(0), feeder));
    A.onFalse(Commands.startEnd(() -> feeder.stopFeeder(), () -> feeder.stopFeeder(), feeder));

    B.onTrue(Commands.runOnce(() -> PIDshooter.setSetpoint(5000), PIDshooter));

    /* 
    B.onTrue(Commands.startEnd(() -> shooter.ShooterSpin(0.65), () -> shooter.ShooterSpin(0), shooter));
    B.onFalse(Commands.startEnd(() -> shooter.StopShooter(), () -> shooter.StopShooter(), shooter));
    */

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand(() -> System.out.println("This is a command"));
  }
}
