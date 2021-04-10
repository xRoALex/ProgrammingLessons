package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

import java.sql.Driver;

public class Robot {
    public enum DRIVING_MODE{
        AUTONOMOUS, TELEOP
    }

    private final static double distanceToEncoderRatio = 30;

    private final static double LEFT_SERVO_POSITON = 0.38f;
    private final static double RIGHT_SERVO_POSITION = 0.93f;
    private final DcMotor frontRight;
    private final DcMotor frontLeft;
    private final DcMotor backRight;
    private final DcMotor backLeft;
    private final Servo servo;

    public Robot(HardwareMap hardwareMap, DRIVING_MODE mode) {
        frontLeft = hardwareMap.get(DcMotor.class,"fst");
        frontRight = hardwareMap.get(DcMotor.class,"fdr");
        backLeft = hardwareMap.get(DcMotor.class,"sst");
        backRight = hardwareMap.get(DcMotor.class,"sdr");

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        if(mode == DRIVING_MODE.TELEOP) {
            frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        } else if(mode == DRIVING_MODE.AUTONOMOUS){
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        servo = hardwareMap.get(Servo.class, "Servo0");

        servo.setDirection(Servo.Direction.FORWARD);

        servo.setPosition(0f);
    }

    public double getFrontRightPosition() {
        return frontRight.getCurrentPosition();
    }

    public double getFrontLeftPosition() {
        return frontLeft.getCurrentPosition();
    }

    public double getBackRightPosition() {
        return backRight.getCurrentPosition();
    }

    public double getBackLeftPosition() {
        return backLeft.getCurrentPosition();
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

    public void moveForward(double distance) {
        int distanceInEncoderTicks = (int) Math.round(distance * distanceToEncoderRatio);

        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + distanceInEncoderTicks);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + distanceInEncoderTicks);
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + distanceInEncoderTicks);
        backRight.setTargetPosition(backRight.getCurrentPosition() + distanceInEncoderTicks);

        frontRight.setPower(1f);
        frontLeft.setPower(1f);
        backRight.setPower(1f);
        backLeft.setPower(1f);

        while(frontLeft.isBusy() || frontRight.isBusy() ||
               backLeft.isBusy() || backRight.isBusy());

    }

    public void turnRight(double angle) {

    }

    public void turnLeft(double angle) {

    }

    public void moveBack(double distance) {

    }


    public void setPowerForOneMotor(int motor, double power) {

    }
}
