package frc.robot.commands.SwerveCommands;

import frc.robot.subsystems.SwerveDrive.SwerveDriveManager;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveDrive extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final SwerveDriveManager m_swerve;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public SwerveDrive(SwerveDriveManager subsystem) {
      m_swerve = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
        double controllerX =  OI.DriveController.getX();
        double controllerY =  OI.DriveController.getY();
        double controllerZ = OI.DriveController.getZ();
        if (controllerX + controllerY != 0){
            m_swerve.translateFromCoords(controllerX, controllerY, controllerZ);
        } else {
            //  UNCOMMENT!!!
            m_swerve.pivotInPlace(controllerZ * 0.2); // Max rotation speed
        }
        
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }