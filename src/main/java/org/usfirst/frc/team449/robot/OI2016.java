//package org.usfirst.frc.team449.robot;
//
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team449.robot.drive.tank.TankDriveSubsystem;
//import org.usfirst.frc.team449.robot.drive.tank.commands.DriveStraight;
////import org.usfirst.frc.team449.robot.drive.tank.commands.TogglePid;
//import org.usfirst.frc.team449.robot.drive.tank.commands.TurnAngle;
//import org.usfirst.frc.team449.robot.drive.tank.commands.ZeroGyro;
//import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachChivald;
//import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachPortcullis;
//import org.usfirst.frc.team449.robot.mechanism.breach.commands.BreachStowed;
//import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeDown;
//import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeIn;
//import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeOut;
//import org.usfirst.frc.team449.robot.mechanism.intake.commands.IntakeUp;
//import org.usfirst.frc.team449.robot.mechanism.intake.commands.ToggleIgnoreIR;
//import org.usfirst.frc.team449.robot.oi.OISubsystem;
//
//public class OI2016 extends OISubsystem {
//    private OIMap2016 oiMap2016;
//    private Joystick manualOverrides;
//    private Joystick gamecube;
//    private Joystick buttonPad;
//    private Button intakeIn, intakeOut, intakeUp, intakeDown, breachChival, breachPortcullis, breachClosePrimary,
//            breachCloseSecondary, cameraToggle, driveStraightVel, ignoreIR, togglePid, faceFront, faceBack, faceGoalLeft,
//            faceGoalRight, bpIntakeUp, bpIntakeDown, bpIntakeIn, bpIntakeOut, bpBreachChival, bpBreachPort, bpBreachClose,
//            bpCameraToggle, zeroGyro;
//
//    public OI2016(OIMap2016 map) {
//        super(map);
//
//        oiMap2016 = (OIMap2016) map;
//
//        gamecube = new Joystick(map.MAIN_CONTROLLER);
//        manualOverrides = new Joystick(map.MANUAL_OVERRIDES);
//        buttonPad = new Joystick(map.BUTTON_PAD);
//
//        intakeIn = new JoystickButton(gamecube, map.INTAKE_IN);
//        intakeOut = new JoystickButton(gamecube, map.INTAKE_OUT);
//        intakeUp = new JoystickButton(gamecube, map.INTAKE_UP);
//        intakeDown = new JoystickButton(gamecube, map.INTAKE_DOWN);
//        breachChival = new JoystickButton(gamecube, map.BREACH_CHIVAL);
//        breachPortcullis = new JoystickButton(gamecube, map.BREACH_PORTCULLIS);
//        breachClosePrimary = new JoystickButton(gamecube, map.BREACH_CLOSE_PRIMARY);
//        breachCloseSecondary = new JoystickButton(manualOverrides, map.BREACH_CLOSE_SECONDARY);
//        cameraToggle = new JoystickButton(gamecube, map.CAMERA_TOGGLE);
//        driveStraightVel = new JoystickButton(gamecube, map.DRIVE_STRAIGHT);
//        ignoreIR = new JoystickButton(manualOverrides, map.IGNORE_IR);
//        togglePid = new JoystickButton(manualOverrides, map.TOGGLE_PID);
//        faceFront = new JoystickButton(manualOverrides, map.FACE_FRONT);
//        faceBack = new JoystickButton(manualOverrides, map.FACE_BACK);
//        faceGoalLeft = new JoystickButton(manualOverrides, map.FACE_LEFT_GOAL);
//        faceGoalRight = new JoystickButton(manualOverrides, map.FACE_RIGHT_GOAL);
//        bpIntakeDown = new JoystickButton(buttonPad, map.BP_INTAKE_DOWN);
//        bpIntakeUp = new JoystickButton(buttonPad, map.BP_INTAKE_UP);
//        bpIntakeIn = new JoystickButton(buttonPad, map.BP_INTAKE_IN);
//        bpIntakeOut = new JoystickButton(buttonPad, map.BP_INTAKE_OUT);
//        bpBreachChival = new JoystickButton(buttonPad, map.BP_BREACH_CHIVAL);
//        bpBreachPort = new JoystickButton(buttonPad, map.BP_BREACH_PORTCULLIS);
//        bpBreachClose = new JoystickButton(buttonPad, map.BP_BREACH_CLOSE);
//        bpCameraToggle = new JoystickButton(buttonPad, map.BP_CAMERA_TOGGLE);
//        zeroGyro = new JoystickButton(gamecube, map.ZERO_GYRO);
//    }
//
//    protected void mapButtons() {
//        intakeIn.toggleWhenPressed(new IntakeIn(Robot.intake));
//        bpIntakeIn.toggleWhenPressed(new IntakeIn(Robot.intake));
//        intakeOut.whileHeld(new IntakeOut(Robot.intake));
//        bpIntakeOut.whileHeld(new IntakeOut(Robot.intake));
//        intakeUp.whenPressed(new IntakeUp(Robot.intake));
//        bpIntakeUp.whenPressed(new IntakeUp(Robot.intake));
//        intakeDown.whenPressed(new IntakeDown(Robot.intake));
//        bpIntakeDown.whenPressed(new IntakeDown(Robot.intake));
//
//        breachChival.whenPressed(new BreachChivald(Robot.breach));
//        bpBreachChival.whenPressed(new BreachChivald(Robot.breach));
//        breachPortcullis.whenPressed(new BreachPortcullis(Robot.breach));
//        bpBreachPort.whenPressed(new BreachPortcullis(Robot.breach));
//        breachClosePrimary.whenPressed(new BreachStowed(Robot.breach));
//        breachCloseSecondary.whenPressed(new BreachStowed(Robot.breach));
//        bpBreachClose.whenPressed(new BreachStowed(Robot.breach));
//
////        try {
////            cameraToggle.whenPressed(new ToggleCamera(Robot.vision));
////        } catch (Exception e) {
////            System.out.println("(OI constructor) Cameras done goofed, but everything else is (maybe) functional.");
////        }
//
//        ignoreIR.whenPressed(new ToggleIgnoreIR(Robot.intake));
////        togglePid.whenPressed(new TogglePid((TankDriveSubsystem) Robot.drive));
//        driveStraightVel.whileHeld(new DriveStraight((TankDriveSubsystem) Robot.drive, this));
//
//        faceFront.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 0));
//        faceBack.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 180));
//        faceGoalLeft.toggleWhenPressed(new TurnAngle((TankDriveSubsystem) Robot.drive, 120));
//        faceGoalRight.toggleWhenActive(new TurnAngle((TankDriveSubsystem) Robot.drive, -120));
//
//        zeroGyro.whenPressed(new ZeroGyro((TankDriveSubsystem) Robot.drive));
//    }
//
//    /**
//     * <p>
//     * This is a throttle smoothing function used on all joystick input.
//     * </p>
//     * <p>
//     * <p>
//     * The smoothed value is calculated as the following
//     * </p>
//     * <p>
//     * sign * max / (1 - (deadband ^ power)) * (((input * sign) ^ power) -
//     * (deadband ^ power))
//     *
//     * @param input raw throttle value (from controller)
//     * @return smoothed throttle value (to send to motor cluster)
//     */
//    public double process(double input) {
//        int sign = (input < 0) ? -1 : 1; // get the sign of the input
//        input *= sign; // get the absolute value
//        // if in the deadband, return 0
//        if (input < oiMap2016.DEADBAND) {
//            return 0;
//        }
//        return sign * (oiMap2016.MAX_VALUE / (1 - Math.pow(oiMap2016.DEADBAND, oiMap2016.POWER)))
//                * (Math.pow(input, oiMap2016.POWER) - Math.pow(oiMap2016.DEADBAND, oiMap2016.POWER));
//    }
//
//    /**
//     * @return the throttle of the left motor cluster
//     */
//    @Override
//    public double getDriveAxisLeft() {
//        double ret = gamecube.getRawAxis(oiMap2016.LEFT_DRIVE_STICK);
//        return process(ret);
//    }
//
//    /**
//     * @return the throttle of the right motor cluster
//     */
//    @Override
//    public double getDriveAxisRight() {
//        double ret = gamecube.getRawAxis(oiMap2016.RIGHT_DRIVE_STICK);
//        return process(ret);
//    }
//
//    /**
//     * @return whether the driver is enabling drive straight mode (driving
//     * straight based on right stick throttle)
//     */
//    public boolean isDriveStraightMode() {
//        return gamecube.getRawButton(oiMap2016.DRIVE_STRAIGHT);
//    }
//
//
//    @Override
//    public void toggleCamera() {
//        // Do nothing!
//    }
//
//    @Override
//    protected void initDefaultCommand() {
//        // Do nothing!
//    }
//}
