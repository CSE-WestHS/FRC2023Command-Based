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
   public static final int FRONTLEFTID = 5;
   public static final int REARLEFTID = 2;
   public static final int FRONTRIGHTID = 3;
   public static final int REARRIGHTID = 4;
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
    //#endregion
    //#region Crane Constants
    public static final double EXTENDORSPEED = 0.7;
    public static final double LEVERSPEED = .75;
    public static final double CLAWSPEED = 0.4;
    public static final double CLAWTIME = 3.0;
    public static final double LEVERSTARTPOSITION = 0;
    public static final double EXTENDORSTARTPOSITION = 0;
    //#endregion
}








