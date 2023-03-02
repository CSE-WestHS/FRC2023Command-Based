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
import frc.robot.Constants;


public class CubeScore extends SequentialCommandGroup{
    public CubeScore(DriveSubsystem drive, ClawSubsystem claw, ExtendorSubsystem extendor, LeverSubsystem lever, LimitSensors sensors){
        addCommands(
            new ExtendorToPosition(extendor, sensors, Constants.EXTENDORSTARTPOSITION),
            new LeverToPosition(lever, sensors, Constants.LEVERSCOREPOSITION),
            new ExtendorToPosition(extendor, sensors, Constants.EXTENDORSCOREPOSITION),
            new DropObject(claw),
            new ExtendorToPosition(extendor, sensors, Constants.EXTENDORSTARTPOSITION),
            new LeverToPosition(lever, sensors, Constants.LEVERSTARTPOSITION)
        );
    }
}
