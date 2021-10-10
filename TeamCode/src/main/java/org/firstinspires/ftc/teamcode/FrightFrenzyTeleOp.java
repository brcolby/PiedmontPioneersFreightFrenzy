package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class FrightFrenzyTeleOp extends LinearOpMode {
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);

        robot.createTeleOpManager(new TeleOpManager(()->robot.gamepad1.a, ()-> robot.carousel.setPower(1.0)));

        waitForStart();

        while(opModeIsActive())
            robot.update();
    }

}
