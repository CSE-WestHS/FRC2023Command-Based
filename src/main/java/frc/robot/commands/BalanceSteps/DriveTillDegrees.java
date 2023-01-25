package frc.robot.commands.BalanceSteps;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NavchipManager;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTillDegrees extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final NavchipManager NavchipManager;
    /// pitch of Nav to be used when determining if it is fully on ramp or not
    private float pitch;

    public DriveTillDegrees(DriveSubsystem driveSystem, NavchipManager NAV) {
        driveSubsystem = driveSystem;
        NavchipManager = NAV;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(driveSystem, NAV);

    }

    @Override

    public void initialize() {
        // stop the motors
        driveSubsystem.stopwheels();

    }

    @Override
    public void execute() {
        // driveforward at a decent speed,
        // powerful enough to get on, slow enough to stay in control
        driveSubsystem.setSpeed(0.5, 0.5);

        // check value of NavChip
        pitch = NavchipManager.getPitch();
    }

    @Override
    public void end(boolean interrupted) {
        // stop the motors
        driveSubsystem.stopwheels();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {

        // finished when robot is on ramp and NavChip reads that it is tilted.
        // number should be changed to match tests
        System.out.print("Robot on Ramp");
        return pitch >= 12 || pitch <= -12;

    }
}
