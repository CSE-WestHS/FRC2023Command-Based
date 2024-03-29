package frc.robot.commands.BasicDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForward extends CommandBase{
      /**
   * Creates a command that drives the robot forward (or backward) X rotations
   *
   * @param drivesystem The subsystem used by this command.
   */
  private final DriveSubsystem DriveSubsystem;
  private final double rotations;
  private final double speed;

  public DriveForward(DriveSubsystem drivesystem, double rotations, double speed) {
    DriveSubsystem = drivesystem;
    this.rotations = rotations;
    this.speed = speed;
    addRequirements(drivesystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   DriveSubsystem.resetEncoders();
   DriveSubsystem.stopWheels();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.setSpeed(speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.resetEncoders();
    DriveSubsystem.stopWheels();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return DriveSubsystem.getEncoderPosition() <= -rotations;
  }
}