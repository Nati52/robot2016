package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.oi.OIMap;

/**
 * The map of the controller configuration for the 2016 robot.
 */
public class OIMap2016 extends OIMap {
	/**
	 * USB port number of the main controller (gamepad)
	 */
	public int MAIN_CONTROLLER;

	/**
	 * USB port number of the manual overrides controller
	 * (attack joystick)
	 */
	public int MANUAL_OVERRIDES;

	/**
	 * USB port number of the button array
	 */
	public int BUTTON_PAD;

	/**
	 * Controller port number of the left drive throttle
	 */
	public int LEFT_DRIVE_STICK;

	/**
	 * Controller port number of the right drive throttle
	 */
	public int RIGHT_DRIVE_STICK;

	/**
	 * Controller port number of the intake in button
	 */
	public int INTAKE_IN;

	/**
	 * Controller port number of the intake out button
	 */
	public int INTAKE_OUT;

	/**
	 * Controller port number of the intake up button
	 */
	public int INTAKE_UP;

	/**
	 * Controller port number of the intake down button
	 */
	public int INTAKE_DOWN;

	/**
	 * Controller port number of the breach chivald (middle)
	 * button
	 */
	public int BREACH_CHIVAL;

	/**
	 * Controller port number of the breach portcullis (down)
	 * button
	 */
	public int BREACH_PORTCULLIS;

	/**
	 * Controller port number of the breach close (up)
	 * button on the gamepad
	 */
	public int BREACH_CLOSE_PRIMARY;

	/**
	 * Controller port number of the breach close (up)
	 * button on the attack joystick
	 */
	public int BREACH_CLOSE_SECONDARY;

	/**
	 * Controller port number of the camera toggle button
	 */
	public int CAMERA_TOGGLE;

	/**
	 * Controller port number of the drive straight button
	 */
	public int DRIVE_STRAIGHT;

	/**
	 * Controller port number of the ignore IR button
	 */
	public int IGNORE_IR;

	/**
	 * Controller port number of the toggle PID-aware button
	 */
	public int TOGGLE_PID;

	/**
	 * Controller port number of the intake out button on the
	 * button array
	 */
	public int BP_INTAKE_OUT;

	/**
	 * Controller port number of the intake in button on the
	 * button array
	 */
	public int BP_INTAKE_IN;

	/**
	 * Controller port number of the intake up button on the
	 * button array
	 */
	public int BP_INTAKE_UP;

	/**
	 * Controller port number of the intake down button on the
	 * button array
	 */
	public int BP_INTAKE_DOWN;

	/**
	 * Controller port number of the breach chivald button on the
	 * button array
	 */
	public int BP_BREACH_CHIVAL;

	/**
	 * Controller port number of the breach portcullis button on the
	 * button array
	 */
	public int BP_BREACH_PORTCULLIS;

	/**
	 * Controller port number of the breach close button on the
	 * button array
	 */
	public int BP_BREACH_CLOSE;

	/**
	 * Controller port number of the camera toggle button on the
	 * button array
	 */
	public int BP_CAMERA_TOGGLE;

	/**
	 * Controller port number of the AHRS zeroing button
	 */
	public int ZERO_GYRO;

	/**
	 * Controller port number of the face front button
	 */
	public int FACE_FRONT;

	/**
	 * Controller port number of the face back button
	 */
	public int FACE_BACK;

	/**
	 * Controller port number of the face left goal button
	 */
	public int FACE_LEFT_GOAL;

	/**
	 * Controller port number of the face right goal button
	 */
	public int FACE_RIGHT_GOAL;

	/**
	 * Throttle deadband value
	 */
	public double DEADBAND;

	/**
	 * Throttle power value
	 */
	public double POWER;

	/**
	 * Throttle maxout value
	 */
	public double MAX_VALUE;

	public OIMap2016(maps.org.usfirst.frc.team449.robot.OIMap2016.OI2016 message) {
		super(message.getSuper());
		BP_BREACH_CHIVAL = message.getBpBreachChival();
		BP_BREACH_CLOSE = message.getBpBreachClose();
		BP_BREACH_PORTCULLIS = message.getBpBreachPortcullis();
		BP_CAMERA_TOGGLE = message.getBpCameraToggle();
		BP_INTAKE_DOWN = message.getBpIntakeDown();
		BP_INTAKE_IN = message.getBpIntakeIn();
		BP_INTAKE_OUT = message.getBpIntakeOut();
		BP_INTAKE_UP = message.getBpIntakeUp();
		BREACH_CHIVAL = message.getBreachChival();
		BREACH_CLOSE_PRIMARY = message.getBreachClosePrimary();
		BREACH_CLOSE_SECONDARY = message.getBreachCloseSecondary();
		BREACH_PORTCULLIS = message.getBreachPortcullis();
		BUTTON_PAD = message.getButtonPad();
		CAMERA_TOGGLE = message.getCameraToggle();
		DEADBAND = message.getDeadband();
		DRIVE_STRAIGHT = message.getDriveStraight();
		FACE_BACK = message.getFaceBack();
		FACE_FRONT = message.getFaceFront();
		FACE_LEFT_GOAL = message.getFaceLeftGoal();
		FACE_RIGHT_GOAL = message.getFaceRightGoal();
		IGNORE_IR = message.getIgnoreIr();
		INTAKE_DOWN = message.getIntakeDown();
		INTAKE_IN = message.getIntakeIn();
		INTAKE_OUT = message.getIntakeOut();
		INTAKE_UP = message.getIntakeUp();
		LEFT_DRIVE_STICK = message.getLeftDriveStick();
		MAIN_CONTROLLER = message.getMainController();
		MANUAL_OVERRIDES = message.getManualOverrides();
		MAX_VALUE = message.getMaxValue();
		POWER = message.getPower();
		RIGHT_DRIVE_STICK = message.getRightDriveStick();
		TOGGLE_PID = message.getTogglePid();
		ZERO_GYRO = message.getZeroGyro();
	}
}
