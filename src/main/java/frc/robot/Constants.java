// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {



    



    
    
   //#region Ports
   public static final int CONTROLLERPORT = 0;
   public static final int FRONTLEFTID = 2;
   public static final int REARLEFTID = 4;
   public static final int FRONTRIGHTID = 3;
   public static final int REARRIGHTID = 5;
    public static final int EXTENDORMOTORPORT = 6;
    public static final int CRANEMOTORPORT = 1;
    public static final int CLAWMOTORPORT = 7;
    public static final int CLAWTWOMOTORPORT = 8;
    //#endregion
    //#region DriveSubsystem Constants
    public static final int SMARTCURRENTLIMIT = 60;
    public static final int CLAWCURRENTLIMIT = 15;
    public static final double MAXSPEED = 0.8;
    public static final int ENCODERSTARTINGPOSITION = 0;
    public static final int ENCODERRESETINGPOSITION = 0;
    public static final double ENCODER_CONVERSION_FACTOR = 0.5; //conversion factor for Drive Encoders to make the distance in feet
    public static final double AUTO_DRIVE_DISTANCE = 15;
    public static final double AUTO_DRIVE_SPEED = 0.75;
    //#endregion
    //#region Balance Constants
    public static final double DISTANCEMULTIPLIER = 0.035;
    public static final double STEERINGMULTIPLIER = 0.01;
    public static final double MINAIM = 0.05;
    public static final double LEVELPITCH = 3;
    public static final double YAWTHRESHOLD = 5;
    public static final double RAMPPITCH = 12;
    public static final double LEVELTIME = 3.0;
    //#endregion
    //#region OI Constants
    //XBOX CONTROLLER CONSTANTS
    public static final int A_BUTTONPORT = 1;
    public static final int B_BUTTONPORT = 2;
    public static final int X_BUTTONPORT = 3;
    public static final int Y_BUTTONPORT = 4;
    public static final int LB_BUTTONPORT = 5;
    public static final int RB_BUTTONPORT = 6;
    public static final int BACK_BUTTONPORT = 7;
    public static final int START_BUTTONPORT = 8;
    public static final int DP_UP_BUTTONPORT = 0;
    public static final int DP_RIGHT_BUTTONPORT = 90;
    public static final int DP_DOWN_BUTTONPORT = 180;
    public static final int DP_LEFT_BUTTONPORT = 270;

    //JOYSTICK CONTROLLER CONSTANTS
    public static final int LEVER_MOVE_BUTTONPORT = 1;
    public static final int CLAW_GRAB_BUTTONPORT = 3;
    public static final int CLAW_RELEASE_BUTTONPORT = 4;
    public static final int EXTENDOR_IN_POV = 180;
    public static final int EXTENDOR_OUT_POV = 0;
    public static final int BALANCE_BUTTON = 14;

    //#endregion
    //#region Crane Constants
    public static final double EXTENDORSPEED = 0.7;
    public static final double LEVERSPEED = .75;
    public static final double CLAWSPEED = 0.6;
    public static final double CLAWTIME = 3.0;
    public static final double LEVERSTARTPOSITION = 0;
    public static final double EXTENDORSTARTPOSITION = 1.0;
    public static final double LEVEREXTENDORPOSITION = 45.0;
    public static final double LEVERSCOREPOSITION = 95.0;
    public static final double EXTENDORSCOREPOSITION = 19.5;
    //#endregion
    ////#region LimitSensors
    public static final int DIO_BACK = 0;
    public static final int DIO_FRONT = 1;
    // Is that a JoJo reference?
    public static final int ANALOG_STRINGPOT = 0;
    // Stands for String Potentiometer 
    public static final double EXTENDOR_MAX = 48.00;
    public static final double EXTENDOR_MIN = 0.0;
    public static final double ANALOG_VOLTS_MIN = 0.0;
    public static final double ANALOG_VOLTS_MAX = 5.0;
    public static final boolean EXTENDOR_SENSOR_INVERTED = true;



    ////#endregion LimitSensors
    public static final double STEERSPEED = 0.7;
    public static final boolean SWERVESTEERINGMODULEINVERT = false;
    // Just temporary, set to values needed.
    public static final int FRONTLEFTDRIVEID = 1;
    public static final int FRONTLEFTSTEERID = 2;
    public static final int FRONTLEFTENCODERID = 3;
    public static final int FRONTRIGHTDRIVEID = 4;
    public static final int FRONTRIGHTSTEERID = 5;
    public static final int FRONTRIGHTENCODERID = 6;
    public static final int BACKLEFTDRIVEID = 7;
    public static final int BACKLEFTSTEERID = 8;
    public static final int BACKLEFTENCODERID = 9;
    public static final int BACKRIGHTDRIVEID = 10;
    public static final int BACKRIGHTSTEERID = 11;
    public static final int BACKRIGHTENCODERID = 12;
}








