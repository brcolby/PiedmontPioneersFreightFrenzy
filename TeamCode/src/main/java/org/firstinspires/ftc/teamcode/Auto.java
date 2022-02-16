//package org.firstinspires.ftc.teamcode;
//
//import android.os.Build;
//import androidx.annotation.RequiresApi;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//@TeleOp(name = "run this nate", group = "Linear Opmode")
//public class Auto extends LinearOpMode {
//    @RequiresApi(api = Build.VERSION_CODES.N)
//
//    public void runOpMode() {
//        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
//        waitForStart();
//        while (opModeIsActive()) {
//            robot.drive.setLeftPower(0.75, false);
//            robot.update();
//            robot.drive.setRightPower(0.5, false);
//            robot.update();
//            sleep(2000);
//            robot.update();
//            robot.drive.setRightPower(0.4, false);
//            robot.update();
//            robot.drive.setLeftPower(-0.4, false);
//            robot.update();
//            sleep(1000);
//            robot.update();
//            robot.drive.setLeftPower(0.2, false);
//            robot.update();
//            robot.drive.setRightPower(0.2, false);
//            robot.update();
//            sleep(2500);
//            robot.update();
//            robot.drive.setLeftPower(0.1, true);
//            robot.update();
//            robot.drive.setRightPower(0.1, true);
//            robot.update();
//            robot.carousel.setPowerAuto(0.5);
//            robot.update();
//            sleep(3000);
//            robot.update();
//            robot.carousel.setPowerAuto(0);
//            robot.update();
//            robot.drive.setLeftPower(-0.4, false);
//            robot.update();
//            robot.drive.setRightPower(-0.4, false);
//            robot.update();
//            sleep(1500);
//            robot.update();
//            robot.drive.setLeftPower(0.4, false);
//            robot.update();
//            sleep(500);
//            robot.update();
//            robot.drive.setRightPower(0.4, false);
//            robot.update();
//            sleep(750);
//            robot.update();
//            robot.drive.setRightPower(0, false);
//            robot.update();
//            robot.drive.setLeftPower(0, false);
//            robot.update();
//            break;
//public class Auto {
//    @TeleOp(name = "Auto", group = "Linear Opmode")
//    public class FrightFrenzyTeleOp extends LinearOpMode {
//        @RequiresApi(api = Build.VERSION_CODES.N)
//        public void runOpMode() {
//            Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
//
//  //          robot.arm.flipBucket.setPosition(0.0);
//            waitForStart();
//            while(opModeIsActive()) {
//                robot.drive.setLeftPower(0.5, false);
//                robot.update();
//                robot.drive.setRightPower(0.5, false);
//                robot.update();
//                sleep(2000);
//                robot.drive.setLeftPower(0.0, false);
//                robot.update();
//                robot.drive.setRightPower(0.0, false);
//                robot.update();
//                robot.arm.armSpeed(-0.3);
//                robot.update();
//                sleep(500);
//                robot.update();
//         //       robot.arm.intake(-0.3);
//                robot.update();
//                sleep(500);
//                robot.update();
//       //         robot.arm.intake(true, );
//                //auto
//                robot.update();
//            }
//        }
//    }
//}