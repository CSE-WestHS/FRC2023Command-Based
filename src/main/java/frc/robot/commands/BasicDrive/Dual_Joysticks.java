package frc.robot.commands.BasicDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import frc.robot.OI;

public class Dual_Joysticks extends CommandBase {
  private final DriveSubsystem DriveSubsystem;

  public Dual_Joysticks(DriveSubsystem subsystem) {
    DriveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    double leftSpeed = -OI.DriveController.getLeftY() * Constants.MAXSPEED;
    double rightSpeed = -OI.DriveController.getRightY() * Constants.MAXSPEED;
    DriveSubsystem.setSpeed(leftSpeed, rightSpeed);

  }

}
