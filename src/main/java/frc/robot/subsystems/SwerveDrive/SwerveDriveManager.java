package frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.SwerveDrive.SwerveDriveModule;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveManager extends SubsystemBase{
    SwerveDriveModule frontRight;
    SwerveDriveModule frontLeft;
    SwerveDriveModule backRight;
    SwerveDriveModule backLeft;
    public SwerveDriveManager(){
       this.frontLeft = new SwerveDriveModule(
            Constants.FRONTLEFTDRIVEID, 
            Constants.FRONTLEFTSTEERID, 
            315, 
            Constants.FRONTLEFTENCODERID);
         this.frontRight = new SwerveDriveModule(
            Constants.FRONTRIGHTDRIVEID, 
            Constants.FRONTRIGHTSTEERID, 
            45, 
            Constants.FRONTRIGHTENCODERID);
        this.backLeft = new SwerveDriveModule(
            Constants.BACKLEFTDRIVEID, 
            Constants.BACKLEFTSTEERID, 
            225, 
            Constants.BACKLEFTENCODERID);
        this.backRight = new SwerveDriveModule(
            Constants.BACKRIGHTDRIVEID, 
             Constants.BACKRIGHTSTEERID, 
             135, 
             Constants.BACKRIGHTENCODERID);
    }
            /** Sets wheels to target angles. Values are target angles for each module starting from front right and going clockwise. */
    public void wheelsToAngles(int frontRightAngle, int backRightAngle, int backLeftAngle, int frontLeftAngle){
        /** Sets wheels to target angles. Values are target angles for each module starting from front right and going clockwise. */
        while(
            // Empty body of while statement, the action is in the alignedTo, this allows them to be synchronous.
            !frontRight.alignedTo(frontRightAngle) ||
            !frontLeft.alignedTo(frontLeftAngle)  ||
            !backRight.alignedTo(backRightAngle) ||
            !backLeft.alignedTo(backLeftAngle) 
         ){// if code acts up, put feedWatchdogs in here.
        }

    }
    // Make zeroWheels
    public void runDriveMotors(double speed){
        frontLeft.setSpeed(speed);
        frontRight.setSpeed(speed);
        backLeft.setSpeed(speed);
        backRight.setSpeed(speed);
    }
    /** Run function with joystick input. */
    public void translateFromCoords(double x, double y, double z){
        
        // Set up steeradjust later w/Z
        // Steering ADJ
        z *= 5;
        // inverting y
        y = y*-1;
        x = x*-1;
        double power = Math.sqrt((Math.pow(x, 2)+ Math.pow(y, 2) ));
        if (power != 0){
            // Funky math! -SB
            double normalAdjust = power/1;
            y *= normalAdjust;
            x *= normalAdjust;
            double angle = Math.atan(y/x) * 180 / Math.PI;
            angle -= 90;
            if (x<0){
                angle += 180;
            }
            // Angle and Direction!
            if (power>1){
                power = 1;
            }
            // Front wheel adjust
            if (angle < -45){
                angle += 360;
            }
            double adjFR = z;
            double adjFL = -z;
            double adjBR = z;
            double adjBL = -z;
            if ((-45 <= angle && angle < 45)){
                adjBL = -z;
                adjBR = -z;
            }
            if ((45 <= angle && angle < 135)){
                adjBL = -z;
                adjFL = -z;
            }
            if ((135 <= angle && angle < 225)){
                adjFR = -z;
                adjFL = -z;
            }
            SmartDashboard.putNumber("Direction", angle);
            SmartDashboard.putNumber("Power", power);
            System.out.println("Updated SMART");
            // Uncomment below lines, commented for sim only
            wheelsToAngles((int)(angle + adjFR), (int)(angle+ adjBR), (int)(angle+ adjBL), (int)(angle+ adjFL));
            
            runDriveMotors(power);

        }
        
            


    }
            /** Pivots right by default, at a set speed based on direction. Higher  absolute turnFactor means faster speed. */
    public void pivotInPlace(double turnFactor){
        boolean inverted = false;
        if (turnFactor < 0){
            inverted = true;
        }
        turnFactor = Math.abs(turnFactor);
        

        if (inverted){
            wheelsToAngles(315, 45, 135, 225);
        } else {
            wheelsToAngles(135, 225, 315, 45);
        }
        runDriveMotors(turnFactor);

        
    }
}
