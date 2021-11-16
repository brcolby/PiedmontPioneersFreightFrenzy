package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class OdometryPods implements SubSystems{
    public Servo servo1, servo2, servo3;
    Robot robot;

    public OdometryPods(Robot robot) {
        this.robot = robot;
        servo1 = robot.hardwareMap.get(Servo.class, "Pod1");
        servo2 = robot.hardwareMap.get(Servo.class, "Pod2");
        servo3 = robot.hardwareMap.get(Servo.class, "Pod3");
    }

    public void update() {

    }
}
