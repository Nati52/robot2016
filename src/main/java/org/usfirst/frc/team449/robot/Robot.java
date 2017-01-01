package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import maps.org.usfirst.frc.team449.robot.RobotMap2016;
import org.usfirst.frc.team449.robot.drive.DriveSubsystem;
import org.usfirst.frc.team449.robot.drive.tank.TankDriveSubsystem;
import org.usfirst.frc.team449.robot.mechanism.breach.BreachSubsystem;
import org.usfirst.frc.team449.robot.mechanism.intake.IntakeSubsystem;

import java.util.HashMap;
import java.util.Set;

/**
 * This is the class that contains all of the subsystems and
 * components for the 2016 robot.
 */
public class Robot extends IterativeRobot {
	private HashMap<DigitalInput, Command> autos;

	/**
	 * The Message containing the constants from map.cfg for this robot
	 */
	private static maps.org.usfirst.frc.team449.robot.RobotMap2016.Robot2016 cfg;

	/**
	 * This is the robot's drive subsystem. Any command that uses this
	 * field will cast it to the <code>DriveSubsystem</code> implementation it uses.
	 */
	public static DriveSubsystem drive;

	/**
	 * This is the robot's intake subsystem.
	 */
	public static IntakeSubsystem intake;

	/**
	 * This is the robot's breach subsystem.
	 */
	public static BreachSubsystem breach;

	/**
	 * This is the robot's Operator Interface (OI)
	 */
	public static OITwoStick oi;

	/**
	 * This is the <code>Command</code> that the robot will execute during the
	 * autonomous period.
	 */
	private Command autonomousCommand;

	/**
	 * <p>
	 * This instantiates all of the subsystems and autonomous autonomous selections.
	 * </p>
	 * <p>
	 * <p>
	 * Autonomous period selections are not done by the <code>SendableChooser</code>, as
	 * FMS dropouts sometimes cause <code>SendableChooser</code>s to fail. Instead, the
	 * autonomous period is chosen from headers placed in free DIO ports shorting 5v pin to
	 * the signal pin.
	 * </p>
	 */
	@Override
	public void robotInit() {
		System.out.println("Starting robotInit");
		try {
			System.out.println("Starting cfg init");
			cfg = (RobotMap2016.Robot2016) MappedSubsystem.readConfig("/home/lvuser/map.cfg", RobotMap2016.Robot2016.newBuilder());

			System.out.println("Starting oi init");
			oi = new OITwoStick(cfg.getOi());
			System.out.println("Starting drive init");
			drive = new TankDriveSubsystem(cfg.getDrive(), oi);
			System.out.println("Starting intake init");
			intake = new IntakeSubsystem(cfg.getIntake());
			System.out.println("Starting breach init");
			breach = new BreachSubsystem(cfg.getBreach());

		} catch (Exception e) {
			String s = e.getMessage();
			StackTraceElement[] arr = e.getStackTrace();
			for (StackTraceElement el : arr) {
				s += "\n  " + el.toString();
			}
			DriverStation.reportError(s, true);
			e.printStackTrace();
			System.exit(1);
		}

		oi.mapButtons();
		System.out.println("Button map complete");
	}

	@Override
	public void disabledInit() {
	}

	/**
	 * Get the autonomous command and run it during the autonomous period
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = getAutoCommand();
		if (autonomousCommand != null)
			;
		autonomousCommand.start();
	}

	/**
	 * End the autonomous period and begin the telop period
	 */
	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void testInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Get the autonomous command from the DIO pins and display it on the SmartDashboard.
	 */
	private Command getAutoCommand() {
		Set<DigitalInput> inputs = autos.keySet();
		for (DigitalInput di : inputs) {
			SmartDashboard.putBoolean("DIO " + di.getChannel(), di.get());
			System.out.println("DIO " + di.getChannel() + " " + di.get());
		}
		for (DigitalInput di : inputs) {
			if (!di.get()) {
				return autos.get(di);
			}
		}
		return null;
	}
}
