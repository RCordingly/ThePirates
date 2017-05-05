package project;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Ryan Hansen
 *
 * This class will serve as the location where projects will be created as well
 * as saved and loaded for furture use.
 */
public class ProjectManager {

	public static ArrayList<Project> projectList = new ArrayList<Project>();
	
	public static void createInsulation(String theName) {
		InsulationProject newProject = new InsulationProject();
		
		// Adds INS to the front of the name to make it identifiable as
		// a insulation project when it comes time to load from the saved file.
		String totalName = ("INS" + theName);
		
		newProject.setName(totalName);
		projectList.add(newProject);
	}
	
	
	// Saves the ArrayList of projects to a file in the current working directory.
	public static void save() {
		
		//long name making it easy to search for
		String filename = "ThePiratesProjectSave";
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));			
			oos.writeObject(projectList);	
			oos.flush();
		} catch (FileNotFoundException e){
			System.out.print(e);
		} catch (IOException e){
			System.out.print(e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.print("oos closing error\n");
					System.out.print(e);
				}
			}
		}	
	}
	
	
	public static void load() {
		//in development
	}
}