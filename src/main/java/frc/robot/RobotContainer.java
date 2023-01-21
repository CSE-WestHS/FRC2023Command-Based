// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.BasicDrive.DriveBackward;
import frc.robot.commands.BasicDrive.DriveForward;
import frc.robot.commands.BasicDrive.TurnLeft;
import frc.robot.commands.BasicDrive.TurnRight;
import frc.robot.commands.Dual_Joysticks;
import frc.robot.commands.BasicAuto;
import frc.robot.commands.AprilTagCommands.*;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PhotonVisionManager;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem DriveSubsystem = new DriveSubsystem();
  
  private final Dual_Joysticks Dual_Joysticks = new Dual_Joysticks(DriveSubsystem);
  private final DriveForward DriveFiveRotations = new DriveForward(DriveSubsystem, 5.0, 0.5);
  private final DriveBackward DriveThreeRotoations = new DriveBackward(DriveSubsystem,3.0, 0.25 );
  private final TurnLeft Turn90Degrees = new TurnLeft(DriveSubsystem, 30, 0.5);
  private final TurnRight Turn180Degrees = new TurnRight(DriveSubsystem, 60, 0.5);
  PhotonVisionManager photon = new PhotonVisionManager();
  
  private final TurnToTag turnToTag5 = new TurnToTag(DriveSubsystem,photon, 5);
  private final DriveToTag driveToTag5 = new DriveToTag(DriveSubsystem, photon, 5);
  
  private final BasicAuto Auto = new BasicAuto(DriveSubsystem);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    // Configure the button bindings
    configureButtonBindings();
    DriveSubsystem.setDefaultCommand(Dual_Joysticks);
    photon.setCamera("Cam1");

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    OI.aButton.onTrue(DriveFiveRotations);
    OI.bButton.onTrue(DriveThreeRotoations);
    OI.xButton.onTrue(Turn90Degrees);
    OI.yButton.onTrue(Turn180Degrees);
    OI.startButton.onTrue(turnToTag5);
    OI.upDPButton.onTrue(driveToTag5);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  return Auto;
  }
  public PhotonVisionManager getPhoton(){
    return photon;
  }
  
}
