package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

public class Arm implements SubSystems {
    public DcMotor motor;
    public DcMotor motor2;
    Robot robot;
    double power;
    public Arm(Robot robot) {
        motor = robot.hardwareMap.get(DcMotor.class, "arm_motor");
        motor2 = robot.hardwareMap.get(DcMotor.class, "arm_motor2");
    }
    @Override
    public void update() {
        motor.setPower(power);
        motor.setPower(-1*power);
    }
    public void setPower(double setPower) {
        power = setPower;
    }

}
