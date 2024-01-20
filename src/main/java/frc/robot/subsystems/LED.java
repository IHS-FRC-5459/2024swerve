// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;

/** Add your docs here. */
public class LED {

    static CANdle _candle = new CANdle(1, "light bus");

    public LED() {

    }

    

    // sets the colors of an LED
    public static void setLED(int LEDId, int LEDRed, int LEDGreen, int LEDBlue) {

        _candle.setLEDs(LEDRed, LEDGreen, LEDBlue, 0, LEDId, 1);
    
    }

    //you can probably ignore this next bit, it was just me messing around to see what LEDgreen could look like, and as a template for future LED"color" methods could look like -Jacob
    /*
     //turns the green LED on or off
     
     public static void LEDgreen(boolean setOn) {
        
        if(setOn == true) {

            LED.setLED("id of the green LED", 255, 0, 0);

        } else if(setOn == false) {

            LED.setLED("id of the green LED", 0, 0, 0);

        }

     }
    */

}
