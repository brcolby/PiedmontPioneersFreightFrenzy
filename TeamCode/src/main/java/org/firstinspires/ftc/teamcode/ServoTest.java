
package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Servo Tester", group = "Linear Opmode")
public class ServoTest extends LinearOpMode {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);



        waitForStart();
        robot.arm.servoPower(0.1);
    }

}

