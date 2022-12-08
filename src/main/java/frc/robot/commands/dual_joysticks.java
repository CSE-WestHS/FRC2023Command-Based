package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivesystem;
import frc.robot.Robot;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
public class dual_joysticks extends CommandBase {
    private final drivesystem DriveSystem;
    public dual_joysticks(drivesystem subsystem) {
        DriveSystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
      }
      @Override
      public void execute() {
        double leftSpeed = OI.controller.getLeftY() * Constants.kMaxSpeed;
        double rightSpeed = OI.controller.getRightY() * -Constants.kMaxSpeed; 
        DriveSystem.setSpeed(leftSpeed, rightSpeed);

      }
    
}

