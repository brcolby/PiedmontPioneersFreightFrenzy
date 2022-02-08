package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "Blocks Blue", group = "Linear Opmode" )
public class BlocksBlue extends LinearOpMode {
    public enum State {
        STARTED,
        LIFTARM,
        LOWERARM,
        STOPPED;
    }
    public State state = State.STARTED;

    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);

        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d(-35, 60, Math.toRadians(-90)))
                .forward(-1.67)
                .turn(Math.toRadians(10.5))
                .forward(-5)
                .build();

        drive.followTrajectorySequence(trajectory);

        waitForStart();

        trajectory.start();

        while (opModeIsActive()) {
            robot.update();

            switch (state) {
                case STARTED:
                    break;
                case LIFTARM:
                    //Lift robot arm and spit out cube
                    break;
                case LOWERARM:
                    //Lower arm
                    break;
                case STOPPED:

            }
        }


    }
}
