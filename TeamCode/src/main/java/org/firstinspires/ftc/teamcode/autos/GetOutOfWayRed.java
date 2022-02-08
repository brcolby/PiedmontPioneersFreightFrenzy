package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "Red Get Out of The Way", group = "Linear Opmode")
public class GetOutOfWayRed extends LinearOpMode {
    public enum State{
        STARTED,
        STOPPED
    }
    public State state = State.STARTED;
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);

        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d(-35, 60, Math.toRadians(-90)))
                .forward(2)
                .turn(Math.toRadians(-10.5))
                .forward(4)
                .addDisplacementMarker(() -> state = GetOutOfWayRed.State.STOPPED)
                .build();


        waitForStart();

        while(opModeIsActive()) {
            robot.update();
            switch (state) {
                case STARTED:
                case STOPPED:
                    break;
            }
        }
    }
}