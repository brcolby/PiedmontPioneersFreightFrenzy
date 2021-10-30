//package org.firstinspires.ftc.teamcode.subsystems;
//
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.Servo;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.Robot;
//import org.firstinspires.ftc.teamcode.TeleOpManager;
//
//public class Intake implements SubSystems {
//    DcMotorEx intakeMotor;
//    CRServo servoTwo;
//    Robot robot;
//    int current;
//
//    public Intake(Robot robot) {
//        this.robot = robot;
//        intakeMotor = robot.hardwareMap.get(DcMotorEx.class, "intake_motor");
//
//    }
//    public void update() {
//        intakeMotor.setTargetPosition(current);
//    }
//    public void setPosition(int position) {
//       current = position;
//    }
//
//}
