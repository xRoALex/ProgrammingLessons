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
            double zValue = gamepad1.right_trigger - gamepad1.left_trigger;

            robot.setMotorPowers(
                    yValue + xValue - zValue,
                    yValue - xValue + zValue,
                    yValue + xValue + zValue,
                    yValue- xValue - zValue);

            telemetry.addData("xValue: ", xValue);
            telemetry.addData("yValue: ", yValue);
            telemetry.addData("zValue; ", zValue);
            telemetry.update();
        }
    }
}
