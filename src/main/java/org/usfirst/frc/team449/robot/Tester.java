package org.usfirst.frc.team449.robot;

import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import maps.org.usfirst.frc.team449.robot.RobotMap2016;
import org.json.JSONObject;
import org.usfirst.frc.team449.robot.drive.tank.TankDriveMap;
import org.usfirst.frc.team449.robot.mechanism.breach.BreachMap;
import org.usfirst.frc.team449.robot.mechanism.intake.IntakeMap;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * This tests cfg.json locally by instantiating all the maps and printing an
 * unescaped and an escaped version of the content of the file.
 */
public class Tester {
    /**
     * Instantiate all maps and print an unescaped and escaped version of the contents of map.cfg
     */
    public static void main(String[] args) {
        Message map = null;
        maps.org.usfirst.frc.team449.robot.RobotMap2016.Robot2016 r16Map = null;
        Message.Builder builder = maps.org.usfirst.frc.team449.robot.RobotMap2016.Robot2016.newBuilder();
        try {
            TextFormat.getParser().merge(new String(Files.readAllBytes((new File("src/main/resources/cfg.json")).toPath()),
                    StandardCharsets.UTF_8), builder);
            map = builder.build();
        } catch (IOException e) {
            System.out.println("IO error!");
            e.printStackTrace(); // if this happens, we're fucked
        }
        try {
            r16Map = (RobotMap2016.Robot2016) map;
        } catch (ClassCastException e){
            System.out.println("Cast error!");
            e.printStackTrace();
        }
        TankDriveMap tdm = new TankDriveMap(r16Map.getDrive());
        IntakeMap im = new IntakeMap(r16Map.getIntake());
        BreachMap bm = new BreachMap(r16Map.getBreach());
        OIMap2016 oim = new OIMap2016(r16Map.getOi());
//		AutoMap am = new AutoMap(jo);
        String s = TextFormat.printToString(map);
        System.out.println(s);
        System.out.println(s.replaceAll("(?<!\\\\)\"", "\\\\\""));
    }
}
