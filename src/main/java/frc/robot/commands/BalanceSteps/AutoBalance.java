package frc.robot.commands.BalanceSteps;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NavchipManager;

public class AutoBalance extends SequentialCommandGroup {
    public AutoBalance(DriveSubsystem driveSubsystem, NavchipManager navchipManager) {
        addCommands(
                new DriveTillDegrees(driveSubsystem, navchipManager),
                new Balance(driveSubsystem, navchipManager));
    }
}
