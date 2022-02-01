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
                .turn(Math.toRadians(-5.25))
                .forward(2.71)
                .addDisplacementMarker(() -> {robot.carousel.setPowerAuto(1); robot.update();})
                .waitSeconds(3)
                .addDisplacementMarker(() -> {robot.carousel.setPowerAuto(0); robot.update();})
                .forward(-4)
                .turn(Math.toRadians(-5.25))
                .forward(2)
                .addDisplacementMarker(() -> telemetry.addData("State ", "stopped"))
                .build();

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