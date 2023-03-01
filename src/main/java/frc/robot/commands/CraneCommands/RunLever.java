package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.LeverSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.LimitSensors;
import frc.robot.OI;
//import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class RunLever extends CommandBase {

  private final LeverSubsystem lever;
  private boolean invert;
  private boolean hitLimit;
  LimitSensors sensors;
  /**
   * Command that runs the claw motors for a short amount of time, releasing what ever object 
   *
   * @param claw The subsystem used by this command.
   */
  public RunLever(LeverSubsystem lever, LimitSensors sensors) {
    // Limit switch associated goes in last boolean, if none set it to false.
    this.lever = lever;
    this.sensors = sensors;
    //this.hitLimit = hitLimit;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(lever);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lever.setSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    invert = OI.CraneController.getY() >= 0.1;
    if (invert){
      hitLimit = sensors.CraneSwitchedFront();
    } else{
      hitLimit = sensors.CraneSwitchedBack();
    }
    if (!hitLimit){
      //SmartDashboard.putBoolean("Tripped", false);
      lever.setSpeed(OI.CraneController.getY() * Constants.LEVERSPEED);
  
    } else {

      lever.setSpeed(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lever.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hitLimit;
  }
}
