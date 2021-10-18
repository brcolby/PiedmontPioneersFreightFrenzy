package org.firstinspires.ftc.teamcode;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class TeleOpManager {
    public BooleanSupplier trigger;
    public RobotAction action, action2;

    public boolean prevState, state, toggle = false;

    public TeleOpManager(BooleanSupplier trigger, RobotAction action) {
        this.trigger = trigger;
        this.action = action;
    }

    public TeleOpManager(BooleanSupplier trigger, RobotAction action, RobotAction action2) {
        this.trigger = trigger;
        this.action = action;
        this.action2 = action2;
        toggle = true;
    }

    public void update() {
        if (!toggle) {
            if (trigger.getAsBoolean())
                action.run();
        }

        else if (toggle) {
            if (trigger.getAsBoolean()) {
                if (!prevState)
                    state = !state;
                prevState = true;
            }
            else {
                if (prevState)
                    prevState = false;
            }
            if(state)
                action.run();
            else
                action2.run();
        }
    }
}