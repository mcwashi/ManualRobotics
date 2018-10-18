package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Pushbot: Team9688 Pushbot Teleop", group="Pushbot")
public class Team9688PushbotTeleOp extends OpMode {

    Team9688HardwarePushbot robot = new Team9688HardwarePushbot();


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
        double whiteMotor;
        double yellowMotor;
        double greenMotor = 0;
        double blueMotor = 0;
        double redMotor = 0;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;


        whiteMotor = -gamepad2.left_stick_y;
        yellowMotor = -gamepad2.right_stick_y;





        robot.leftDrive.setPower(left);
        robot.rightDrive.setPower(right);
        robot.white.setPower(whiteMotor);//changed**
        robot.yellow.setPower(yellowMotor);//changed***
        robot.green.setPower(greenMotor);
        robot.blue.setPower(blueMotor);
        robot.red.setPower(redMotor);





        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.y)
            robot.yellow.setPower(1);
        else if (gamepad1.a)
            robot.yellow.setPower(-0.01);
        else
            robot.yellow.setPower(0);

        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad2.y)
            robot.white.setPower(1);
        else if (gamepad2.a)
            robot.white.setPower(-0.01);
        else
            robot.white.setPower(0);


        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.dpad_up)
            robot.green.setPower(1);
        else if (gamepad2.dpad_down)
            robot.green.setPower(-0.01);
        else
            robot.green.setPower(0);

        if (gamepad2.dpad_up)
            robot.red.setPower(1);
        else if (gamepad2.dpad_down)
            robot.red.setPower(-0.01);
        else
            robot.red.setPower(0);

        if (gamepad2.dpad_left)
            robot.blue.setPower(1);
        else if (gamepad2.dpad_right)
            robot.blue.setPower(-0.01);
        else
            robot.blue.setPower(0);




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
