package frc.robot.commands.Feeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeedBall extends CommandBase {
    private final Feeder feeder;

    public FeedBall(Feeder feeder) {
        this.feeder = feeder;
        addRequirements(feeder);
    }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      //Feeder ought be set to spin.
      
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.spinFeeder(0.5);

  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    feeder.stopFeeder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return false;
  }
}
