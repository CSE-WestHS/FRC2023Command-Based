package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.BasicDrive.*;

public class BasicAuto extends SequentialCommandGroup {

    public BasicAuto(DriveSubsystem DriveSystem) {
        addCommands(
                new DriveForward(DriveSystem, 30, 0.5),
                new TurnLeft(DriveSystem, 60, 0.5),

                new DriveForward(DriveSystem, 30, 0.5),
                new TurnLeft(DriveSystem, 60, 0.5),

                new DriveForward(DriveSystem, 30, 0.5),
                new TurnLeft(DriveSystem, 60, 0.5),

                new DriveForward(DriveSystem, 30, 0.5),
                new TurnLeft(DriveSystem, 60, 0.5));
    }

}