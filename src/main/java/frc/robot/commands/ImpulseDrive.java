// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import com.stuypulse.stuylib.math.SLMath;
import com.stuypulse.stuylib.streams.IStream;
import com.stuypulse.stuylib.streams.filters.LowPassFilter;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ImpulseDrive extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final XboxController controller;

  private final IStream speedSetpoint, angleSetpoint;

  public ImpulseDrive(DriveSubsystem driveSubsystem, XboxController controller2) {
    this.driveSubsystem = driveSubsystem;
    this.controller = controller2;

    // Gives 1 to -1, and 0 when both triggers are held down
    // Mapped to symetric max values from shuffleboard
    this.speedSetpoint = IStream.create(() -> controller2.getRightTriggerAxis() - controller2.getLeftTriggerAxis())
        .filtered(
            x -> SLMath.map(x, -1, 1, -Constants.MAX_SPEED.get(), Constants.MAX_SPEED.get()),
            x -> SLMath.deadband(x, Constants.SPEED_DEADBAND.get()),
            x -> SLMath.spow(x, Constants.SPEED_POWER.get()),
            new LowPassFilter(Constants.SPEED_FILTER.get()));

    this.angleSetpoint = IStream.create(() -> controller2.getLeftX())
        .filtered(
            x -> SLMath.map(x, -1, 1, -Constants.MAX_SPEED_ANGLE.get(),
                Constants.MAX_SPEED_ANGLE.get()),
            x -> SLMath.deadband(x, Constants.ANGLE_DEADBAND.get()),
            x -> SLMath.spow(x, Constants.ANGLE_POWER.get()),
            new LowPassFilter(Constants.ANGLE_FILTER.get()));

    addRequirements(driveSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.impulseDrive(speedSetpoint.get(), angleSetpoint.get());
    System.out.println(speedSetpoint.get());  
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}