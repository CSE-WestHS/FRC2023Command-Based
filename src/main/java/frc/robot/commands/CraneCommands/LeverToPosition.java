package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.LeverSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class LeverToPosition extends CommandBase {

  private final LeverSubsystem lever;
  private final double encoderEndPos;
  private final double startPos;
  private final boolean tooFar;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param encoderPos     The position on the encoder you wish to run a motor on.
   */
  public LeverToPosition(LeverSubsystem lever, double encoderEndPos) {
    this.lever = lever;
    this.encoderEndPos = encoderEndPos;
    // used for logic to determine weather the motor needs to run forwards or
    // backwards
    startPos = lever.getEncoderPosition();
    tooFar = startPos > encoderEndPos;

    addRequirements(lever);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lever.stopMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (tooFar) {
      lever.setSpeed(-Constants.LEVERSPEED);
    } else {
      lever.setSpeed(Constants.LEVERSPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lever.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (tooFar) {
      return lever.getEncoderPosition() <= encoderEndPos;
    } else {
      return lever.getEncoderPosition() >= encoderEndPos;
    }
  }
}