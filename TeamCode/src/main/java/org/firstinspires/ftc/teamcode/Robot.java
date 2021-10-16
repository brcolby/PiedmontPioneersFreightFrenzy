package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.SubSystems;

import java.util.ArrayList;

public class Robot {
    public ArrayList<SubSystems> subSystems;
    public ArrayList<TeleOpManager> teleOpManagers;
    public HardwareMap hardwareMap;
    public Arm arm;
    public Carousel carousel;
    public Drive drive;
    public Gamepad gamepad1, gamepad2;

    public Robot(HardwareMap hardwareMap2, Gamepad gamepad1, Gamepad gamepad2) {
        arm = new Arm(this);
        carousel = new Carousel(this);
        drive = new Drive(this);
        subSystems = new ArrayList<>();
        subSystems.add(arm);
        subSystems.add(carousel);
        subSystems.add(drive);
        hardwareMap = hardwareMap2;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }
    public void update() {
        for(SubSystems i : subSystems)
            i.update();

        for(TeleOpManager i: teleOpManagers)
            i.update();
    }
    public void createTeleOpManager(TeleOpManager teleOpManager) {
        teleOpManagers.add(teleOpManager);
    }
}
