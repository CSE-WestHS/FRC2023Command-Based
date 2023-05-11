package frc.robot.subsystems;
import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveSubsystem  extends SubsystemBase{
    File swerveJsonDirectory;
    SwerveDrive swerveDrive;
    public SwerveSubsystem(){
        File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(),"swerve");
        try{
            SwerveDrive swerveDrive  = new SwerveParser(swerveJsonDirectory).createSwerveDrive();
        } catch(IOException eIoException){
            System.out.println("Wrong file! Check your Deploy folder!");
        }
   
    }
    public void drive(){
        swerveDrive.updateOdometry();
    }
    
}
