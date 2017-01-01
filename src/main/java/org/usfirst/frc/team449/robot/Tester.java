package org.usfirst.frc.team449.robot;

import maps.org.usfirst.frc.team449.robot.RobotMap2016;

import java.io.IOException;

/**
 * This tests map.cfg locally by instantiating all the maps and printing the content of the file.
 */
public class Tester {
	/**
	 * Instantiate all maps and print the contents of map.cfg
	 */
	public static void main(String[] args) throws IOException {
		RobotMap2016.Robot2016 r16Map = (RobotMap2016.Robot2016) MappedSubsystem.readConfig("C:\\Users\\ryant\\Downloads\\map.cfg", RobotMap2016.Robot2016.newBuilder());   // TODO replace path w/ relative path
		System.out.println(r16Map);
	}
}
