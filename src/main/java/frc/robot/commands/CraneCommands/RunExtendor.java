package frc.robot.commands.CraneCommands;

import frc.robot.subsystems.ExtendorSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;
import frc.robot.LimitSensors;

/** An example command that uses an example subsystem. */
public class RunExtendor extends CommandBase {

  private final ExtendorSubsystem extendor;
  private final boolean invert;
  private LimitSensors sensors;
  /**
   * Command that runs the claw motors for a short amount of time, releasing what ever object 
   *
   * @param claw The subsystem used by this command.
   * @param invert whether motor intakes object or spits it out.
   */
  public RunExtendor(ExtendorSubsystem extendor, boolean invert, LimitSensors sensors) {
    this.extendor = extendor;
    this.invert = invert;
    this.sensors = sensors;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(extendor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    extendor.setSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    boolean hitLimit;
    hitLimit = false;
    if (invert ^ Constants.EXTENDOR_SENSOR_INVERTED){
      if (sensors.GetExtendorPos() > 20){
        hitLimit = true;
      }
    }else {
      if (sensors.GetExtendorPos() < 1){
        hitLimit = true;
      }
    }
    if (!hitLimit){
    extendor.setSpeed(Constants.LEVERSPEED);

    if(invert){extendor.setSpeed(-Constants.EXTENDORSPEED);}
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    extendor.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
