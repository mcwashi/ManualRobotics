package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Pushbot: Team8648 Pushbot Teleop", group="Pushbot")
public class Team8648PushbotTeleOp extends OpMode {

    Team8648HardwarePushbot robot = new Team8648HardwarePushbot();


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left;
        double right;
        double armMotor;
        double armRaiseMotor;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

        //arm
        armMotor = -gamepad2.right_stick_y;
        armRaiseMotor = -gamepad2.left_stick_y;



        robot.leftDrive.setPower(left);
        robot.rightDrive.setPower(right);
        robot.arm.setPower(armMotor);//changed**
        robot.armRaise.setPower(armRaiseMotor);//changed***



        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.right_bumper)
            robot.lift.setPower(1);
        else if (gamepad1.left_bumper)
            robot.lift.setPower(-1);
        else
            robot.lift.setPower(0);


        //Slide Arm Controller buttons??????
        //i was told not to use this on 1-13-18
        if(gamepad2.a)
            robot.armServo.setPosition(1);
        else if (gamepad2.y)
            robot.armServo.setPosition(-1);
        else robot.armServo.setPosition(0);



        // Send telemetry message to signify robot running;
        //telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        //telemetry.addData("left",  "%.2f", left);
        //telemetry.addData("right", "%.2f", right);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }


}
