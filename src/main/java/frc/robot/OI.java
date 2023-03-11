package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
public class OI {



  //creates Xbox Controllers for robot control
  public static Joystick DriveController = new Joystick(0);
  public static Joystick CraneController = new Joystick(1);
  // button bindings for Command use for DriveController
  //should be renamed to fit the purpose of the command it works with
  static Trigger balanceButton = new JoystickButton(CraneController, Constants.BALANCE_BUTTON);
  //button bindings for Command use on CraneController
  //should be renamed to fit the purpose of the command it works with
  static Trigger clawGrabButton = new JoystickButton(CraneController, Constants.CLAW_GRAB_BUTTONPORT);
  static Trigger clawReleaseButton = new JoystickButton(CraneController, Constants.CLAW_RELEASE_BUTTONPORT);
  static Trigger leverMoveButton = new JoystickButton(CraneController, Constants.LEVER_MOVE_BUTTONPORT);
  static Trigger extendorInButton = new POVButton(CraneController, Constants.EXTENDOR_IN_POV);
  static Trigger extendorOutButton = new POVButton(CraneController, Constants.EXTENDOR_OUT_POV);
  static Trigger autoTestButton = new JoystickButton(DriveController, 15);
}
