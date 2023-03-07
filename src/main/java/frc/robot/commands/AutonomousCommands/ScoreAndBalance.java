package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.CraneCommands.DropObject;
import frc.robot.commands.CraneCommands.ExtendorToPosition;
import frc.robot.commands.CraneCommands.LeverToPosition;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ExtendorSubsystem;
import frc.robot.subsystems.LeverSubsystem;
import frc.robot.LimitSensors;
import frc.robot.subsystems.NavchipManager;

public class ScoreAndBalance extends SequentialCommandGroup {
    public ScoreAndBalance(DriveSubsystem drive, NavchipManager nav,
            ExtendorSubsystem extendor, LeverSubsystem lever,
            ClawSubsystem claw, LimitSensors sensors) {

                addCommands(
                    new CubeScore(drive, claw, extendor, lever, sensors),
                    new AutoBalance(drive, nav)
                );
    }
}