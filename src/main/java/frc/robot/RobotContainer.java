// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.BasicDrive.DriveBackward;
import frc.robot.commands.BasicDrive.DriveForward;
import frc.robot.commands.BasicDrive.TurnLeft;
import frc.robot.commands.BasicDrive.TurnRight;
import frc.robot.commands.Dual_Joysticks;
import frc.robot.commands.BasicAuto;

import frc.robot.subsystems.DriveSubsystem;
  


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
  
  private final BasicAuto Auto = new BasicAuto(DriveSubsystem);

  private final Command m_BasicAuto1 = DriveFiveRotations;
  private final Command m_BasicAuto2 = DriveThreeRotoations;
  private final Command m_BasicAuto3 = Turn90Degrees;
  private final Command m_BasicAuto4 = Turn180Degrees;

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    // Configure the button bindings
    configureButtonBindings();
    DriveSubsystem.setDefaultCommand(Dual_Joysticks);
    SmartDashboard.putData(DriveSubsystem);
    SmartDashboard.putData("BasicAuto", new BasicAuto(DriveSubsystem));
    SmartDashboard.putData("DriveBackward", new DriveBackward(DriveSubsystem, 5, 0.5));
    SmartDashboard.putData("DriveForward", new DriveForward(DriveSubsystem, 5, 0.5));
    SmartDashboard.putData("TurnLeft", new TurnLeft(DriveSubsystem, 5, 0.5));
    SmartDashboard.putData("TurnRight", new TurnRight(DriveSubsystem, 5, 0.5));
    
  m_chooser.setDefaultOption("DriveBackward", m_BasicAuto1);
  m_chooser.addOption("DriveForward", m_BasicAuto2);
  m_chooser.addOption("TurnLeft", m_BasicAuto3);
  m_chooser.addOption("TurnRight", m_BasicAuto4);

  SmartDashboard.putData(m_chooser);

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
  }
 
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }


}
