package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name="Teleeeeeee", group="Linear Opmode")
public class Tester extends LinearOpMode {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();

        robot.arm.setClawPower(1);
        sleep(500);

        robot.arm.setPower(1);
        sleep(1000);
        robot.arm.setPower(0);
        sleep(500);

        robot.drive.setLeftPower(1, false);
        robot.drive.setRightPower(1, false);
        sleep(2000);
        robot.drive.setLeftPower(0,false);
        robot.drive.setRightPower(0,false);
        sleep(500);

        robot.drive.setLeftPower(.2, false);
        robot.drive.setRightPower(1,false);
        sleep(1200);
        robot.drive.setLeftPower(0, false);
        robot.drive.setRightPower(0, false);
        sleep(500);

        robot.arm.setClawPower(-1);
        sleep(500);
        robot.arm.setClawPower(0);





    }
}
