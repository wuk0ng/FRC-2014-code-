/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdHerd.Source;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author student
 */
public class MonkeyDrive {
    
    Gyro gyro;
    CANJaguar ltMain, ltSub, rtMain, rtSub;
    Joystick joystick;

    
    public MonkeyDrive() {
        gyro         = new Gyro(2);
        joystick     = new Joystick(1);
        double power = joystick.getY();
      
        

        
    try{
        ltMain       = new CANJaguar(2);
        ltSub        = new CANJaguar(4);
        rtMain       = new CANJaguar(3);
        rtSub        = new CANJaguar(5);
    } catch(Exception e) {
        System.out.println(e);
    }
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    public void move() {         
       double Kp    = 0.03;
       double angleWant = 0.0;
       double angleAt = gyro.getAngle();
       double error = angleAt - angleWant;
       double motorValue1 = error*Kp;
       double motorValue2 = constrain(motorValue1, -1.1, 1.1);
       rtMain.set(motorValue2);
       rtSub.set(motorValue2);
       ltMain.set(-motorValue2);
       ltSub.set(-motorValue2);
           
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x = 2.0;
        x = constrain(x,-1.0,1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected double constrain(double inVal, double min, double max){
        if(min > inVal ){
            return min;
        }else if(max < inVal){
            return max;
        }else{
            return inVal;
        }
        
    }
 }

