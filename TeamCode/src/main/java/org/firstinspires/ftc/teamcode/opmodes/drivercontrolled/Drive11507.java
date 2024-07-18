package org.firstinspires.ftc.teamcode.opmodes.drivercontrolled;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (group = "TeleOp", name = "Drive11507")
public class Drive11507 extends OpMode {
    //define the motors, servos, sensors and so forth that you will use throughout your OpMode here
    // remember to import
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor armMotor;

    /**
     * this is where you should initialise all of your variables you just defined, this is what runs
     * when you press the init button
     */
    @Override
    public void init() {
        this.leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        this.armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        this.leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        this.armMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    /**
     * this is the "main" function. it runs when you press the play button for this OpMode
     * it is a loop so will run continuously until you press stop
     */
    @Override
    public void loop() {

        //drive is forward and backward movement
        float drive = gamepad1.left_stick_y; //ranges from -1 to 1
        float turn = gamepad1.left_stick_x; //ranges from -1 to 1

        float rightPower = drive + turn; //ranges from -2 to 2, when turning right, a.k.a. turn is positive, right motor must go backwards
        rightPower /= 2; //normalise to range of -1 to 1
        float leftPower = drive - turn; //ranges from -2 to 2, when turning right, a.k.a. turn is positive, left motor must go forwards
        leftPower /= 2; //normalise to range of -1 to 1

        this.leftMotor.setPower(leftPower);
        this.rightMotor.setPower(rightPower);

        int armMotorPower = gamepad1.right_bumper ? 1:0; // ternary operator (gamepad1.right_bumper is a boolean (true or false), this operator will turn it into a 1 if true and 0 if false)
        armMotorPower += gamepad1.left_bumper ? -1:0;

        this.armMotor.setPower(armMotorPower);

    }

    // this is where you should define helper functions for your main code
}