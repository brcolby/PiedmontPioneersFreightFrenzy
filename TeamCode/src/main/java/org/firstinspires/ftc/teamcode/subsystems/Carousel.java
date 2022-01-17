package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;

public class Carousel implements SubSystems {
    // all of our variables
    DcMotor carouselMotor;
    Robot robot;
    boolean power;
    double amount;

    public Carousel(Robot robot) {
        carouselMotor = robot.hardwareMap.get(DcMotor.class, "carousel"); // gets motor from hardware map
        this.robot = robot;
        amount = 0;
    }

    @Override
    public void update() {
        carouselMotor.setPower(amount);
    } // takes set power/direction and changes it on the robot

    public void setPower(double setPower, boolean posOrNeg) {
        if(posOrNeg)
        {
            amount = setPower;
        }
        else
        {
            amount = -1*setPower;
        }
    }
    public void setPowerAuto(double amount1)
    {
        amount = amount1;
    }
    // sets power of motor / which direction the motor goes
}