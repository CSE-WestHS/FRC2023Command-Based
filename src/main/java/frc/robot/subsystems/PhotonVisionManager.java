package frc.robot.subsystems; // Uncomment in implementation
import java.util.*;
import org.photonvision.*;
// The import below should be part of the code above. It is not.
import org.photonvision.targeting.PhotonTrackedTarget;

 // Requires dependency
 // https://maven.photonvision.org/repository/internal/org/photonvision/PhotonLib-json/1.0/PhotonLib-json-1.0.json
public class PhotonVisionManager{
    List<PhotonTrackedTarget> targets;
    PhotonTrackedTarget[] targetArray = new PhotonTrackedTarget[9];
    PhotonCamera myCamera;
    // 
    // 8 targets on field, making them start at 1 because frc used 1-8 instead of 0-7
    // This version is built for AprilTags.
    // to use: instantiate and call SetCamera with name of your camera.Then place Update in Robot Periodic and call methods when needed!
    // Plays fine with CommandBase

    public static PhotonCamera newCamera(String cameraName){
        // Run to get cameras of a specific name. Testbed camera is Cam1
        return new PhotonCamera(cameraName);
    }
    public void setCamera(PhotonCamera newCamera){
        myCamera = newCamera;
    }
    public void setCamera(String cameraName){
        myCamera = newCamera(cameraName);
    }
    public int[] AprilTagsSeen(){
        ArrayList<Integer> ret1 = new ArrayList<Integer>();
        for (PhotonTrackedTarget index : targetArray){
            try {
                index.getFiducialId();
                ret1.add(index.getFiducialId());
            }
            catch(Exception e){}
        }
        int[] ret = new int[ret1.size()];
        // Dont ask me why I took this approach, it sucks but I REALLY wanted an int array output.
        for (int x = 0; x < ret1.size() -1; x ++){
            ret[x] = ret1.get(x);
        }
        return ret;


    }
    // Methods below throw NullPointerException, exception must be handled when methods are called. 
    // NullPointerException will occur if it cannot see the AprilTag in question. 
    
    public double getApriltagPitch(int aprilID) throws NullPointerException{
        return targetArray[aprilID].getPitch();
        
    }
    public double getApriltagYaw(int aprilID) throws NullPointerException{
        return targetArray[aprilID].getYaw();
    }
    public double getApriltagArea(int aprilID) throws NullPointerException{
        return targetArray[aprilID].getArea();
    }
    public void updateCameraData(){
        // Constantly updates list of targets, if target is not visible, location is NULL. 

       targets = myCamera.getLatestResult().getTargets();
       targetArray = new PhotonTrackedTarget[9];
       for (PhotonTrackedTarget index : targets){
        try {
            targetArray[index.getFiducialId()] = index;
        } catch (Exception IndexOutOfBoundsException){
            System.out.println("Invalid ID " +index.getFiducialId());
        }
        
       }
    }
    public Boolean tagSeen(){
        
        if (AprilTagsSeen().length == 0){
            return false;
        }
        
        return true;
    }
    public Boolean tagSeen(int tag){
        try {
            targetArray[tag].getFiducialId();
            return true;
        } catch (Exception NullPointerException){
            return false;
        }
    }
    
}