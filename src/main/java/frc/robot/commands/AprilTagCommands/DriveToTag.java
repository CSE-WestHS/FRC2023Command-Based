package frc.robot.commands.AprilTagCommands;

import frc.robot.subsystems.PhotonVisionManager;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveToTag extends CommandBase{
    //needed subsystems plus the tag we want to see
    final DriveSubsystem driveSystem;
    final int AprilID;
    final PhotonVisionManager photon;
    public DriveToTag(DriveSubsystem drivesystem,PhotonVisionManager photon, int AprilID){
        this.AprilID = AprilID;
        this.driveSystem = drivesystem;
        this.photon = photon;
        
        addRequirements(drivesystem);
    }
    @Override
  public void initialize() {
    driveSystem.stopwheels();
  }
  @Override
  public void execute(){
    driveSystem.setSpeed(0.35, 0.35);
  }
  @Override
  public boolean isFinished() {
    return photon.tagSeen(AprilID);
  }
  
  @Override
  public void end(boolean interrupted){
    driveSystem.stopwheels();
  }

}
