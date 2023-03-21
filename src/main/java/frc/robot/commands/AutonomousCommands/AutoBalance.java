package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.BalanceSteps.Balance;
import frc.robot.commands.BasicDrive.DriveBackward;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NavchipManager;
import frc.robot.Constants;


public class AutoBalance extends SequentialCommandGroup {
    public AutoBalance(DriveSubsystem driveSubsystem, NavchipManager navchipManager) {
        addCommands(
                new DriveBackward(driveSubsystem, Constants.AUTO_DRIVE_DISTANCE, Constants.AUTO_DRIVE_SPEED-.1));
                new Balance(driveSubsystem, navchipManager);
    
    }
}
