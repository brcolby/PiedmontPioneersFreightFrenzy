//package org.firstinspires.ftc.teamcode.autos;
//
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.teamcode.Robot;
//import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
//import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
//
//@TeleOp(name = "Test Auto" , group = "Linear Opmode")
//
//public class TestAuto extends LinearOpMode{
//
//    @Override
//    public void runOpMode() {
//        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
//        waitForStart();
//        SampleTankDrive drive = new SampleTankDrive(hardwareMap);
//        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d(-35, 60, Math.toRadians(-90)));
//
//
//
//        trajectory.start();
//
//        while (opModeIsActive()) {
//
//            }
//        }
//    }
//}