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

    public void setPower(boolean setPower, boolean posOrNeg) {
        if (!setPower) {
            amount = 0;
        } else if (amount < 0.4 && amount > -0.4) {
            if (posOrNeg) {
                amount += 0.01;
            } else
                amount -= 0.01;
        }

    }
    public void setPowerAuto(double amount1)
    {
        amount = amount1;
    }
    // sets power of motor / which direction the motor goes
}