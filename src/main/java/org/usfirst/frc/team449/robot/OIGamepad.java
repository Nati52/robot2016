package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team449.robot.drive.tank.TankDriveSubsystem;
import org.usfirst.frc.team449.robot.drive.tank.commands.DriveStraight;
import org.usfirst.frc.team449.robot.drive.tank.commands.TurnAngle;
import org.usfirst.frc.team449.robot.drive.tank.commands.ZeroGyro;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachChivald;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachPortcullis;
import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachStowed;
import org.usfirst.frc.team449.robot.mechanism.intake.commands.*;
import org.usfirst.frc.team449.robot.oi.OISubsystem;
import org.usfirst.frc.team449.robot.oi.components.SmoothedThrottle;

public class OIGamepad extends OISubsystem {
	private maps.org.usfirst.frc.team449.robot.oi.OIMap2016.OI2016 oiMap2016;
	private Joystick manualOverrides;
	private Joystick gamecube;
	private Joystick buttonPad;
	private Button intakeIn, intakeOut, intakeUp, intakeDown, breachChival, breachPortcullis, breachClosePrimary,
			breachCloseSecondary, cameraToggle, driveStraightVel, ignoreIR, togglePid, faceFront, faceBack,
			faceGoalLeft,
			faceGoalRight, bpIntakeUp, bpIntakeDown, bpIntakeIn, bpIntakeOut, bpBreachChival, bpBreachPort,
            bpBreachClose,
			bpCameraToggle, zeroGyro;
	private SmoothedThrottle leftThrottle, rightThrottle;

	public OIGamepad(maps.org.usfirst.frc.team449.robot.oi.OIMap2016.OI2016 map) {
		super(map.getOi());

		oiMap2016 = map;

		gamecube = new Joystick(map.getMainController());
		manualOverrides = new Joystick(map.getManualOverrides());
		buttonPad = new Joystick(map.getButtonPad());

		intakeIn = new JoystickButton(gamecube, map.getIntakeIn());
		intakeOut = new JoystickButton(gamecube, map.getIntakeOut());
		intakeUp = new JoystickButton(gamecube, map.getIntakeUp());
		intakeDown = new JoystickButton(gamecube, map.getIntakeDown());
		breachChival = new JoystickButton(gamecube, map.getBreachChival());
		breachPortcullis = new JoystickButton(gamecube, map.getBreachPortcullis());
		breachClosePrimary = new JoystickButton(gamecube, map.getBreachClosePrimary());
		breachCloseSecondary = new JoystickButton(manualOverrides, map.getBreachCloseSecondary());
		cameraToggle = new JoystickButton(gamecube, map.getCameraToggle());
		driveStraightVel = new JoystickButton(gamecube, map.getDriveStraight());
		ignoreIR = new JoystickButton(manualOverrides, map.getIgnoreIr());
		togglePid = new JoystickButton(manualOverrides, map.getTogglePid());
		faceFront = new JoystickButton(manualOverrides, map.getFaceFront());
		faceBack = new JoystickButton(manualOverrides, map.getFaceBack());
		faceGoalLeft = new JoystickButton(manualOverrides, map.getFaceLeftGoal());
		faceGoalRight = new JoystickButton(manualOverrides, map.getFaceRightGoal());
		bpIntakeDown = new JoystickButton(buttonPad, map.getBpIntakeDown());
		bpIntakeUp = new JoystickButton(buttonPad, map.getBpIntakeUp());
		bpIntakeIn = new JoystickButton(buttonPad, map.getBpIntakeIn());
		bpIntakeOut = new JoystickButton(buttonPad, map.getBpIntakeOut());
		bpBreachChival = new JoystickButton(buttonPad, map.getBpBreachChival());
		bpBreachPort = new JoystickButton(buttonPad, map.getBpBreachPortcullis());
		bpBreachClose = new JoystickButton(buttonPad, map.getBpBreachClose());
		bpCameraToggle = new JoystickButton(buttonPad, map.getBpCameraToggle());
		zeroGyro = new JoystickButton(gamecube, map.getZeroGyro());
		leftThrottle = new SmoothedThrottle(gamecube, oiMap2016.getLeftDriveStick());
		rightThrottle = new SmoothedThrottle(gamecube, oiMap2016.getRightDriveStick());
	}

	protected void mapButtons() {
		intakeIn.toggleWhenPressed(new IntakeIn(Robot.intake));
		bpIntakeIn.toggleWhenPressed(new IntakeIn(Robot.intake));
		intakeOut.whileHeld(new IntakeOut(Robot.intake));
		bpIntakeOut.whileHeld(new IntakeOut(Robot.intake));
		intakeUp.whenPressed(new IntakeUp(Robot.intake));
		bpIntakeUp.whenPressed(new IntakeUp(Robot.intake));
		intakeDown.whenPressed(new IntakeDown(Robot.intake));
		bpIntakeDown.whenPressed(new IntakeDown(Robot.intake));

		breachChival.whenPressed(new BreachChivald(Robot.breach));
		bpBreachChival.whenPressed(new BreachChivald(Robot.breach));
		breachPortcullis.whenPressed(new BreachPortcullis(Robot.breach));
		bpBreachPort.whenPressed(new BreachPortcullis(Robot.breach));
		breachClosePrimary.whenPressed(new BreachStowed(Robot.breach));
		breachCloseSecondary.whenPressed(new BreachStowed(Robot.breach));
		bpBreachClose.whenPressed(new BreachStowed(Robot.breach));

		//        try {
		//            cameraToggle.whenPressed(new ToggleCamera(Robot.vision));
		//        } catch (Exception e) {
		//            System.out.println("(OI constructor) Cameras done goofed, but everything else is (maybe)
        // functional.");
		//        }

		ignoreIR.whenPressed(new ToggleIgnoreIR(Robot.intake));
		//        togglePid.whenPressed(new TogglePid((TankDriveSubsystem) Robot.drive));
		driveStraightVel.whileHeld(new DriveStraight((TankDriveSubsystem) Robot.drive, this));

		faceFront.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 0));
		faceBack.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 180));
		faceGoalLeft.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 120));
		faceGoalRight.toggleWhenActive(new TurnAngle((TankDriveSubsystem) Robot.drive, -120));

		zeroGyro.whenPressed(new ZeroGyro((TankDriveSubsystem) Robot.drive));
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
		return gamecube.getRawButton(oiMap2016.getDriveStraight());
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