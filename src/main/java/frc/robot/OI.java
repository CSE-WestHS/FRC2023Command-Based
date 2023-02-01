package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
public class OI {



  
  public static XboxController DriveController = new XboxController(0);
  public static XboxController CraneController = new XboxController(1);
  // button bindings for Command use for DriveController
  //should be renamed to fit the purpose of the command it works with
  static Trigger aButton = new JoystickButton(DriveController, 0); // a button
  static Trigger bButton = new JoystickButton(DriveController, 1); // b button
  static Trigger xButton = new JoystickButton(DriveController, 2); // x button
  static Trigger yButton = new JoystickButton(DriveController, 3); // y button
  static Trigger startButton = new JoystickButton(DriveController, 7); // start button
  static Trigger backButton = new JoystickButton(DriveController, 6); // back button - being used to cancel commands, can be changed.
  static Trigger LBButton = new JoystickButton(DriveController, 4); // left bumper
  static Trigger RBButton = new JoystickButton(DriveController, 5); // right bumper
  static Trigger downDPButton = new POVButton(DriveController, 180); // down on D-Pad
  static Trigger upDPButton = new POVButton(DriveController, 0); // up on D-Pad
  static Trigger leftDPButton = new POVButton(DriveController, 270); // left on D-Pad
  static Trigger rightDPButton = new POVButton(DriveController, 90); // right on D-Pad

  //button bindings for Command use on CraneController
  //should be renamed to fit the purpose of the command it works with
  static Trigger aButton2 = new JoystickButton(CraneController, 0); // a button
  static Trigger bButton2 = new JoystickButton(CraneController, 1); // b button
  static Trigger xButton2 = new JoystickButton(CraneController, 2); // x button
  static Trigger yButton2 = new JoystickButton(CraneController, 3); // y button
  static Trigger startButton2 = new JoystickButton(CraneController, 7); // start button
  static Trigger backButton2 = new JoystickButton(CraneController, 6); // back button - being used to cancel commands, can be changed.
  static Trigger LBButton2 = new JoystickButton(CraneController, 4); // left bumper
  static Trigger RBButton2 = new JoystickButton(CraneController, 5); // right bumper
  static Trigger downDPButton2 = new POVButton(CraneController, 180); // down on D-Pad
  static Trigger upDPButton2 = new POVButton(CraneController, 0); // up on D-Pad
  static Trigger leftDPButton2 = new POVButton(CraneController, 270); // left on D-Pad
  static Trigger rightDPButton2 = new POVButton(CraneController, 90); // right on D-Pad
}