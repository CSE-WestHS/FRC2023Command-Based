package frc.robot.commands.BalanceSteps;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NavchipManager;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

public class Balance extends CommandBase {

    private final DriveSubsystem DriveSubsystem;
    private final NavchipManager NavchipManager;
    // timer is used to check how long robot stays level
    private final Timer Timer = new Timer();
    float pitch;
    float desiredYaw;
    float currentYaw;

    public Balance(DriveSubsystem driveSystem, NavchipManager NAV) {

        DriveSubsystem = driveSystem;
        NavchipManager = NAV;
        addRequirements(driveSystem);

    }

    @Override
    public void initialize() {
        DriveSubsystem.stopwheels();
        Timer.stop();
        Timer.reset();
        desiredYaw = NavchipManager.getYaw();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // update pitch reading and error
        pitch = NavchipManager.getPitch();
        currentYaw = NavchipManager.getYaw();
        // if robot isn't level
        if (pitch >= 3 || pitch <= -3) {
            //Reset timer
            Timer.reset();
            Timer.stop();
            //Figure out speed at which to drive
            double driveAdj = pitch * Constants.distanceMult;
            double steerAdj = 0.0;
            //Figure out how much to turn
            if (currentYaw >= desiredYaw - 5 || currentYaw <= desiredYaw + 5) {
                steerAdj = currentYaw * Constants.steerMult;
            }

            //set speeds
            double leftSpd = -steerAdj + driveAdj;
            double rightSpd = steerAdj + driveAdj;
            DriveSubsystem.setSpeed(leftSpd, rightSpd);
        }

        // if robot is level
        else if (pitch <= 2 && pitch >= -2) {
            DriveSubsystem.stopwheels();
            Timer.start();
        }

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Timer.stop();
        Timer.reset();
        DriveSubsystem.stopwheels();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {

        // end if NavChip is level and has stayed level for a period of time
        boolean isLevel = pitch <= 3 && pitch >= -3;
        return isLevel && Timer.get() > 3.0;
    }
}
