package org.usfirst.frc.team2609.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2609.robot.commands.*;

public class OI {
    public static Joystick driverStick;
    public static JoystickButton button1;
    public static JoystickButton button2;
    public static JoystickButton button3;
    public static JoystickButton button4;
    public static JoystickButton button5;
    public static JoystickButton button6;
    public static JoystickButton button7;
    public static JoystickButton button9;
    public static JoystickButton button10;
    //public static JoystickButton opbutton9;
    //public static JoystickButton opbutton10;
    public JoystickButton shift;
    public JoystickButton toggleDeployClaw;
    public JoystickButton toggleClaw;
    public JoystickButton toggleLED;
    public JoystickButton VulcanGearScore;
    public JoystickButton VulcanGearMode;
    public JoystickButton VulcanBallMode;
    public static JoystickButton vulcanGearScore;
    public JoystickButton BallDoorToggle;
    public JoystickButton ClawForceOpen;

    public static Joystick opStick;
    public JoystickButton TsunamiUp;
    public JoystickButton TsunamiDown;
    
    public static JoystickButton opButton1;
    public static JoystickButton opButton2;
    public static JoystickButton opButton3;
    public static JoystickButton opButton4;
    public static JoystickButton opButton5;
    public static JoystickButton opButton6;
    public static JoystickButton opButton7;
    public static JoystickButton opButton9;
    public static JoystickButton opButton10;
    
    public OI() {
    	driverStick = new Joystick(0);

        button1 = new JoystickButton(driverStick, 1);
        button1.whenPressed(new FlipToggleRND());
        button2 = new JoystickButton(driverStick, 2);
        button2.whenPressed(new FlipBadguy());
        button3 = new JoystickButton(driverStick, 3);
        button3.whenPressed(new FlipGoodguy());
        button3 = new JoystickButton(driverStick, 4);
        button3.whenPressed(new FlipToggle());


    }
    public Joystick getdriverStick() {
        return driverStick;
    }
}