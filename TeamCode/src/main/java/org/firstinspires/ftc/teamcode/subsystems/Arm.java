package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

//6766.2 encoder ticks

public class Arm implements SubSystems {
    public DcMotor armLiftUpper;
    public DcMotorEx armLiftLower;
    public DcMotor zipTies;
    public CRServo flipBucket;
    Robot robot;
    double num;
    double armPower;
    double servoPosition;
    double ticks = 6766.2;
    boolean lock;


    public Arm(Robot robot) {
        this.robot = robot;
        armLiftUpper = robot.hardwareMap.get(DcMotorEx.class, "arm_motor");
        armLiftLower = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        flipBucket = robot.hardwareMap.get(CRServo.class, "servo_bucket");
        zipTies = robot.hardwareMap.get(DcMotor.class, "intake_motor");
    }

    @Override
    public void update() {
        zipTies.setPower(num);
        armLiftLower.setPower(armPower);
        armLiftUpper.setPower(-armPower);

        armLiftLower.setTargetPosition(armLiftLower.getCurrentPosition());
        armLiftLower.setTargetPosition(armLiftUpper.getCurrentPosition());

        /*if(servoPosition != 1000)
            flipBucket.setPosition(servoPosition);
        else {
            if (flipBucket.getPosition() > armLiftUpper.getCurrentPosition()*360/6766.2) {
                flipBucket.setPosition(flipBucket.getPosition() + 1);
            }
            else if (flipBucket.getPosition() < armLiftUpper.getCurrentPosition()*360/6766.2) {
                flipBucket.setPosition(flipBucket.getPosition() - 1);
            }*/
        flipBucket.setPower(servoPosition);
    }

    public void intake(double position)
    {
        num = position;
    }
    public void armSpeed(double position)
    {
        armPower = position;
    }
    public void servoPower(double servoPosition1) {
       servoPosition = servoPosition1;
    }
    public void lock(boolean x)
    {
        lock = x;
    }

}