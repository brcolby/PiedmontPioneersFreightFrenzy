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
   public  double servoPosition = 0;
    double ticks = 6766.2;
    boolean lock;
    boolean direction;

    public Arm(Robot robot) {
        this.robot = robot;
        armLiftUpper = robot.hardwareMap.get(DcMotorEx.class, "arm_motor");
        armLiftLower = robot.hardwareMap.get(DcMotorEx.class, "arm_motor2");
        flipBucket = robot.hardwareMap.get(Servo.class, "bucket_servo");
        zipTies = robot.hardwareMap.get(DcMotor.class, "intake_motor");
    }

    @Override
    public void update() {
        zipTies.setPower(num);
        if(armLiftUpper.getCurrentPosition() < 2000) {
            armLiftLower.setPower(armPower);
            armLiftUpper.setPower(-armPower);
        }
        else {
            armLiftLower.setPower(0);
        }

        flipBucket.setPosition(servoPosition);
    }

    public void intake(boolean on, double power) {
        if (power < num && on)
            if (power > 0)
                num = 1;
            else
                num -= 0.01;
        else
            num = 0;
    }

    public void autoIntake(double power) {
        num = power;
    }

    public void armSpeed(double position) {
        armPower = position;
    }
//    public void servoPosition(boolean direction1) {
//       if(direction1)
//       {
//           servoPosition = servoPosition + 0.01;
//           if(servoPosition >  1)
//           {
//               servoPosition = 1;
//           }
//
//       }
//       else
//       {
//           servoPosition = servoPosition- 0.01;
//           if(servoPosition < 0)
//           {
//               servoPosition = 0;
//           }
//       }
//    }
//
//    public void lock(boolean x)
//    {
//        lock = x;
//    }
}