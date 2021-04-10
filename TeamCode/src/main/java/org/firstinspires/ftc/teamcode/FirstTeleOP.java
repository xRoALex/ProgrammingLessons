package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "FirstTeleOP", group = "Linear Mode")
public class FirstTeleOP extends LinearOpMode {
    private Robot robot;

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;

    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, Robot.DRIVING_MODE.TELEOP);

        waitForStart();

        while(opModeIsActive()) {
            double xValue = gamepad1.left_stick_x;
            double yValue = -gamepad1.left_stick_y;
            double zValue = gamepad1.right_trigger - gamepad1.left_trigger;

            robot.setMotorPowers(
                    yValue + xValue + zValue,
                    yValue - xValue - zValue,
                    yValue + xValue - zValue,
                    yValue- xValue + zValue);

            if(gamepad1.dpad_left && !isLeftPressed ){
                robot.setServoPosition(robot.getServoPosition() - 0.01f);
                isLeftPressed = true;
            } else if(gamepad1.dpad_right && !isRightPressed){
                robot.setServoPosition(robot.getServoPosition() + 0.01f);
                isRightPressed = true;
            }

            if(!gamepad1.dpad_left) {
                isLeftPressed = false;
            }

            if(!gamepad1.dpad_right) {
                isRightPressed = false;
            }

            if(gamepad1.a) {
                robot.setServoLeft();
            } else if(gamepad1.b) {
                robot.setServoRight();
            }

            telemetry.addData("Servo Position: ", robot.getServoPosition());

            telemetry.addData("isLeftPressed: ", isLeftPressed);
            telemetry.addData("isRightPressed: ", isRightPressed);

            telemetry.addData("xValue: ", xValue);
            telemetry.addData("yValue: ", yValue);
            telemetry.addData("zValue: ", zValue);

            telemetry.addData("frontRight: ",robot.getFrontRightPosition());
            telemetry.addData("frontLeft: ", robot.getFrontLeftPosition());
            telemetry.addData("backRight: ",robot.getBackRightPosition());
            telemetry.addData("backLeft: ", robot.getBackLeftPosition());

            telemetry.update();
        }
    }
}
