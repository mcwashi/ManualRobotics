package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name = "PracticeRobot")
public class PracticeRobot extends OpMode {
    DcMotor leftSide;
    DcMotor rightSide;

    public void init(){
        leftSide = hardwareMap.dcMotor.get("left_drive");
        rightSide = hardwareMap.dcMotor.get("right_drive");
        rightSide.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void loop(){
        leftSide.setPower(-gamepad1.left_stick_y / 3);
        rightSide.setPower(-gamepad1.right_stick_y / 3);
    }


}
