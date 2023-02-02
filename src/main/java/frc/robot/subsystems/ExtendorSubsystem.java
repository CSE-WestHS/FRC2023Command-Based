package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class ExtendorSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final CANSparkMax extendorMotor = new CANSparkMax(Constants.EXTENDORMOTORPORT, MotorType.kBrushless);

  public ExtendorSubsystem() {
    extendorMotor.clearFaults();
    extendorMotor.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    extendorMotor.set(0);
  }

  public void setSpeed(double speed){
    extendorMotor.set(speed);
  }

  public void stopMotor(){
    extendorMotor.set(0);
  }

  public double getEncoderPosition(){
    double encoderPosition = extendorMotor.getEncoder().getPosition();
    return encoderPosition;
  }

  public void resetEncoder(){
    extendorMotor.getEncoder().setPosition(0);
  }


}