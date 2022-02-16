package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "Ducks Red", group = "Linear Opmode")
public class DucksRed extends LinearOpMode {
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
                .turn(Math.toRadians(5.25))
                .forward(2.71)
                .UNSTABLE_addTemporalMarkerOffset(0.1, ()-> robot.carousel.setPowerAuto(1))
                .waitSeconds(3)
                .UNSTABLE_addTemporalMarkerOffset(2.9, ()-> robot.carousel.setPowerAuto(0))
                .forward(-4)
                .turn(Math.toRadians(5.25))
                .forward(2)
                .addDisplacementMarker(() -> telemetry.addData("State ", "stopped"))
                .build();

        waitForStart();

        drive.followTrajectorySequence(trajectory);

        while (opModeIsActive()) {
            robot.update();
            switch (state) {
                case STARTED:
                    telemetry.addData("State ", state.name());
                    break;
                case CAROUSELON:
                    robot.carousel.setPowerAuto(0.5);
                    robot.update();
                    telemetry.addData("State ", state.name());
                    break;
                case CAROUSELOFF:
                    robot.carousel.setPowerAuto(0);
                    robot.update();
                    telemetry.addData("State ", state.name());
                    break;
                case STOPPED:
                    robot.carousel.setPowerAuto(0);
                    telemetry.addData("State ", state.name());
                    robot.update();
                    break;
            }
        }
    }
}