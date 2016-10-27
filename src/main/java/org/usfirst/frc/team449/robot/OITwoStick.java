package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachChivald;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachPortcullis;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachStowed;
import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeDown;
import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeIn;
import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeOut;
import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeUp;
import org.usfirst.frc.team449.robot.oi.OISubsystem;
import org.usfirst.frc.team449.robot.oi.components.SmoothedThrottle;

public class OITwoStick extends OISubsystem {
    private Joystick leftStick;
    private SmoothedThrottle leftThrottle;
    private Joystick rightStick;
    private SmoothedThrottle rightThrottle;
    private Joystick buttonPad;

    private Button stow, chivald, port, intakeUp, intakeDown, intakeIn, intakeOut;

    public OITwoStick(OIMap2016 map) {
        super(map);

        leftStick = new Joystick(2);
        leftThrottle = new SmoothedThrottle(leftStick, 1);
        rightStick = new Joystick(4);
        rightThrottle = new SmoothedThrottle(rightStick, 1);
        buttonPad = new Joystick(1);

        // Breach buttons
        stow = new JoystickButton(buttonPad, 1);
        chivald = new JoystickButton(buttonPad, 3);
        port = new JoystickButton(buttonPad, 4);

        // Intake
        intakeUp = new JoystickButton(buttonPad, 6);
        intakeDown = new JoystickButton(buttonPad, 7);
        intakeIn = new JoystickButton(buttonPad, 8);
        intakeOut = new JoystickButton(buttonPad, 9);
    }

    protected void mapButtons() {
        stow.whenPressed(new BreachStowed(Robot.breach));
        chivald.whenPressed(new BreachChivald(Robot.breach));
        port.whenPressed(new BreachPortcullis(Robot.breach));
        intakeUp.whenPressed(new IntakeUp(Robot.intake));
        intakeDown.whenPressed(new IntakeDown(Robot.intake));
        intakeIn.toggleWhenPressed(new IntakeIn(Robot.intake));
        intakeOut.whileHeld(new IntakeOut(Robot.intake));
    }

    /**
     * @return the throttle of the left motor cluster
     */
    @Override
    public double getDriveAxisLeft() {
        return leftThrottle.getValue();
    }

    /**
     * @return the throttle of the right motor cluster
     */
    @Override
    public double getDriveAxisRight() {
        return rightThrottle.getValue();
    }

    /**
     * @return whether the driver is enabling drive straight mode (driving
     * straight based on right stick throttle)
     */
    public boolean isDriveStraightMode() {
        return false;
    }

    @Override
    public void toggleCamera() {
        // Do nothing!
    }

    @Override
    protected void initDefaultCommand() {
        // Do nothing!
    }
}