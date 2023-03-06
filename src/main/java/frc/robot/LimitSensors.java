package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.Constants;
public class LimitSensors {
    DigitalInput CraneSwitchFront = new DigitalInput(Constants.DIO_FRONT);
    DigitalInput CraneSwitchBack = new DigitalInput(Constants.DIO_BACK);
    // ZA WARDO
    AnalogInput ExtendorString = new AnalogInput(Constants.ANALOG_STRINGPOT);
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
    public double GetExtendorPos(){
        final double RATIO_OF_VOLTS = Constants.EXTENDOR_MAX/Constants.ANALOG_VOLTS_MAX;
        // Returns in inches the extendor's position.
        return getPotVoltage() * RATIO_OF_VOLTS;


    }
    
}
