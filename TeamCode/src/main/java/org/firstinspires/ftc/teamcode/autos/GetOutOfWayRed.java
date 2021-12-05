//package org.firstinspires.ftc.teamcode.autos;
//
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.teamcode.Robot;
//import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
//
//public class GetOutOfWayRed extends LinearOpMode {
//    public enum State{
//        STARTED,
//        STOPPED
//    }
//    public State state = State.STARTED;
//    public Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
//
//    public void runOpMode() {
//        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d(-35, 60, Math.toRadians(-90)))
//                .forward(24)
//                .turn(Math.toRadians(-90))
//                .forward(48)
//                .build();
//
//
//        waitForStart();
//
//        while(opModeIsActive()) {
//            robot.update();
//            switch (state) {
//                case STARTED:
//                case STOPPED:
//                    break;
//            }
//        }
//    }
//}
