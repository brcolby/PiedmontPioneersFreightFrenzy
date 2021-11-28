package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmTester {
    @TeleOp(name = "ArmTester", group = "Linear Opmode")
    public class FrightFrenzyTeleOp extends LinearOpMode {
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void runOpMode() {
            Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);


            waitForStart();
            while (opModeIsActive()) {
                telemetry.addData("Side Position: ", robot.arm.getMotorPosition());
                telemetry.addData("Bucket Position", robot.arm.getFlipPosition());
                robot.arm.getFlipPosition();
                telemetry.update();
            }
        }
    }
}
