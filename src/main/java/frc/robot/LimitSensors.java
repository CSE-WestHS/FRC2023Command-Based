package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
public class LimitSensors {
    DigitalInput CraneSwitch = new DigitalInput(0);
    public boolean CraneSwitched(){
        // If true, limit is switched.
        if (CraneSwitch.get()){
            return false;
        }
        return true;
    }
}
