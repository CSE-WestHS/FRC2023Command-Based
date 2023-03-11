package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.ExtendorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.LimitSensors;

/** An example command that uses an example subsystem. */
public class ExtendorToPosition extends CommandBase {

  private final ExtendorSubsystem extendor;
  private final LimitSensors sensors;
  private final double limitEndPos;
  private final double startPos;
  private final boolean tooFar;
  private boolean hitLimit;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param encoderPos     The position on the encoder you wish to run a motor on.
   */
  public ExtendorToPosition(ExtendorSubsystem extendor, LimitSensors sensors, double limitEndPos) {
    this.extendor = extendor;
    this.limitEndPos = limitEndPos;
    this.sensors = sensors;
    // used for logic to determine weather the motor needs to run forwards or
    // backwards
    startPos = sensors.GetExtendorPos();
    tooFar = startPos > limitEndPos;

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
    boolean hitLimit;
    hitLimit = false;
    if (tooFar ^ Constants.EXTENDOR_SENSOR_INVERTED){
      if (sensors.GetExtendorPos() > 20){
 //       hitLimit = true;
      }
    }else {
      if (sensors.GetExtendorPos() < 1){
 //       hitLimit = true;
      }
    }
    if (!hitLimit) {
      if (tooFar) {
        extendor.setSpeed(Constants.EXTENDORSPEED);
      } else {
        extendor.setSpeed(-Constants.EXTENDORSPEED);
      }
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
    if (hitLimit) {
      return true;
    }
    if (tooFar) {
      return sensors.GetExtendorPos() <= limitEndPos;
    } else {
      return sensors.GetExtendorPos() >= limitEndPos;
    }
  }
}