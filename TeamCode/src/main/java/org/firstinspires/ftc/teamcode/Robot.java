package org.firstinspires.ftc.teamcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
//import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SubSystems;

import java.util.ArrayList;

public class Robot {
    public ArrayList<SubSystems> subSystems; // list of subsystems that we go through and update
    public ArrayList<TeleOpManager> teleOpManagers;
    public HardwareMap hardwareMap;
    // parts of the robot
    public Arm arm;
    public Carousel carousel;
    public Drive drive;
    // the game pads
    public Gamepad gamepad1, gamepad2;
//    Intake intake;

    public Robot(HardwareMap hardwareMap2, Gamepad gamepad1, Gamepad gamepad2) {
        // initializing all of our variables
        hardwareMap = hardwareMap2;
        arm = new Arm(this);
        carousel = new Carousel(this);
        drive = new Drive(this);
//        intake = new  Intake(this);
        subSystems = new ArrayList<>();
        teleOpManagers = new ArrayList<>();
        subSystems.add(arm);
        subSystems.add(carousel);
        subSystems.add(drive);
//        subSystems.add(intake);
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void update() {
        for(SubSystems i : subSystems)
            i.update();

        for(TeleOpManager i: teleOpManagers) {
            i.update();
            System.out.println("teleOpManagers Updating");
        }
    } // goes through the subsystem list and updates all of them

    public void createTeleOpManager(TeleOpManager teleOpManager) {
        teleOpManagers.add(teleOpManager);
        System.out.println("teleOpManager Added to List");
        System.out.println(teleOpManagers);
    }
}
