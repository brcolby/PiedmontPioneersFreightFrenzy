package org.firstinspires.ftc.teamcode;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.nio.file.attribute.UserPrincipalLookupService;

@TeleOp(name = "Teleeeeeee", group = "Linear Opmode")
public class FrightFrenzyTeleOp extends LinearOpMode {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);



        waitForStart();
        while (opModeIsActive()) {
            //drive
            robot.drive.setLeftPower(robot.gamepad1.left_stick_y, robot.gamepad1.left_bumper);
            robot.drive.setRightPower(robot.gamepad1.right_stick_y, robot.gamepad1.left_bumper);

            if (robot.gamepad2.a)
                //forwards
                robot.carousel.setPower(true, true);
            else if (robot.gamepad2.b)
                //backwards
                robot.carousel.setPower(true, false);
            else
                //carousel not moving
                robot.carousel.setPower(false, false);

            if(robot.gamepad2.x == true)
            {
                robot.arm.intake(0.8);

            }
            else if(robot.gamepad2.y == true)
            {
                robot.arm.intake(-0.33);
            }
            else
            {
                robot.arm.intake(0);
            }
            if(robot.gamepad2.right_trigger > 0.1)
            {
                robot.arm.armSpeed(gamepad2.right_trigger);
            }
            else if(robot.gamepad2.left_trigger > 0.1)
            {
                robot.arm.armSpeed(-gamepad2.left_trigger);
            }
            else
            {
                robot.arm.armSpeed(0.0);
            }
            if(gamepad2.right_bumper)
            {
                robot.arm.servoPower(-0.1);

            }
            else if (gamepad2.left_bumper)
            {
                robot.arm.servoPower(0.1);
            }
            /*if(gamepad2.dpad_down)
            {
                robot.arm.lock(true);
            }*/
            robot.update();
        }
    }
}