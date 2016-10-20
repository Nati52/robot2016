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
import org.usfirst.frc.team449.robot.oi.OIMap;
import org.usfirst.frc.team449.robot.oi.OISubsystem;

/**
 * This is the Operator Interface which includes all of the buttons, joysticks,
 * and other human input devices used to control the robot.
 */
public class OITwoStick extends OISubsystem {
    private RobotMap map;

    private Joystick leftStick;
    private Joystick rightStick;
    private Joystick buttonPad;

    private int sign = 1;

    private Button stow, chivald, port, intakeUp, intakeDown, intakeIn, intakeOut;

    /**
     * Instantiate a new <code>OI</code>.
     *
     * @param map
     *            {@link OIMap} that contains the constants for the OI
     */
    public OITwoStick(OIMap map) {
        super(map);
        this.map = map;

        leftStick = new Joystick(2);
        rightStick = new Joystick(4);
        buttonPad = new Joystick(1);

        // Navigational buttons
//        Button driveStraight = new JoystickButton(rightStick, 1);
//        driveStraight.whileHeld(new DriveStraight((TankDriveSubsystem) Robot.drive, this));
//        Button faceFront = new JoystickButton(rightStick, 3);
//        Button faceBack = new JoystickButton(rightStick, 2);
//        Button turnRight = new JoystickButton(rightStick, 5);
//        Button turnLeft = new JoystickButton(leftStick, 4);
//        faceFront.toggleWhenPressed(new TurnAngle(0));
//        faceBack.toggleWhenPressed(new TurnAngle(180));
//        turnLeft.toggleWhenPressed(new TurnAngle(120));
//        turnRight.toggleWhenActive(new TurnAngle(-120));


        // Breach buttons
        Button stow = new JoystickButton(buttonPad, 1);

        Button chivald = new JoystickButton(buttonPad, 3);

        Button port = new JoystickButton(buttonPad, 4);


        // Intake
        Button intakeUp = new JoystickButton(buttonPad, 6);

        Button intakeDown = new JoystickButton(buttonPad, 7);

        Button intakeIn = new JoystickButton(buttonPad, 8);

        Button intakeOut = new JoystickButton(buttonPad, 9);

        // Camera
        Button toggleCamera = new JoystickButton(buttonPad, 10);



//		bpIntakeIn.toggleWhenPressed(new IntakeIn());

//		bpIntakeOut.whileHeld(new IntakeOut());
        // TODO intakeToggle command
        //intakeUp.whenPressed(new IntakeUp());
        //bpIntakeUp.whenPressed(new IntakeUp());
        //intakeDown.whenPressed(new IntakeDown());
        //bpIntakeDown.whenPressed(new IntakeDown());
//		bpBreachChival.whenPressed(new BreachChivald());
//		bpBreachPort.whenPressed(new BreachPortcullis());

//		breachCloseSecondary.whenPressed(new BreachStowed());
//		bpBreachClose.whenPressed(new BreachStowed());

        try {
//			cameraToggle.whenPressed(new ToggleCamera());
        } catch (Exception e) {
            System.out.println("(OI constructor) Cameras done goofed, but everything else is (maybe) functional.");
        }

//		ignoreIR.whenPressed(new ToggleIgnoreIR());
//		togglePid.whenPressed(new TogglePid());

//        faceFront.toggleWhenPressed(new TurnAngle(0));
//        faceBack.toggleWhenPressed(new TurnAngle(180));
//        faceLeft.toggleWhenPressed(new TurnAngle(120));
//        faceRight.toggleWhenActive(new TurnAngle(-120));

//        zeroGyro.whenPressed(new ZeroGyro());
    }

    public void mapButtons() {
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
    public double getDriveAxisLeft() {
//		double ret = sign * this.gamecube.getRawAxis(map.LEFT_DRIVE_STICK);
        double ret = sign * this.leftStick.getRawAxis(1);
        return process(ret) / 2;
//		return process(ret);
    }

    /**
     * @return the throttle of the right motor cluster
     */
    public double getDriveAxisRight() {
//		double ret = sign * this.gamecube.getRawAxis(map.RIGHT_DRIVE_STICK);
        double ret = sign * this.rightStick.getRawAxis(1);
        return process(ret) / 2;
//		return process(ret);
    }

    /**
     * <p>
     * This is a throttle smothing function used on all joystick input.
     * </p>
     *
     * <p>
     * The smoothed value is calculated as the following
     * </p>
     *
     * sign * max / (1 - (deadband ^ power)) * (((input * sign) ^ power) -
     * (deadband ^ power))
     *
     * @param input
     *            raw throttle value (from controller)
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

    @Override
    public void toggleCamera() {
        // Do nothing!
    }

    @Override
    protected void initDefaultCommand() {
        // Do nothing!
    }
}