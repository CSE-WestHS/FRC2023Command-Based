package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
public class OI {



  //creates Xbox Controllers for robot control
  public static XboxController DriveController = new XboxController(0);
  public static XboxController CraneController = new XboxController(1);
  // button bindings for Command use for DriveController
  //should be renamed to fit the purpose of the command it works with
  static Trigger aButton = new JoystickButton(DriveController, Constants.A_BUTTONPORT); // a button
  static Trigger bButton = new JoystickButton(DriveController, Constants.B_BUTTONPORT); // b button
  static Trigger xButton = new JoystickButton(DriveController, Constants.X_BUTTONPORT); // x button
  static Trigger yButton = new JoystickButton(DriveController, Constants.Y_BUTTONPORT); // y button
  static Trigger startButton = new JoystickButton(DriveController, Constants.START_BUTTONPORT); // start button
  static Trigger backButton = new JoystickButton(DriveController, Constants.BACK_BUTTONPORT); // back button - being used to cancel commands, can be changed.
  static Trigger LBButton = new JoystickButton(DriveController, Constants.LB_BUTTONPORT); // left bumper
  static Trigger RBButton = new JoystickButton(DriveController, Constants.RB_BUTTONPORT); // right bumper
  static Trigger downDPButton = new POVButton(DriveController, Constants.DP_DOWN_BUTTONPORT); // down on D-Pad
  static Trigger upDPButton = new POVButton(DriveController, Constants.DP_UP_BUTTONPORT); // up on D-Pad
  static Trigger leftDPButton = new POVButton(DriveController, Constants.DP_LEFT_BUTTONPORT); // left on D-Pad
  static Trigger rightDPButton = new POVButton(DriveController, Constants.DP_RIGHT_BUTTONPORT); // right on D-Pad

  //button bindings for Command use on CraneController
  //should be renamed to fit the purpose of the command it works with
  static Trigger aButton2 = new JoystickButton(CraneController, Constants.A_BUTTONPORT); // a button
  static Trigger bButton2 = new JoystickButton(CraneController, Constants.B_BUTTONPORT); // b button
  static Trigger xButton2 = new JoystickButton(CraneController, Constants.X_BUTTONPORT); // x button
  static Trigger yButton2 = new JoystickButton(CraneController, Constants.Y_BUTTONPORT); // y button
  static Trigger startButton2 = new JoystickButton(CraneController, Constants.START_BUTTONPORT); // start button
  static Trigger backButton2 = new JoystickButton(CraneController, Constants.BACK_BUTTONPORT); // back button - being used to cancel commands, can be changed.
  static Trigger LBButton2 = new JoystickButton(CraneController, Constants.LB_BUTTONPORT); // left bumper
  static Trigger RBButton2 = new JoystickButton(CraneController, Constants.RB_BUTTONPORT); // right bumper
  static Trigger downDPButton2 = new POVButton(CraneController, Constants.DP_DOWN_BUTTONPORT); // down on D-Pad
  static Trigger upDPButton2 = new POVButton(CraneController, Constants.DP_UP_BUTTONPORT); // up on D-Pad
  static Trigger leftDPButton2 = new POVButton(CraneController, Constants.DP_LEFT_BUTTONPORT); // left on D-Pad
  static Trigger rightDPButton2 = new POVButton(CraneController, Constants.DP_RIGHT_BUTTONPORT); // right on D-Pad
}
