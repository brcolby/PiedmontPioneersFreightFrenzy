package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot;

public class Arm implements SubSystems {
    public DcMotor motor;
    public DcMotor motor2;
    public DcMotorEx armMotor;
    Robot robot;
    double power;
    double current;
    public Arm(Robot robot) {
        this.robot = robot;
        motor = robot.hardwareMap.get(DcMotor.class, "arm_motor");
        motor2 = robot.hardwareMap.get(DcMotor.class, "arm_motor2");
        armMotor = robot.hardwareMap.get(DcMotorEx.class, "intake_motor");

    }
    @Override

    public void update() {
        motor.setPower(power);
        motor2.setPower(-1*power);
        armMotor.setPower(current);
    }
    public void setPower(double setPower) {
        power = setPower;
    }
    public void setClawPower(double power ) {
        current = power;
    }

}
