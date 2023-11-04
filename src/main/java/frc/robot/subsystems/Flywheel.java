// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Flywheel extends SubsystemBase {

  // create neo for flywheel
  CANSparkMax flywheelNeo = new CANSparkMax(Constants.FlywheelConstants.flyWheelMotorID, MotorType.kBrushless);
  
  // feedforward for flywheel
  SimpleMotorFeedforward flywheelFeedForward = new SimpleMotorFeedforward(Constants.FlywheelConstants.kS_Flywheel, Constants.FlywheelConstants.kV_Flywheel, Constants.FlywheelConstants.kA_Flywheel);
  //bangbang controller for flywheel
  BangBangController controller = new BangBangController();
  //encoder
  private RelativeEncoder flywheelEncoder;



  /** Creates a new Flywheel. */
  public Flywheel() {
    flywheelEncoder = flywheelNeo.getEncoder();
    flywheelNeo.setIdleMode(IdleMode.kCoast);
  }

  public double voltageForVelocity(double setpoint){
    double voltage = (controller.calculate(getMotorVelocity(), setpoint) * 12.0 + 0.92 * flywheelFeedForward.calculate(setpoint));
    //double voltage = 5;
    System.out.println(flywheelFeedForward.calculate(setpoint) + " " + getMotorVelocity());
    return voltage;
  }

  public void setVoltage(double volts){
    flywheelNeo.setVoltage(volts);
  }

  public double getMotorVelocity(){
    return flywheelEncoder.getVelocity() / Constants.FlywheelConstants.flywheelGearRatio; // return flywheel motor velocity
  }




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
