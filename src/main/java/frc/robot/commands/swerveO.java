package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
public class swerveO extends CommandBase {
    private SwerveSubsystem swerve;
    public swerveO(SwerveSubsystem s){
        super();
        swerve = s;
        addRequirements(s);
    }
    @Override
    public void execute() {
        swerve.drive();
    }
    
}
