package frc.robot.subsystems; // Uncomment in implementation

import com.kauailabs.navx.frc.AHRS;
import java.util.Timer;
import edu.wpi.first.wpilibj.SPI;
import java.time.Instant;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Dependency needs vendordep https://dev.studica.com/releases/2023/NavX.json
public class NavchipManager extends SubsystemBase {
    AHRS ahrs;
    long bootupTimestamp;
    long lastTimestamp;
    float XPosition;
    float YPosition;
    float lastVelocity;

    public NavchipManager() {
        // Instantiates a new one if called
        ahrs = new AHRS(SPI.Port.kMXP);
        ahrs.calibrate();
        bootupTimestamp = Instant.now().getEpochSecond();
        lastTimestamp = bootupTimestamp;
        lastVelocity = (float) 0.0;
    }

    public NavchipManager(AHRS newAhrs) {
        ahrs = newAhrs;
        ahrs.calibrate();
        bootupTimestamp = Instant.now().getEpochSecond();
        lastTimestamp = bootupTimestamp;
        lastVelocity = (float) 0.0;
        // Uses the given AHRS if one is provided
    }

    public float getYaw() {
        // Pitch of gyroscope in degrees
        return ahrs.getYaw();

    }

    public float getPitch() {
        // Yaw of gyroscope in degrees
        return ahrs.getPitch();
    }

    public float getRoll() {
        // Roll
        return ahrs.getRoll();
    }

    public float getVelocity(String axis) {
        // X and Z flipped to account for orientation. Metres/sec
        if (axis.equalsIgnoreCase("X")) {
            return ahrs.getVelocityX();
        }
        if (axis.equalsIgnoreCase("y")) {
            return ahrs.getVelocityY();
        }
        if (axis.equalsIgnoreCase("Z")) {
            return ahrs.getVelocityZ();
        }
        return (float) 0.0;
    }

    public float getXPosition() {
        return XPosition;
    }

    public float getYPosition() {
        return YPosition;
    }

    public void displayAllAxes() {
        SmartDashboard.putNumber("Pitch", getPitch());
        SmartDashboard.putNumber("Roll", getRoll());
        SmartDashboard.putNumber("Yaw", getYaw());
        SmartDashboard.putNumber("XVelocity", getVelocity("X"));
        SmartDashboard.putNumber("YVelocity", getVelocity("Y"));
        SmartDashboard.putNumber("ZVelocity", getVelocity("Z"));
        SmartDashboard.putNumber("XPosition", XPosition);
        SmartDashboard.putNumber("YPosition", YPosition);

    }

    public void update() {
        long time = Instant.now().getEpochSecond();
        float velocity = getVelocity("y");
        long timeDifference = time - lastTimestamp; // Milliseconds
        float velocityDifference = (velocity + lastVelocity) / 2; // Metres/second
        lastTimestamp = time;
        lastVelocity = velocity;
        float newV = (float) (Math.floor(velocityDifference * 1000)) / 1000;
        float actualDistance = (float) ((newV * timeDifference * 1000) * getPitch());// (Math.cos((getPitch()/ 180 )*
                                                                                     // Math.PI))); // Actual distance
                                                                                     // in metres
        YPosition += Math.sin((getYaw() / 180) * Math.PI) * actualDistance; // Displacement x in metres
        XPosition -= Math.cos((getYaw() / 180) * Math.PI) * actualDistance; // Displacement y in metres

    }

}