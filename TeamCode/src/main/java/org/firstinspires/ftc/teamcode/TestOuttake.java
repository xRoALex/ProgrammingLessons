package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TestOuttake", group = "Linear Mode")
public class TestOuttake extends LinearOpMode {

    private double velocity = 0.8f;

    private boolean isPressed = false;

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;

    private DcMotor out1, out2;

    @Override
    public void runOpMode() {
        out1 = hardwareMap.get(DcMotor.class, "out1");
        out2 = hardwareMap.get(DcMotor.class, "out2");

        out1.setDirection(DcMotorSimple.Direction.FORWARD);
        out2.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while(opModeIsActive()) {

            if(gamepad1.b) {
                out1.setPower(0);
                out2.setPower(0);
            }
            if(gamepad1.a && !isPressed) {
                out1.setPower(velocity);
                out2.setPower(velocity);
                isPressed = true;
            }

            if(!gamepad1.a) {
                isPressed = false;
            }

            if(!isLeftPressed && gamepad1.dpad_left) {
                velocity -= 0.01f;
                isLeftPressed = true;
            } else if(!isRightPressed && gamepad1.dpad_right) {
                velocity += 0.01f;
                isRightPressed = true;
            }

            if(!gamepad1.dpad_left) {
                isLeftPressed = false;
            }
            if(!gamepad1.dpad_right) {
                isRightPressed = false;
            }

            telemetry.addData("Velocity: ", velocity);
            telemetry.update();
        }
    }
}
