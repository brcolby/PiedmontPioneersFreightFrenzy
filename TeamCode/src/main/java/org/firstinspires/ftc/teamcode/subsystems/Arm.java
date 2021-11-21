package org.firstinspires.ftc.teamcode.subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot;

public class Arm implements SubSystems {
    public DcMotor motorMove1;
    public DcMotorEx motorMove2;
    public DcMotorEx clawRotator;
    public Servo clawMotor;
    Robot robot;
    double power;
    double current;

    public Arm(Robot robot) {
        this.robot = robot;
        motorMove1 = robot.hardwareMap.get(DcMotor.class, "arm_motor");
        motorMove2 = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        clawRotator = robot.hardwareMap.get(DcMotorEx.class, "claw_rotate");
        clawMotor = robot.hardwareMap.get(Servo.class, "intake_motor");
    }

    @Override
    public void update() {
        motorMove1.setPower(power);
        motorMove2.setPower(-1 * power);
        clawMotor.setPosition(current);
        checkTicks();
    }

    public void checkTicks() {
        if (motorMove2.getCurrentPosition() >= 1000 ) {
            clawRotator.setTargetPosition(100);
        }
        else {
            clawRotator.setTargetPosition(0);
        }
    }

    public void setPower(double setPower) {
      power = setPower;
    }

    public void setClawPower(double power) {
        current = power;
    }
}