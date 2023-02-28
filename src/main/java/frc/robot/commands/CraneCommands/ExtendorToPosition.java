package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.ExtendorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class ExtendorToPosition extends CommandBase {

  private final ExtendorSubsystem extendor;
  private final double encoderEndPos;
  private final double startPos;
  private final boolean tooFar;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param encoderPos     The position on the encoder you wish to run a motor on.
   */
  public ExtendorToPosition(ExtendorSubsystem extendor, double encoderEndPos) {
    this.extendor = extendor;
    this.encoderEndPos = encoderEndPos;
    // used for logic to determine weather the motor needs to run forwards or
    // backwards
    startPos = extendor.getEncoderPosition();
    tooFar = startPos > encoderEndPos;

    addRequirements(extendor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    extendor.stopMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (tooFar) {
      extendor.setSpeed(-Constants.EXTENDORSPEED);
    } else {
      extendor.setSpeed(Constants.EXTENDORSPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    extendor.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (tooFar) {
      return extendor.getEncoderPosition() <= encoderEndPos;
    } else {
      return extendor.getEncoderPosition() >= encoderEndPos;
    }
  }
}