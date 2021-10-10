package org.firstinspires.ftc.teamcode;

public class TeleOpManager {
    public GamepadTrigger trigger;
    public RobotAction action;

    public TeleOpManager(GamepadTrigger trigger, RobotAction action) {
        this.trigger = trigger;
        this.action = action;
    }
    public void update() {
        if (trigger.buttonPressed())
            action.run();
    }
}
