package testerpackage;

import project.*;

/**
 * @author Ryan Hansen
 *
 * Just using to test my code. will convert this into the JUnit testing later.
 */
public class main {

	public static void main(String[] args) {
		
		ProjectManager.createInsulation("1st Insulation Project Name");		
		System.out.println(ProjectManager.projectList.get(0).getName());
		
		ProjectManager.createInsulation("2nd Insulation Project Name");
		ProjectManager.createInsulation("3rd Insulation Project Name");
		
		for (int i = 0; i < ProjectManager.projectList.size(); i++) {
			System.out.println(ProjectManager.projectList.get(i).getName());			
		}
		
		
		ProjectManager.save();
		
	}

}