package org.usfirst.frc.team2609.robot.subsystems;
import org.usfirst.frc.team2609.robot.Robot;
import org.usfirst.frc.team2609.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FlipSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static enum flipState{
		BADGUY, GOODGUY
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    DoubleSolenoid doubleSolenoid1 = RobotMap.flip;
    flipState prevState = flipState.GOODGUY;
    
    public void toggleRND() {
//    	flipState currentState = this.getState();
    	flipState currentState = this.randomState();
    	
    	System.out.println("flipState: " + currentState.toString());
    	System.out.println("Solenoid: " + setDoor(currentState).toString());
    	switch(currentState){
    	case BADGUY:
    		doubleSolenoid1.set(this.setDoor(flipState.GOODGUY));
    		return;
    	case GOODGUY:
    		doubleSolenoid1.set(this.setDoor(flipState.BADGUY));
    		return;
    	default:
    		System.out.println("Unknown flip state!");
    		break;
    	}
    }
    public void toggle() {
    	flipState currentState = this.getState();
    	
    	System.out.println("flipState: " + currentState.toString());
    	System.out.println("Solenoid: " + setDoor(currentState).toString());
    	switch(currentState){
    	case BADGUY:
    		prevState = flipState.GOODGUY;
    		doubleSolenoid1.set(this.setDoor(flipState.GOODGUY));
    		return;
    	case GOODGUY:
    		prevState = flipState.BADGUY;
    		doubleSolenoid1.set(this.setDoor(flipState.BADGUY));
    		return;
    	default:
    		System.out.println("Unknown flip state!");
    		break;
    	}
    }
    public flipState getState(){
    	switch(doubleSolenoid1.get()){
    	case kForward:
    		return flipState.GOODGUY;
    	case kReverse:
    		return flipState.BADGUY;
    	case kOff:
    		return prevState;
    	default:
    		return prevState;
    	}
    }
    public flipState randomState(){

    	double rnd = Math.random();
    	if(rnd>0.5){
    		return flipState.GOODGUY;
    	}else{
    		return flipState.BADGUY;
    	}
    }
    public DoubleSolenoid.Value setDoor(flipState desiredState){
    	switch(desiredState){
    	case BADGUY:
    		return DoubleSolenoid.Value.kReverse;
    	case GOODGUY:
    		return DoubleSolenoid.Value.kForward;
    	default:
    		return DoubleSolenoid.Value.kOff;
    	}
    		
    }
    public void setNeutral(){
		doubleSolenoid1.set(DoubleSolenoid.Value.kOff);
    	
    }
    public void forceSet(DoubleSolenoid.Value intendedValue){
    	doubleSolenoid1.set(intendedValue);
    }
}
