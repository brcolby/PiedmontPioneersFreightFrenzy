package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

public class Arm implements SubSystems{
    public DcMotor motor;
    Robot robot;
    double power;
    public Arm(Robot robot) {
        motor = robot.hardwareMap.get(DcMotor.class, "arm_motor");
    }
    @Override
    public void update() {
        motor.setPower(power);
    }
    public void setPower(double setPower)
    {
        power = setPower;
    }

}
