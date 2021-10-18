package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Robot;

public class Drive implements SubSystems{
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;
    public double leftPower;
    public double rightPower;
    Robot robot;

    public Drive(Robot robot) {
        this.robot = robot;
        leftFront = robot.hardwareMap.get(DcMotor.class, "front_left");
        leftBack = robot.hardwareMap.get(DcMotor.class, "back_left");
        rightFront = robot.hardwareMap.get(DcMotor.class, "front_right");
        rightBack = robot.hardwareMap.get(DcMotor.class, "back_right");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    @Override
    public void update() {
        leftFront.setPower(leftPower);
        leftBack.setPower(leftPower);
        rightFront.setPower(rightPower);
        rightBack.setPower(rightPower);
    }

    public void setLeftPower(double x)
    {
        leftPower = x;
    }
    public void setRightPower(double x)
    {
        rightPower = x;
    }

}
