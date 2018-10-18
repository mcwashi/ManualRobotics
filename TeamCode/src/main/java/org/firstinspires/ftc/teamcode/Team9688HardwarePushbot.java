package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Team9688HardwarePushbot {

    /* Public OpMode members. */
    public DcMotor  leftDrive   = null;
    public DcMotor  rightDrive  = null;
    public DcMotor  yellow     = null;
    public DcMotor  white    = null;
    public DcMotor  green    = null;
    public DcMotor  blue    = null;
    public DcMotor  red    = null;



    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Team9688HardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "LeftMotor");
        rightDrive = hwMap.get(DcMotor.class, "RightMotor");
        yellow    = hwMap.get(DcMotor.class, "YellowMotor");
        white   = hwMap.get(DcMotor.class, "WhiteMotor");
        green   = hwMap.get(DcMotor.class, "GreenMotor");
        blue   = hwMap.get(DcMotor.class, "BlueMotor");
        red  = hwMap.get(DcMotor.class, "RedMotor");


        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors


        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        yellow.setPower(0);
        white.setPower(0);
        green.setPower(0);
        blue.setPower(0);
        red.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        yellow.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        white.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        green.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        blue.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        red.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
}
