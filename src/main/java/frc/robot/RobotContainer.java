// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.BasicDrive.*;
import frc.robot.commands.BalanceSteps.*;
import frc.robot.commands.BalanceSteps.DriveTillDegrees;
import frc.robot.commands.Dual_Joysticks;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NavchipManager;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public final NavchipManager navchipManager = new NavchipManager();

  //
  
  // basic drive commands
  private final Dual_Joysticks Dual_Joysticks = new Dual_Joysticks(DriveSubsystem);
  private final DriveForward DriveFiveRotations = new DriveForward(DriveSubsystem, 5.0, 0.5);
  private final DriveBackward DriveThreeRotoations = new DriveBackward(DriveSubsystem, 3.0, 0.25);
  private final TurnLeft Turn90Degrees = new TurnLeft(DriveSubsystem, navchipManager, 90, 0.5);
  private final TurnRight Turn180Degrees = new TurnRight(DriveSubsystem, navchipManager, 180, 0.3);
  
  // balance commands
  private final DriveTillDegrees driveTillDegrees = new DriveTillDegrees(DriveSubsystem, navchipManager);
  private final Balance balance = new Balance(DriveSubsystem, navchipManager);

  // auto commands
  private final AutoBalance autoBalance = new AutoBalance(DriveSubsystem, navchipManager);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
    DriveSubsystem.setDefaultCommand(Dual_Joysticks);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    OI.aButton.onTrue(DriveFiveRotations);
    OI.bButton.onTrue(DriveThreeRotoations);
    OI.xButton.onTrue(Turn90Degrees);
    OI.yButton.onTrue(Turn180Degrees);
    OI.LBButton.onTrue(driveTillDegrees);
    OI.RBButton.onTrue(balance);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoBalance;
  }
}
