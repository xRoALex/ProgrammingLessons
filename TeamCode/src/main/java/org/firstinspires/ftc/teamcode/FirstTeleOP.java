package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "FirstTeleOP", group = "Linear Mode")
public class FirstTeleOP extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            double xValue = gamepad1.left_stick_x;
            double yValue = -gamepad1.left_stick_y;

            robot.setMotorPowers(yValue + xValue,yValue - xValue,
                    yValue + xValue,yValue- xValue);

            telemetry.addData("xValue: ", xValue);
            telemetry.addData("yValue: ", yValue);
            telemetry.update();
        }
    }
}
