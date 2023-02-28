package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class LeverSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final CANSparkMax craneMotor = new CANSparkMax(Constants.CRANEMOTORPORT, MotorType.kBrushless);

  public LeverSubsystem() {
    craneMotor.clearFaults();
    craneMotor.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    craneMotor.set(0);
  }

  public void setSpeed(double speed){
    craneMotor.set(speed);
  }

  public void stopMotor(){
    craneMotor.set(0);
  }

  public double getEncoderPosition(){
    double encoderPosition = craneMotor.getEncoder().getPosition();
    return encoderPosition;
  }

  public void resetEncoder(){
    craneMotor.getEncoder().setPosition(0);
  }

}
