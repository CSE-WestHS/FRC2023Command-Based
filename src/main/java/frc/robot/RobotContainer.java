// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.BasicDrive.*;
import frc.robot.commands.AutonomousCommands.AutoBalance;
import frc.robot.commands.BalanceSteps.*;
import frc.robot.commands.CraneCommands.*;
import frc.robot.commands.AutonomousCommands.*;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtendorSubsystem;
import frc.robot.subsystems.LeverSubsystem;
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

  public final LimitSensors sensors = new LimitSensors();

  private final ClawSubsystem clawSubsystem = new ClawSubsystem();
  private final ExtendorSubsystem extendorSubsystem = new ExtendorSubsystem();
  private final LeverSubsystem leverSubsystem = new LeverSubsystem();


  // basic drive commands
  private final Dual_Joysticks Dual_Joysticks = new Dual_Joysticks(DriveSubsystem);
  
  // balance commands
  private final Balance balance = new Balance(DriveSubsystem, navchipManager);

  // crane commands

  // command to bring lever to its starting position
  private final LeverToPosition LeverStartPosition = new LeverToPosition(leverSubsystem, sensors, Constants.LEVERSTARTPOSITION);
  private final RunLever ManualLever = new RunLever(leverSubsystem, sensors);
  // command to bring Extendor to its starting position
  private final ExtendorToPosition ExtendorStartPosition = new ExtendorToPosition(extendorSubsystem, sensors, Constants.EXTENDORSTARTPOSITION);
  private final RunExtendor ExtendOut = new RunExtendor(extendorSubsystem, false);
  private final RunExtendor ExtendIn = new RunExtendor(extendorSubsystem, true);

  // commands to run the claw
  private final DropObject dropObject = new DropObject(clawSubsystem);
  private final RunClaw intakeClaw = new RunClaw(clawSubsystem, false);
  private final RunClaw outtakeClaw = new RunClaw(clawSubsystem, true);

  // auto commands
  private final AutoBalance autoBalance = new AutoBalance(DriveSubsystem, navchipManager);
  private final DriveBackward SimpleAuto = new DriveBackward(DriveSubsystem, Constants.AUTO_DRIVE_DISTANCE, Constants.AUTO_DRIVE_SPEED);
  private final AutoScore autoScore = new AutoScore(extendorSubsystem, leverSubsystem, clawSubsystem, sensors, DriveSubsystem);
  private final ScoreAndBalance scoreAndBalance = new ScoreAndBalance(DriveSubsystem, navchipManager, extendorSubsystem, leverSubsystem, clawSubsystem, sensors);
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
    OI.balanceButton.onTrue(balance);
    OI.leverMoveButton.whileTrue(ManualLever);
    OI.extendorOutButton.whileTrue(ExtendOut);
    OI.extendorInButton.whileTrue(ExtendIn);
    OI.clawReleaseButton.whileTrue(outtakeClaw);
    OI.clawGrabButton.whileTrue(intakeClaw);

    
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
