package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.ClawSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class DropObject extends CommandBase {

  private final ClawSubsystem claw;
  Timer clawTimer = new Timer();

  /**
   * Command that runs the claw motors for a short amount of time, releasing what ever object 
   *
   * @param claw The subsystem used by this command.
   */
  public DropObject(ClawSubsystem claw) {
    this.claw = claw;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    clawTimer.reset();
    clawTimer.start();
    claw.stopClaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    claw.runClaw(Constants.CLAWSPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    claw.stopClaw();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return clawTimer.get()>=1;
  }
}