package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

//6766.2 encoder ticks

public class Arm implements SubSystems {
    public DcMotor armLiftUpper;
    public DcMotorEx armLiftLower;
    public DcMotor zipTies;
    public Servo flipBucket;
    Robot robot;
    double num;
    double armPower;
    double servoPosition = 0;
    double ticks = 6766.2;
    boolean lock;


    public Arm(Robot robot) {
        this.robot = robot;
        armLiftUpper = robot.hardwareMap.get(DcMotorEx.class, "arm_motor");
        armLiftLower = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        flipBucket = robot.hardwareMap.get(Servo.class, "bucket_servo_2");
        zipTies = robot.hardwareMap.get(DcMotor.class, "intake_motor");
    }

    @Override
    public void update() {
        zipTies.setPower(num);
        armLiftLower.setPower(armPower);
        armLiftUpper.setPower(-armPower);

        armLiftLower.setTargetPosition(armLiftLower.getCurrentPosition());
        armLiftLower.setTargetPosition(armLiftUpper.getCurrentPosition());

        flipBucket.setPosition(servoPosition);
    }

    public void intake(double position)
    {
        num = position;
    }
    public void armSpeed(double position)
    {
        armPower = position;
    }
    public void servoPosition(double servoPosition1) {
       servoPosition += servoPosition1;
    }
    public void lock(boolean x)
    {
        lock = x;
    }
}