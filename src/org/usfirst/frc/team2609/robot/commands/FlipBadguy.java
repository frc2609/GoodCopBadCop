package org.usfirst.frc.team2609.robot.commands;

import org.usfirst.frc.team2609.robot.Robot;
import org.usfirst.frc.team2609.robot.subsystems.FlipSubsystem.flipState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlipBadguy extends Command {

    public FlipBadguy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.flip.forceSet(Robot.flip.setDoor(flipState.BADGUY));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timeSinceInitialized()>.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flip.setNeutral();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
