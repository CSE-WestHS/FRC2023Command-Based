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
/**
         * Driving motor, steering motor, and how many degrees it is from front Also encoder. 
         */
    public SwerveDriveModule(int DriveMotorCan, int SteerMotorCan, double DegreesFromFront, int encoderID){
        
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
     void invertDriveMotor(){
        if (!driveMotorInverted){
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
    /** IMPORTANT!!! READ DOCUMENTATION BEFORE USING!!!!
         * MUST be used in a way that would repeat, ie a while loop with this as the condition.
         * This way came to me in a dream, so it must be good. -SB
         */
    public boolean alignedTo(int angle){
        
        angle = angle % 360;
        int degreesAsInt = (int)getDegrees();
        double shortestDistance = calculateShortestDistance(angle, degreesAsInt);
        double degreeOff = shortestDistance;
        if (degreeOff == 0){
            steerMotor.stopMotor();
            return true;
        }
        // If oscillating or slow, change STEERSPEED. If not possible, add logic to change between 2 static speeds based on degreeOff
        if (degreeOff > 0 ^ steeringInverted){
            
            steerMotor.set(Constants.STEERSPEED);
            return false;
        } else {
            steerMotor.set(-Constants.STEERSPEED);
            return true;
        }

    }
    /** NO LONGER MAINTAINED!!! Only for use of one motor at a time. */
    public void setAngle(int angle){
        // Poor setAngle. Became deprecated before testing.
        
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
            degreesAsInt = (int)getDegrees();
            degreeOff = calculateShortestDistance(angle, degreesAsInt);
             
            

        }
        steerMotor.stopMotor();
    }
    public void setSpeed(double speed){
        driveMotor.set(speed);
    }
    public double getDegreesFromFront(){
        return DegreesFromFront;
    }
    }


