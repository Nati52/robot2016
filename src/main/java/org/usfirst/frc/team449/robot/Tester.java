package org.usfirst.frc.team449.robot;

import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import maps.org.usfirst.frc.team449.robot.RobotMap2016;
import org.usfirst.frc.team449.robot.drive.tank.TankDriveMap;
import org.usfirst.frc.team449.robot.mechanism.breach.BreachMap;
import org.usfirst.frc.team449.robot.mechanism.intake.IntakeMap;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * This tests map.cfg locally by instantiating all the maps and printing the content of the file.
 */
public class Tester {
	/**
	 * Instantiate all maps and print the contents of map.cfg
	 */
	public static void main(String[] args) throws IOException {
		RobotMap2016.Robot2016 r16Map = (RobotMap2016.Robot2016) MappedSubsystem.readConfig("C:\\Users\\ryant\\Downloads\\map.cfg", RobotMap2016.Robot2016.newBuilder());   // TODO replace path w/ relative path
		TankDriveMap tdm = new TankDriveMap(r16Map.getDrive());
		IntakeMap im = new IntakeMap(r16Map.getIntake());
		BreachMap bm = new BreachMap(r16Map.getBreach());
		OIMap2016 oim = new OIMap2016(r16Map.getOi());
		System.out.println(r16Map);
	}
}
