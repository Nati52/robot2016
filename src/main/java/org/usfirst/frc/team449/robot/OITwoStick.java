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

public class OITwoStick extends OISubsystem {
    private Joystick leftStick;
    private Joystick rightStick;
    private Joystick buttonPad;

    private Button stow, chivald, port, intakeUp, intakeDown, intakeIn, intakeOut;

    public OITwoStick(OIMap2016 map) {
        super(map);

        leftStick = new Joystick(2);
        rightStick = new Joystick(4);
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
     * <p>
     * This is a throttle smoothing function used on all joystick input.
     * </p>
     * <p>
     * <p>
     * The smoothed value is calculated as the following
     * </p>
     * <p>
     * sign * max / (1 - (deadband ^ power)) * (((input * sign) ^ power) -
     * (deadband ^ power))
     *
     * @param input raw throttle value (from controller)
     * @return smoothed throttle value (to send to motor cluster)
     */
    public double process(double input) {
        int sign = (input < 0) ? -1 : 1; // get the sign of the input
        input *= sign; // get the absolute value
        // if in the deadband, return 0
        if (input < 0.02) {
            return 0;
        }
        return sign * (1 / (1 - Math.pow(0.02, 2)))
                * (Math.pow(input, 2) - Math.pow(0.02, 2));
    }

    /**
     * @return the throttle of the left motor cluster
     */
    @Override
    public double getDriveAxisLeft() {
        double ret = leftStick.getRawAxis(1);
        return process(ret);
    }

    /**
     * @return the throttle of the right motor cluster
     */
    @Override
    public double getDriveAxisRight() {
        double ret = rightStick.getRawAxis(1);
        return process(ret);
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