package org.firstinspires.ftc.teamcode;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Teleeeeeee", group = "Linear Opmode")
public class FrightFrenzyTeleOp extends LinearOpMode {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);


        robot.arm.flipBucket.setPosition(0.4);
        waitForStart();
        while (opModeIsActive()) {
            //drive
            robot.drive.setLeftPower(robot.gamepad1.left_stick_y, robot.gamepad1.left_bumper);
            robot.drive.setRightPower(robot.gamepad1.right_stick_y, robot.gamepad1.left_bumper);

            if (robot.gamepad2.a || robot.gamepad1.a)
                //forwards
                robot.carousel.setPower(true, true);
            else if (robot.gamepad2.b || robot.gamepad1.b)
                //backwards
                robot.carousel.setPower(true, false);
            else
                //carousel not moving
                robot.carousel.setPower(false, false);

            if(robot.gamepad2.x) {
                robot.arm.intake(true, true);
//                robot.arm.servoPosition(30, false);
            }
            else if(robot.gamepad2.y)
                robot.arm.intake(true, false);
            else {
                robot.arm.intake(false, false);
//                robot.arm.servoPosition(0, true);
            }
            if(robot.gamepad2.right_trigger > 0.1)
                robot.arm.armSpeed(gamepad2.right_trigger);
            else if(robot.gamepad2.left_trigger > 0.1)
                robot.arm.armSpeed(-gamepad2.left_trigger);
            else
                robot.arm.armSpeed(0.0);
            if(gamepad2.right_bumper)
            {
                if(robot.arm.flipBucket.getPosition() < 0.7)
                    robot.arm.servoPosition = robot.arm.flipBucket.getPosition() + 0.01;
            }
            if(gamepad2.left_bumper)
            {
                if(robot.arm.flipBucket.getPosition() > 0)
                    robot.arm.servoPosition = robot.arm.flipBucket.getPosition() -0.01;
            }

            robot.update();
        }
    }
}