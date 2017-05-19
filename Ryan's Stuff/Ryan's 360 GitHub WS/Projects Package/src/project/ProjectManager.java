package project;
import java.util.ArrayList;

/**
 * @author Ryan Hansen
 *
 * This class will serve as the location where projects will be created as well
 * as saved and loaded for future use.
 */
public class ProjectManager {

	public ArrayList<Project> allProjects = new ArrayList<Project>();
	
	public void createNewInsulationProject(String theName) {
		InsulationProject newProject = new InsulationProject();
		newProject.setName(theName);
		allProjects.add(newProject);
	}	
}