package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivesystem;
import frc.robot.Robot;
import frc.robot.Constants;

public class SpecificDistance extends CommandBase {
    private final drivesystem DriveSystem;
    private final int ft;

    public SpecificDistance(drivesystem subsystem, int Distance) {
        DriveSystem = subsystem;
        ft = Distance;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }



    @Override
    public void initialize() {
    DriveSystem.m_encoderFL.reset;
    }



    @Override
    public void execute() {}
    
    @Override
    public void end(boolean interupted) {
    }
    

    @Override
    public boolean isFinished() {
      return true;
    }


















}
