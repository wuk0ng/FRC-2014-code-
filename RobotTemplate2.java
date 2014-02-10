/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package nerdHerd.Source;


import nerdHerd.Source.NerdyBot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANJaguar;
import nerdHerd.Source.MonkeyDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends NerdyBot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    Joystick joystick;
    CANJaguar ltMain, ltSub, rtMain, rtSub;
    Gyro gyro;
    MonkeyDrive drive;
    
   public void robotInit(){
       joystick = new Joystick (1);
       gyro = new Gyro (2);
       try{
           ltMain   = new CANJaguar(2);
           ltSub    = new CANJaguar(3);
           rtMain   = new CANJaguar(4);
           rtSub    = new CANJaguar(5);
        } catch (Exception e) {
            System.out.println(e);
        }
       System.out.println("challenge engaged");
       
   }
   
       
    public void autonomousPeriodic() {
        drive.move();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void teleopPeriodic() {

    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void testPeriodic() {
    
    }
}
