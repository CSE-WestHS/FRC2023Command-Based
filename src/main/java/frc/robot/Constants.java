// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.stuypulse.stuylib.network.SmartNumber;

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
    public static final int smartCurrentLimit = 40;
    public static final double kMaxSpeed = 0.5;

    public static SmartNumber BASE_TURNING_SPEED = new SmartNumber("Base Turn Speed", 0.45);
    public static SmartNumber INVERT_ANGLE_THREASHOLD = new SmartNumber(
            "Invert Steering, Angle Setpoint Threshold", 0.15);

    // Low Pass Filter and deadband for Driver Controls
    public static SmartNumber SPEED_DEADBAND = new SmartNumber("Speed Deadband", 0.00);
    public static SmartNumber ANGLE_DEADBAND = new SmartNumber("Turn Deadband", 0.10);

    public static SmartNumber MAX_SPEED_ANGLE = new SmartNumber("Max Speed Angle", 0.85);
    public static SmartNumber MAX_SPEED = new SmartNumber("Max Speed", 1.0);

    public static SmartNumber SPEED_POWER = new SmartNumber("Speed Power", 2.0);
    public static SmartNumber ANGLE_POWER = new SmartNumber("Turn Power", 1.0);

    public static SmartNumber SPEED_FILTER = new SmartNumber("Speed Filtering", 0.25);
    public static SmartNumber ANGLE_FILTER = new SmartNumber("Turn Filtering", 0.005);

    

}
