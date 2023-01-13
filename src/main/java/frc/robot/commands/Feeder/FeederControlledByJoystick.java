package frc.robot.commands.Feeder;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeederControlledByJoystick extends CommandBase{
    private final Feeder feeder;
    DoubleSupplier joystickValue;

    public FeederControlledByJoystick(Feeder feeder, DoubleSupplier joystickValue) {
      this.feeder = feeder;
      this.joystickValue = joystickValue;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(feeder);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
  
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        feeder.spinFeeder(joystickValue.getAsDouble());
    }
      
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
