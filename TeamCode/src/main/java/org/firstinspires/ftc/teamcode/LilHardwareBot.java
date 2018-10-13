package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class LilHardwareBot {
    /* Public OpMode members. */
    public DcMotor leftDrive   = null;
    public DcMotor  rightDrive  = null;
    public DcMotor  mainArm     = null;
    public DcMotor  slideArm    = null;

    public Servo leftClaw    = null;
    public Servo    rightClaw   = null;
    public Servo    longReclicClaw    = null;
    public Servo    shortReclicClaw   = null;
    public Servo    colorSensorServo  = null;
    public Servo    hitBallServo      = null;


    public static final double MID_SERVO       =  0.25;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();


    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        mainArm    = hwMap.get(DcMotor.class, "main_arm");
//        slideArm   = hwMap.get(DcMotor.class, "slide");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors


        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        mainArm.setPower(0);
//        slideArm.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mainArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        slideArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        // Define and initialize ALL installed servos.
        leftClaw  = hwMap.get(Servo.class, "left_hand");
        rightClaw = hwMap.get(Servo.class, "right_hand");
//        longReclicClaw  = hwMap.get(Servo.class, "long_relic_claw");
//        shortReclicClaw = hwMap.get(Servo.class, "short_relic_claw");
        //colorSensorServo = hwMap.get(Servo.class, "color_sensor_servo");
        //hitBallServo = hwMap.get(Servo.class, "hit_ball_servo");


        leftClaw.setPosition(MID_SERVO);
        rightClaw.setPosition(MID_SERVO);
//        longReclicClaw.setPosition(0);
//        shortReclicClaw.setPosition(0);
        //colorSensorServo.setPosition(0);
        //hitBallServo.setPosition(.50);
    }
}
