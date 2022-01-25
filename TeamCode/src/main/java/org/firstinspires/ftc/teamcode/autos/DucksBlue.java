package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
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
        waitForStart();
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);
        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d())
                .forward(-2)
                .turn(Math.toRadians(-5.3))
                .forward(2.5)
                .addDisplacementMarker(() -> state = State.CAROUSELON)
                .waitSeconds(3)
                .addDisplacementMarker(() -> state = State.CAROUSELOFF)
                .forward(-2.5)
                .turn(Math.toRadians(-5.3))
                .forward(2)
                .addDisplacementMarker(() -> state = State.STOPPED)
                .build();

        drive.followTrajectorySequence(trajectory);

        while (!isStopRequested() && opModeIsActive()) {
            robot.update();
            switch (state) {
                case STARTED:
                    continue;
                case CAROUSELON:
                    robot.carousel.setPowerAuto(0.5);
                    break;
                case CAROUSELOFF:
                    robot.carousel.setPowerAuto(0);
                case STOPPED:
                    robot.carousel.setPowerAuto(0);
                    break;
                }
        }
    }
}