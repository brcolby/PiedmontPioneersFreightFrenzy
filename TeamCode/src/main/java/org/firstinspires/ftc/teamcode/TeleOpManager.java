package org.firstinspires.ftc.teamcode;

import java.util.function.BooleanSupplier;

public class TeleOpManager{
    public BooleanSupplier trigger;
    public RobotAction action;

    public TeleOpManager(BooleanSupplier trigger, RobotAction action) {
        this.trigger = trigger;
        this.action = action;
    }
    public void update() {
        if (trigger.getAsBoolean())
            action.run();
    }
}