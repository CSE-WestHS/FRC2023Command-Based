package frc.robot.commands.AutonomousCommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ExtendorSubsystem;
import frc.robot.subsystems.LeverSubsystem;
import frc.robot.LimitSensors;
import frc.robot.commands.BasicDrive.DriveBackward;
import frc.robot.Constants;

public class AutoScore extends SequentialCommandGroup{
    public AutoScore(ExtendorSubsystem extendor, LeverSubsystem lever, ClawSubsystem claw, LimitSensors sensors, DriveSubsystem drive){
        addCommands(
            new CubeScore(drive, claw, extendor, lever, sensors), 
            new DriveBackward(drive, 62, Constants.AUTO_DRIVE_SPEED)
            );
        
    }
}
