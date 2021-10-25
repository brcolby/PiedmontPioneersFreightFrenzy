package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Teleeeeeee", group="Linear Opmode")
public class FrightFrenzyTeleOp extends LinearOpMode {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);

        //robot.createTeleOpManager(new TeleOpManager(()->robot.gamepad1.a, ()-> robot.carousel.setPower(1.0)));
        //robot.createTeleOpManager(new TeleOpManager(()->robot.gamepad1.b, ()->robot.carousel.setPower(1.0), ()->robot.carousel.setPower(0.0)));

        waitForStart();
        while(opModeIsActive()) {
            robot.drive.setLeftPower(robot.gamepad1.left_stick_y);
            robot.drive.setRightPower(robot.gamepad1.right_stick_y);
            if(robot.gamepad1.a)
                robot.carousel.setPower(1.0);
            if(robot.gamepad1.b)
                robot.carousel.setPower(0.0);
            robot.update();
        }
    }

}
