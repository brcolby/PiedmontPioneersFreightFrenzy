package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "Ducks Blue", group = "Linear Opmode")
public class DucksBlue extends LinearOpMode {
    public enum State{
        STARTED,
        CAROUSELON,
        CAROUSELOFF,
        STOPPED
    }
    public State state = State.STARTED;

    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);
        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d())
                .forward(-2)
                .turn(Math.toRadians(-5.25))
                .forward(2.71)
                .UNSTABLE_addTemporalMarkerOffset(0.1, ()-> robot.carousel.setPowerAuto(1))
                .waitSeconds(3)
                .UNSTABLE_addTemporalMarkerOffset(2.9, ()-> robot.carousel.setPowerAuto(0))
                .forward(-4)
                .turn(Math.toRadians(-5.25))
                .forward(2)
                .build();

        waitForStart();

        drive.followTrajectorySequence(trajectory);

        while (opModeIsActive()) {
            robot.update();
            switch (state) {
                case STARTED:
                    break;
                case CAROUSELON:
                    robot.carousel.setPower(true, true);
                    break;
                case CAROUSELOFF:
                    robot.carousel.setPower(false, true);
                    break;
                case STOPPED:
                    robot.carousel.setPower(false, false);
            }
        }
    }
}