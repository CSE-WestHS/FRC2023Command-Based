package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import frc.robot.OI;

public class Dual_Joysticks extends CommandBase {
  private final DriveSubsystem DriveSubsystem;

  public Dual_Joysticks(DriveSubsystem subsystem) {
    DriveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    double leftSpeed = OI.Controller.getLeftY() * Constants.kMaxSpeed;
    double rightSpeed = OI.Controller.getRightY() * Constants.kMaxSpeed;
    DriveSubsystem.setSpeed(leftSpeed, rightSpeed);

  }

}
