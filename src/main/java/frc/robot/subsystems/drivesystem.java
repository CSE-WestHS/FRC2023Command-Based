package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;



public class drivesystem extends SubsystemBase {
private final CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
private final CANSparkMax m_rearLeft = new CANSparkMax(2, MotorType.kBrushless);
private final CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
private final CANSparkMax m_rearRight = new CANSparkMax(4, MotorType.kBrushless);
private final MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_frontLeft, m_rearLeft);
private final MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_frontRight, m_rearRight);

private final DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  public drivesystem(){

    m_frontLeft.clearFaults();
    m_rearLeft.clearFaults();
    m_frontRight.clearFaults();
    m_rearRight.clearFaults();
    m_frontLeft.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_rearLeft.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_frontRight.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_rearRight.setSmartCurrentLimit(Constants.smartCurrentLimit);

    stopwheels();
  }  

  public void setSpeed(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
}
  @Override
  public void periodic() {
    stopwheels();
    // This method will be called once per scheduler run
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
    public void stopwheels(){
      m_frontLeft.stopMotor();
      m_rearLeft.stopMotor();
      m_frontRight.stopMotor();
      m_rearRight.stopMotor();
    }
}
