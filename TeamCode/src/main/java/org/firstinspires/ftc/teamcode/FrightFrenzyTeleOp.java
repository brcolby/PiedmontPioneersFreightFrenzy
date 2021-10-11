
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="Teleeeeeee", group="Linear Opmode")


public class FrightFrenzyTeleOp extends LinearOpMode {
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);

        robot.createTeleOpManager(new TeleOpManager(()->robot.gamepad1.a, ()-> robot.carousel.setPower(1.0)));

        waitForStart();

        while(opModeIsActive()) {
            robot.update();
            robot.drive.setLeftPower(robot.gamepad1.left_stick_y);
            robot.drive.setRightPower(robot.gamepad1.right_stick_x);
        }
    }

}
