// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import java.lang.Math;
import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    // create neo for flywheel
    CANSparkMax armExtensionNeo = new CANSparkMax(Constants.Arm.armExtendMotorID, MotorType.kBrushless);

      // create neo for flywheel
    CANSparkMax armRotationNeo = new CANSparkMax(Constants.Arm.armRotateMotorID, MotorType.kBrushless);

  /** Creates a new Arm. */
  public Arm() {
    armExtensionNeo.setIdleMode(IdleMode.kCoast);
    armRotationNeo.setIdleMode(IdleMode.kCoast);
  }

  public double getAngle(){
    return 0; // TODO
  }

  public double getPosition(){
    return 0; // TODO
  }

  public double calculateExtensionVoltage(double goalExtension){
    return (MathUtil.clamp((Constants.Arm.kP_extend * (getPosition() - goalExtension) * 12), -1, 1) + 0.9 * (Constants.Arm.kF_extend * Math.sin(Math.toRadians(getAngle())))); 
  }

  public double calculateRotationVoltage(double goalAngle){
    return (MathUtil.clamp((Constants.Arm.kP_rotate * (getPosition() - goalAngle) * 12),-1,1) + 0.9 * (Constants.Arm.kF_rotate * Math.cos(Math.toRadians(getAngle()))));
  }

  public void setExtensionVoltage(double volts){
    armExtensionNeo.setVoltage(volts);
  }

  public void setRotationVoltage(double volts){
    armRotationNeo.setVoltage(volts);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
