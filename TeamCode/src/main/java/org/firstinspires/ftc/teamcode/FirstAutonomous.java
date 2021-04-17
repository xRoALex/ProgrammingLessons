package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Autonomous
public class FirstAutonomous extends LinearOpMode {

    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, Robot.DRIVING_MODE.AUTONOMOUS);

        waitForStart();

        robot.moveForward(100);

        robot.moveForward(-100);

    }
}
