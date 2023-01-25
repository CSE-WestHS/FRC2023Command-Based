package frc.robot.commands.BasicDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NavchipManager;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class TurnRight extends CommandBase {
  /**
   * Creates a command that drives the robot forward (or backward) X rotations
   *
   * @param drivesystem The subsystem used by this command.
   */
  private final DriveSubsystem DriveSubsystem;
  private final NavchipManager navchipManager;
  private final double degrees;
  private final double speed;
  private double currentYaw;
  private double desiredYaw;

  public TurnRight(DriveSubsystem drivesystem, NavchipManager NAV, double deg, double spd) {
    // assigning values
    DriveSubsystem = drivesystem;
    degrees = deg;
    speed = spd;
    navchipManager = NAV;

    addRequirements(drivesystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    DriveSubsystem.resetEncoders();
    DriveSubsystem.stopwheels();

    // code uses the yaw of nav to decide when to stop rotating
    currentYaw = navchipManager.getYaw();
    SmartDashboard.putNumber("getYaw", currentYaw);
    desiredYaw = currentYaw + degrees;
    // used to account for sign change of yaw after it reaches 180*
    if (desiredYaw > 180) {
      double yawDifference = desiredYaw - 180;
      desiredYaw = -(180 - yawDifference);
    }
    SmartDashboard.putNumber("Desired Yaw", desiredYaw);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.setSpeed(speed, -speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.resetEncoders();
    DriveSubsystem.stopwheels();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // accounts for desiredYaw changing to a negative
    if (desiredYaw <= 0) {
    return navchipManager.getYaw() >= desiredYaw && navchipManager.getYaw() < 0;
     }
    return navchipManager.getYaw() >= desiredYaw;
  }
}
