package frc.robot.commands.BasicDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import frc.robot.OI;
/**Command that allows the driving of the robot with the Crane 
 * Controller for percice positioning to grab the field object */
public class PrecisionDrive extends CommandBase {
  private final DriveSubsystem DriveSubsystem;

  public PrecisionDrive(DriveSubsystem subsystem) {
    DriveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    double leftSpeed = -OI.CraneController.getLeftY() * Constants.PRECISIONSPEED;
    double rightSpeed = -OI.CraneController.getRightY() * Constants.PRECISIONSPEED;
    DriveSubsystem.setSpeed(leftSpeed, rightSpeed); 

  } 
  @Override
  public void end(boolean interrupted){
    DriveSubsystem.stopWheels();
  }
  @Override
  public boolean isFinished(){
    return false;
  }
}

