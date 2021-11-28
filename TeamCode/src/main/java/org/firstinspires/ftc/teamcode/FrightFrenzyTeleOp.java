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


        waitForStart();
        while (opModeIsActive()) {
            //drive
            robot.drive.setLeftPower(robot.gamepad1.left_stick_y, robot.gamepad1.left_bumper);
            robot.drive.setRightPower(robot.gamepad1.right_stick_y, robot.gamepad1.left_bumper);

            if (robot.gamepad2.a)
                //forwards
                robot.carousel.setPower(0.5);
            else if (robot.gamepad2.b)
                //backwards
                robot.carousel.setPower(-0.5);
            else
                //carousel not moving
                robot.carousel.setPower(0);

            if (robot.gamepad2.left_trigger > 0.1)
                //arm down
                robot.arm.setPower(robot.gamepad2.left_trigger * -1);
            else if (robot.gamepad2.right_trigger > 0.1)
                //arm up
                robot.arm.setPower(robot.gamepad2.right_trigger);
            else
                //arm not moving
                robot.arm.setPower(0);

            if (gamepad2.y)
                //servo rotate forward
                robot.arm.setServo(-1);
            else if (gamepad2.x)
                //servo rotate backwards
                robot.arm.setServo(-1);
            else
                //stop servo
                robot.arm.setPower(0);
            robot.update();
        }
    }
}