// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Flywheel;

public class SpinFlywheel extends CommandBase {
  private double goalVelocity; 

  /** Creates a new SpinFlywheel. */
  public SpinFlywheel(double goalVelocity) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.goalVelocity = goalVelocity;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double voltage = Robot.getRobotContainer().s_Flywheel.voltageForVelocity(goalVelocity);
    Robot.getRobotContainer().s_Flywheel.setVoltage(voltage);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.getRobotContainer().s_Flywheel.setVoltage(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
