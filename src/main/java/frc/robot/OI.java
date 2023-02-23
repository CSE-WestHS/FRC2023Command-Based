package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class OI {

  //Creates Xbox Controller
  public static XboxController noCommandController = new XboxController(Constants.CONTROLLERPORT);
  public static CommandXboxController Controller = new CommandXboxController(Constants.CONTROLLERPORT);
  
  //for use when we don't want to bind a button to a command
  
  // button bindings for Command use
  static Trigger aButton = Controller.a(); // a button
  static Trigger bButton = Controller.b(); // b button
  static Trigger xButton = Controller.x(); // x button
  static Trigger yButton = Controller.y(); // y button
  static Trigger startButton = Controller.start(); // start button
  static Trigger backButton = Controller.back(); // back button - being used to cancel commands, can be changed.
  static Trigger LBButton = Controller.leftBumper(); // left bumper
  static Trigger RBButton = Controller.rightBumper(); // right bumper
  static Trigger downDPButton = Controller.povDown(); // down on D-Pad
  static Trigger upDPButton = Controller.povUp(); // up on D-Pad
  static Trigger leftDPButton = Controller.povLeft(); // left on D-Pad
  static Trigger rightDPButton = Controller.povRight(); // right on D-Pad
  static Trigger centerDPButton = Controller.povCenter(); // center on D-Pad

}