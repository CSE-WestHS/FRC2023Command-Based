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
    
    double speed = -OI.DriveController.getY() * Constants.MAXSPEED;
    double turn = -OI.DriveController.getX() * Constants.MAXSPEED;
    DriveSubsystem.arcadeDrive(speed, turn);
  }

}
