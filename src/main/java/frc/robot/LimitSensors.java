package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
public class LimitSensors {
    DigitalInput CraneSwitchFront = new DigitalInput(0);
    public boolean CraneSwitchedFront(){
        // If true, limit is switched.
        
        return !CraneSwitchFront.get();
    }
}
