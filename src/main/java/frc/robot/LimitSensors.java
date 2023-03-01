package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
public class LimitSensors {
    DigitalInput CraneSwitchFront = new DigitalInput(0);
    DigitalInput CraneSwitchBack = new DigitalInput(1);
    AnalogInput ExtendorString = new AnalogInput(2);
    public boolean CraneSwitchedFront(){
        // If true, limit is switched.
        
        return !CraneSwitchFront.get();
    }
    public boolean CraneSwitchedBack(){
        // If true, limit is switched.
        
        return !CraneSwitchBack.get();
    }
    public double getPotVoltage(){
        return ExtendorString.getVoltage();
    }
    
}
