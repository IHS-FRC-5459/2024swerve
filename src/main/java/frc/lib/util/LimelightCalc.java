package frc.lib.util;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Constants;

public class LimelightCalc {
    /* Calculations For Distances/Angles*/

    //get distance to target
    public double getDistance(NetworkTableEntry ty){
        double targetAngle = ty.getDouble(0.0);
        double angleToGoalDegrees = targetAngle + Constants.Limelight.cameraAngle;
        double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);
        
        //calculate distance
        double distanceFromLimelightToGoalMeters = (Constants.Limelight.targetHeight - Constants.Limelight.cameraHeight)/Math.tan(angleToGoalRadians);
        return distanceFromLimelightToGoalMeters;
        
    }

    //get how far off from target center in strafing direction
    public double getXOffset(NetworkTableEntry tx){
        return tx.getDouble(0.0);
    }

    //get angle from target in turning direction
    public double getTagAngle(NetworkTableEntry targetpose_cameraspace){
       // return targetpose_cameraspace.getDoubleArray(null) FIND HOW TO GET EULER ANGLE OF APRILTAG IN CAMERA FROM :)))))
       return 0;
    }

    /* Power Calculations */
    public double forwardPower(double goalDistance, double currentDistance){
        double kp = 0.1;
        double error = currentDistance - goalDistance;
        double output = MathUtil.clamp(kp * error, -1, 1);
        return output;
    }

    public double strafePower(double goalStrafe, double currentStrafe){
        double kp = 0.1;
        double error = currentStrafe - goalStrafe;
        double output = MathUtil.clamp(kp * error, -1, 1);
        return output;


    }

    public double rotPower(double goalRotation, double currentRotation)
    {
        double kp = 0.1;
        double error = currentRotation -  goalRotation;
        double output = MathUtil.clamp(kp * error, -1, 1);
        return output;
    }



}
