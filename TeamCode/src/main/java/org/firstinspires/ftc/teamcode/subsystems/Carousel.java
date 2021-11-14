package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;

public class Carousel implements SubSystems {
    // all of our variables
    DcMotor carouselMotor;
    Robot robot;
    double power;

    public Carousel(Robot robot) {
        carouselMotor = robot.hardwareMap.get(DcMotor.class, "carousel"); // gets motor from hardware map
        this.robot = robot;
    }

    @Override
    public void update() {
        carouselMotor.setPower(power);
    } // takes set power/direction and changes it on the robot

    public void setPower(double setPower) {
        power = setPower;
    } // sets power of motor / which direction the motor goes
}