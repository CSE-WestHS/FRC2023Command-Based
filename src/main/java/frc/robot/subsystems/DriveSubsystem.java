package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import com.stuypulse.stuylib.math.SLMath;

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

    m_frontLeft.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    m_rearLeft.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    m_frontRight.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
    m_rearRight.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);

    m_leftGroup.setInverted(false);
    m_rightGroup.setInverted(true);

    flEncoder.setPosition(0);
    frEncoder.setPosition(0);
    rlEncoder.setPosition(0);
    rrEncoder.setPosition(0);

    stopWheels();
  }

  // sets the speed of both sides to the specific speed
  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  // Drives using arcade drive
  public void arcadeDrive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation, false);
  }

  // Drives using curvature drive algorithm
  public void curvatureDrive(double xSpeed, double zRotation, double baseTS) {
    // Clamp all inputs to valid values
    xSpeed = SLMath.clamp(xSpeed, -1.0, 1.0);
    zRotation = SLMath.clamp(zRotation, -1.0, 1.0);
    baseTS = SLMath.clamp(baseTS, 0.0, 1.0);

    // Find the amount to slow down turning by.
    // This is proportional to the speed but has a base value
    // that it starts from (allows turning in place)
    double turnAdj = Math.max(baseTS, Math.abs(xSpeed));


    // Find the speeds of the left and right wheels
    double lSpeed = xSpeed + zRotation * turnAdj;
    double rSpeed = xSpeed - zRotation * turnAdj;

    // Find the maximum output of the wheels, so that if a wheel tries to go > 1.0
    // it will be scaled down proportionally with the other wheels.
    double scale = Math.max(1.0, Math.max(Math.abs(lSpeed), Math.abs(rSpeed)));

    lSpeed /= scale;
    rSpeed /= scale;

    // Feed the inputs to the drivetrain
    tankDrive(lSpeed, rSpeed);
  }
  public void curvatureDrive(double xSpeed, double zRotation) {
    this.curvatureDrive(xSpeed, zRotation, 0.45);
}

  // Drives using curvature drive, but inverts the steering when driving backwards
  public void impulseDrive(double xSpeed, double zRotation) {
    // If the speed is negative and the steering setpoint is small, then invert the
    // steering controls
    if (xSpeed < -0.05 && Math.abs(zRotation) < 0.15) {
      curvatureDrive(xSpeed, zRotation,Constants.BASE_TURNING_SPEED.get()); // Inverted steering
    } else {
      curvatureDrive(xSpeed, -zRotation, Constants.BASE_TURNING_SPEED.get()); // Standard steering
    }
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
    m_drive.stopMotor();
  }
}
