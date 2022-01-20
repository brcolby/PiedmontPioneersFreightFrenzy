package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Auto", group = "Linear Opmode")
    public class Auto extends LinearOpMode {
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void runOpMode() {
            Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);

  //          robot.arm.flipBucket.setPosition(0.0);
            waitForStart();
            robot.drive.setLeftPower(0.5, false);
            robot.drive.setRightPower(0.5, false );
            sleep(2000);
            robot.drive.setLeftPower(0.0, false);
            robot.drive.setRightPower(0.0, false );
            robot.arm.armSpeed(-0.3);
            sleep(500);
            robot.arm.intake(true, false);
            sleep(500);
            robot.arm.intake(false, false);
        }
    }
