package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.LeverSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.LimitSensors;

/** An example command that uses an example subsystem. */
public class LeverToPosition extends CommandBase {

  private final LeverSubsystem lever;
  private final LimitSensors sensors;
  private final double limitEndPos;
  private double startPos;
  private boolean tooFar;
  private boolean hitLimit;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param encoderPos     The position on the encoder you wish to run a motor on.
   */
  public LeverToPosition(LeverSubsystem lever, LimitSensors sensors, double limitEndPos) {
    this.lever = lever;
    this.limitEndPos = limitEndPos;
    this.sensors = sensors;
    // used for logic to determine weather the motor needs to run forwards or
    // backwards
    addRequirements(lever);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startPos = lever.getEncoderPosition();
    tooFar = startPos > limitEndPos;
    lever.stopMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hitLimit = sensors.CraneSwitchedBack();
    if (tooFar) {
      hitLimit = sensors.CraneSwitchedFront();
    }
    if (!hitLimit) {
      if (tooFar) {
        lever.setSpeed(-Constants.LEVERSPEED);
      } else {
        lever.setSpeed(Constants.LEVERSPEED);
      }
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
    if (hitLimit) {
      return true;
   } else if (tooFar) {
      return lever.getEncoderPosition() <= limitEndPos;
    } else {
      return lever.getEncoderPosition() >= limitEndPos;
    }
  }
}