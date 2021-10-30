package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Intake implements SubSystems {
    CRServo servoOne;
    CRServo servoTwo;
    Robot robot;
    double powerLeft;
    double powerRight;

    public Intake(Robot robot) {
        servoOne = robot.hardwareMap.get(CRServo.class, "left_servo");
        servoTwo = robot.hardwareMap.get(CRServo.class, "right_servo");
        this.robot = robot;

    }
    public void update() {
        servoOne.setPower(powerLeft);
        servoTwo.setPower(powerRight);
    }
    public void setDirection(double powerLeft, double powerRight) {
        this.powerLeft = powerLeft;
        this.powerRight = powerRight;
    }

}
