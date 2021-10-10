package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

public class Carousel implements SubSystems {
    DcMotor carouselMotor;
    Robot robot;

    double power;

    public Carousel(Robot robot)
    {
        carouselMotor = robot.hardwareMap.get(DcMotor.class, "carousel");
        this.robot = robot;
    }
    @Override
    public void update() {
        carouselMotor.setPower(power);
    }

    public void setPower(double setPower) {
        power = setPower;
    }
}
