package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private final CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_rearLeft = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax m_rearRight = new CANSparkMax(4, MotorType.kBrushless);
  private final MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_frontLeft, m_rearLeft);
  private final MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_frontRight, m_rearRight);

  private final RelativeEncoder flEncoder = m_frontLeft.getEncoder();
  private final RelativeEncoder frEncoder = m_frontRight.getEncoder();
  private final RelativeEncoder rlEncoder = m_rearLeft.getEncoder();
  private final RelativeEncoder rrEncoder = m_rearRight.getEncoder();

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  public DriveSubsystem() {

    m_frontLeft.clearFaults();
    m_rearLeft.clearFaults();
    m_frontRight.clearFaults();
    m_rearRight.clearFaults();

    m_frontLeft.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_rearLeft.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_frontRight.setSmartCurrentLimit(Constants.smartCurrentLimit);
    m_rearRight.setSmartCurrentLimit(Constants.smartCurrentLimit);

    m_leftGroup.setInverted(false);
    m_rightGroup.setInverted(true);

    flEncoder.setPosition(0);
    frEncoder.setPosition(0);
    rlEncoder.setPosition(0);
    rrEncoder.setPosition(0);

    stopWheels();
  }

  // sets the speed of both sides to the specific speed
  public void setSpeed(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  // resets the position of the inputted encoder
  public void resetEncoders() {
    flEncoder.setPosition(0);
    frEncoder.setPosition(0);
    rlEncoder.setPosition(0);
    rrEncoder.setPosition(0);
  }

  // returns the value of the position of the encoder in rotations.
  public double getEncoderPosition() {
    return flEncoder.getPosition();
  }

  // returns the value of the velocity of the inputted encoder
  public double getEnoderSpeed() {
    return flEncoder.getVelocity();
  }

  // stops the wheels on the robot
  public void stopWheels() {
    m_frontLeft.stopMotor();
    m_rearLeft.stopMotor();
    m_frontRight.stopMotor();
    m_rearRight.stopMotor();
  }

}
