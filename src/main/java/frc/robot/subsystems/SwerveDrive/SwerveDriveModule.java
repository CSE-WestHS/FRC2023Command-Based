package frc.robot.subsystems.SwerveDrive;
import com.ctre.phoenix.sensors.CANCoder;
import frc.robot.Constants;
import  com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
public class SwerveDriveModule {
    
    CANSparkMax driveMotor;
    CANSparkMax steerMotor;
    double DegreesFromFront;
    CANCoder encoder;
    boolean steeringInverted = Constants.SWERVESTEERINGMODULEINVERT;
    
    boolean driveMotorInverted;
    public SwerveDriveModule(int DriveMotorCan, int SteerMotorCan, double DegreesFromFront, int encoderID){
        /**
         * Driving motor, steering motor, and how many degrees it is from front Also encoder. 
         */
        driveMotor = new CANSparkMax(DriveMotorCan, MotorType.kBrushless);
        steerMotor = new CANSparkMax(SteerMotorCan, MotorType.kBrushless);
        this.DegreesFromFront = DegreesFromFront;
        encoder = new CANCoder(encoderID);
        driveMotor.clearFaults();
        steerMotor.clearFaults();
        driveMotor.setSmartCurrentLimit(Constants.SMARTCURRENTLIMIT);
        steerMotor.setSmartCurrentLimit(Constants.CLAWCURRENTLIMIT);
        driveMotor.setInverted(false);
        driveMotorInverted = false;
        steerMotor.setInverted(false);
        

    }
    public double getDegrees(){
        return encoder.getPosition() % 360;
    }
    public void invertDriveMotor(){
        if (driveMotorInverted = false){
            driveMotor.setInverted(true);
            driveMotorInverted = true;
        } else{
            driveMotor.setInverted(false);
            driveMotorInverted = false;
        }
    }
    public double calculateShortestDistance(int target, int current){
        target = target % 360;
        current = current % 360;
        double difference = target - current;
        if (difference > 180){
            difference -= 360;
        }
        if (Math.abs(difference) >90){
            invertDriveMotor();
            difference -= (90 * difference/Math.abs(difference));
        }
        return difference;


    }
    public void setAngle(int angle){
        angle = angle % 360;
        int degreesAsInt = (int)getDegrees();
        //double degreeShift = 0;
        // Implement auto-correction later
        double shortestDistance = calculateShortestDistance(angle, degreesAsInt);
        double degreeOff = shortestDistance;
        
        while (degreesAsInt != angle){
            // A switch case would be better. I also don't care. If it works, it works.
            
            if (degreeOff > 0 ^ steeringInverted){
                steerMotor.set(Constants.STEERSPEED);
            } else {
                steerMotor.set(-Constants.STEERSPEED);
            }
            degreeOff = calculateShortestDistance(angle, degreesAsInt);
             
            

        }
    }
}
