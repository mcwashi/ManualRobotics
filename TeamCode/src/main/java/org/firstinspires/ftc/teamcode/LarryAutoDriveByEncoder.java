package org.firstinspires.ftc.teamcode;

/**
 * Created by SucramMedia on 12/21/17.
 */



import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;



import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

/**
 * This file illustrates the concept of driving a path based on encoder counts.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code REQUIRES that you DO have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByTime;
 *
 *  This code ALSO requires that the drive Motors have been configured such that a positive
 *  power command moves them forwards, and causes the encoders to count UP.
 *
 *   The desired path in this example is:
 *   - Drive forward for 48 inches
 *   - Spin right for 12 Inches
 *   - Drive Backwards for 24 inches
 *   - Stop and close the claw.
 *
 *  The code is written using a method called: encoderDrive(speed, leftInches, rightInches, timeoutS)
 *  that performs the actual movement.
 *  This methods assumes that each movement is relative to the last stopping place.
 *  There are other ways to perform encoder based moves, but this method is probably the simplest.
 *  This code uses the RUN_TO_POSITION mode to enable the Motor controllers to generate the run profile
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Larry Pushbot: Auto Drive By Encoder", group="Pushbot")
//@Disabled
public class LarryAutoDriveByEncoder extends LinearOpMode {

    /* Declare OpMode members. */
    LarryHardwarePushbot robot = new LarryHardwarePushbot();   // Use a Pushbot's hardware
    ElapsedTime runtime = new ElapsedTime();
    ColorSensor colorSensor;

    static final double COUNTS_PER_MOTOR_REV = 1220;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 3.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;
    ColorSensor sensorColor;
    DistanceSensor sensorDistance;


    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color");
        colorSensor.enableLed(true);


        // get a reference to the color sensor.
        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");

        // get a reference to the distance sensor that shares the same name.
        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_color_distance");

        // hsvValues is an array that will hold the hue, saturation, and value information.
        //float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        //final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        //final double SCALE_FACTOR = 255;




        // Send telemetry message to signify robot waiting;
       // telemetry.addData("Status", "Resetting Encoders");    //
        //telemetry.update();

        //robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0", "Starting at %7d :%7d",
                robot.leftDrive.getCurrentPosition(),
                robot.rightDrive.getCurrentPosition());
        telemetry.update();

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        //int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        //final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //while (opModeIsActive()) {
            // convert the RGB values to HSV values.
            // multiply by the SCALE_FACTOR.
            // then cast it back to int (SCALE_FACTOR is a double)
          //  Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
            //        (int) (sensorColor.green() * SCALE_FACTOR),
            //          (int) (sensorColor.blue() * SCALE_FACTOR),
            //        hsvValues);

            // send the info back to driver station using telemetry function.
            //telemetry.addData("Distance (cm)",
              //      String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
            //telemetry.addData("Alpha", sensorColor.alpha());
            //telemetry.addData("Red  ", sensorColor.red());
            //telemetry.addData("Green", sensorColor.green());
            //telemetry.addData("Blue ", sensorColor.blue());
            //telemetry.addData("Hue", hsvValues[0]);

            // change the background color to match the color detected by the RGB sensor.
            // pass a reference to the hue, saturation, and value array as an argument
            // to the HSVToColor method.
            //relativeLayout.post(new Runnable() {
              //  public void run() {
              //      relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
              //  }
           // });

            //telemetry.update();

            // Set the panel back to the default color
            //relativeLayout.post(new Runnable() {
              //  public void run() {
                //    relativeLayout.setBackgroundColor(Color.WHITE);
               // }
           // });
       // }

        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        armDown(10.0);
        jewel(20.0);
        //encoderDrive(DRIVE_SPEED, 4, 4, 5.0);  // S1: Forward 47 Inches with 5 Sec timeout
        //encoderDrive(TURN_SPEED, 3, -3, 4.0);  // S2: Turn Right 12 Inches with 4 Sec timeout
        //encoderDrive(DRIVE_SPEED, 3, 3, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout


        //telemetry.addData("Path", "Complete");
        //telemetry.update();
    }

    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = robot.leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            robot.leftDrive.setTargetPosition(newLeftTarget);
            robot.rightDrive.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftDrive.setPower(Math.abs(speed));
            robot.rightDrive.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.leftDrive.isBusy() && robot.rightDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        robot.leftDrive.getCurrentPosition(),
                        robot.rightDrive.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
    public void jewel(double holdTime){

        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;

        // convert the RGB values to HSV values.
        // multiply by the SCALE_FACTOR.
        // then cast it back to int (SCALE_FACTOR is a double)
        Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                (int) (sensorColor.green() * SCALE_FACTOR),
                (int) (sensorColor.blue() * SCALE_FACTOR),
                hsvValues);
        // send the info back to driver station using telemetry function.
        telemetry.addData("Alpha", sensorColor.alpha());
        telemetry.addData("Red  ", sensorColor.red());
        telemetry.addData("Green", sensorColor.green());
        telemetry.addData("Blue ", colorSensor.blue());
        //telemetry.addData()
        //telemetry.addData("Hue", hsvValues[0]);
        //telemetry.update();
       // armUp(holdTime);

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);



        ElapsedTime holdTimer = new ElapsedTime();
        holdTimer.reset();
        while (opModeIsActive() && holdTimer.time() < holdTime) {
            //if (sensorColor.blue() > 10) {
            if (colorSensor.blue() > colorSensor.red()) {
                encoderDrive(DRIVE_SPEED, 1, 1, 1.0);  // S1: Forward 47 Inches with 5 Sec timeout
                //encoderDrive(TURN_SPEED, -2, 2, 2.0);
                //encoderDrive(TURN_SPEED, 2, -2, 2.0);
            //    robot.colorSensorServo.setPosition(0.0);
            } else {
                //encoderDrive(TURN_SPEED, 2, -2, 2.0);
                //encoderDrive(TURN_SPEED, -2, 2, 2.0);
                robot.colorSensorServo.setPosition(0.0);

            }
            //robot.leftDrive.setPower(0);
            //robot.rightDrive.setPower(0);
        }
    }


    public void armUp(double holdTime){

        robot.colorSensorServo.setPosition(0.0);

    }



    public void armDown(double holdTime) {
        ElapsedTime holdTimer = new ElapsedTime();
        holdTimer.reset();
        while (opModeIsActive() && holdTimer.time() < holdTime) {
            robot.colorSensorServo.setPosition(1.0);
        }
    }

}