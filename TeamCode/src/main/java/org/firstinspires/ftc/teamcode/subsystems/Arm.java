package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot;

public class Arm implements SubSystems {
    public DcMotor armLiftUpper;
    public DcMotorEx armLiftLower;
    public DcMotor wheel;
    public CRServo flipBucket;
    Robot robot;
    double power ;
    double wheelPower;

    public Arm(Robot robot) {
        this.robot = robot;
        armLiftUpper = robot.hardwareMap.get(DcMotor.class, "arm_motor");
        armLiftLower = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        wheel = robot.hardwareMap.get(DcMotor.class, "wheel_intake_motor");
        flipBucket = robot.hardwareMap.get(CRServo.class, "bucket_motor");
    }

    @Override
    public void update() {
        armLiftUpper.setPower(power);
        armLiftLower.setPower(-1 * power);
        wheel.setPower(wheelPower);
    }

    public void setPower(double setPower) {
        power = setPower;
    }

    public void setWheelPower(double setWheelPower) {
        wheelPower = setWheelPower;
    }

}