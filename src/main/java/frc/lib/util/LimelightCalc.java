package frc.lib.util;

import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Constants;

public class LimelightCalc {
    public double getDistance(NetworkTableEntry ty){
        double targetAngle = ty.getDouble(0.0);
        double angleToGoalDegrees = targetAngle + Constants.Limelight.cameraAngle;
        double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);
        
        //calculate distance
        double distanceFromLimelightToGoalMeters = (Constants.Limelight.targetHeight - Constants.Limelight.cameraHeight)/Math.tan(angleToGoalRadians);
        return distanceFromLimelightToGoalMeters;
        
    }


}
