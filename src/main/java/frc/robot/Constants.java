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
    // Ports
    public static final int EXTENDORMOTORPORT = 5;
    public static final int CRANEMOTORPORT = 6;
    public static final int CLAWMOTORPORT = 7;
    public static final int CLAWTWOMOTORPORT = 8;

    //DriveSubsystem Constants
    public static final int SMARTCURRENTLIMIT = 40;
    public static final double MAXSPEED = 0.5;

    //Balance Constants
    public static final double DISTANCEMULTIPLIER = 0.035;
    public static final double STEERINGMULTIPLIER = 0.01;
    public static final double MINAIM = 0.05;

    //OI Constants

    //
}
