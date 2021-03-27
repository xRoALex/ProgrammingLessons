package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

public class Robot {
    private final static double LEFT_SERVO_POSITON = 0.38f;
    private final static double RIGHT_SERVO_POSITION = 0.93f;
    private final DcMotor frontRight;
    private final DcMotor frontLeft;
    private final DcMotor backRight;
    private final DcMotor backLeft;
    private final Servo servo;

    public Robot(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class,"fst");
        frontRight = hardwareMap.get(DcMotor.class,"fdr");
        backLeft = hardwareMap.get(DcMotor.class,"sst");
        backRight = hardwareMap.get(DcMotor.class,"sdr");

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        servo = hardwareMap.get(Servo.class, "Servo0");

        servo.setDirection(Servo.Direction.FORWARD);

        servo.setPosition(0f);
    }

    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    public void setServoLeft() {
        setServoPosition(LEFT_SERVO_POSITON);
    }

    public void setServoRight() {
        setServoPosition(RIGHT_SERVO_POSITION);
    }

    public double getServoPosition() {
        return servo.getPosition();
    }

    public void setMotorPowers(double frontLeftPower, double frontRightPower,
                               double backLeftPower, double backRightPower) {
        frontRight.setPower(frontRightPower);
        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    public void setPowerForOneMotor(int motor, double power) {

    }
}
