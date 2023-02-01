package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final CANSparkMax clawMotor = new CANSparkMax(Constants.CLAWMOTORPORT, MotorType.kBrushless);
  private final CANSparkMax clawMotor2 = new CANSparkMax(Constants.CLAWTWOMOTORPORT, MotorType.kBrushless);

  public ClawSubsystem() {
    clawMotor.clearFaults();
    clawMotor2.clearFaults();
    clawMotor.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    clawMotor2.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    //mimics the other claw motor, as they do the same thing.
    clawMotor2.follow(clawMotor, true);
    clawMotor.set(0);
  }

  public void runClaw(double speed){
    clawMotor.set(speed);
  }

  public void stopClaw(){
    clawMotor.set(0);
  }
}
