package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

    @TeleOp(name = "Ducks Blue Auto", group = "Linear Opmode" )
    public class DucksBlueAuto extends LinearOpMode {


        @Override
        public void runOpMode() throws InterruptedException {

            Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
            SampleTankDrive drive = new SampleTankDrive(hardwareMap);

            TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d())
                    .forward(-2)
                    .turn(Math.toRadians(-5.25))
                    .forward(2.71)
                    .waitSeconds(3)
                    .forward(-4)
                    .turn(Math.toRadians(-5.25))
                    .forward(2)
                    .build();
            waitForStart();
            robot.carousel.setPowerAuto(0.5);
            robot.update();
            drive.followTrajectorySequence(trajectory);


        }
    }
