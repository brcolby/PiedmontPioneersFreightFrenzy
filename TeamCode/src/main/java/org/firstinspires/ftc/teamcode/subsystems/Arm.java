package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot;
//test
public class Arm implements SubSystems {
    public DcMotor motor;
    public DcMotorEx motor2;
    public DcMotorEx armMotor;
    public CRServo servo;
    Robot robot;
    double power;
    int current;
    int motorPosition;
    int flipPosition;

    public Arm(Robot robot) {
        this.robot = robot;
        motor = robot.hardwareMap.get(DcMotor.class, "arm_motor");
        motor2 = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        armMotor = robot.hardwareMap.get(DcMotorEx.class, "intake_motor");
        servo = robot.hardwareMap.get(CRServo.class, "intake_servo" );
        motorPosition = 1000;
        flipPosition = 1000;
    }

    @Override
    public void update() {
        servo.setPower(1);
        motor.setPower(power);
        motor2.setPower(-1 * power);
        if(motor2.getTargetPosition() >= motorPosition)
        {
            armMotor.setTargetPosition(motorPosition);
        }
        else
        {
            armMotor.setTargetPosition(0);
        }
    }

    public void setPower(double setPower) {
        power = setPower;
    }

    public void setClawPower(int power) {
        current = power;
    }
}