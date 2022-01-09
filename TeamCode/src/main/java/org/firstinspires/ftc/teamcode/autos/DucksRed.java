
package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
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
    public DucksBlue.State state = DucksBlue.State.STARTED;

    public void runOpMode() {
         Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);
        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d(-35, -60, Math.toRadians(90)))
                .forward(24)
                .turn(Math.toRadians(-45))
                .forward(-30)
                .addDisplacementMarker(() -> state = DucksBlue.State.CAROUSELON)
                .waitSeconds(3)
                .addDisplacementMarker(() -> state = DucksBlue.State.CAROUSELOFF)
                .forward(30)
                .turn(Math.toRadians(-45))
                .forward(-25)
                .addDisplacementMarker(() -> state = DucksBlue.State.STOPPED)
                .build();


        waitForStart();

        while (opModeIsActive()) {
        robot.update();
            switch (state) {
                case STARTED:
                    break;
                case CAROUSELON:
                    robot.carousel.setPowerAuto(1);
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

