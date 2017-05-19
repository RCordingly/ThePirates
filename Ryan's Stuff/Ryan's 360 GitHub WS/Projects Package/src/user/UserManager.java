package user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Ryan Hansen
 *
 * File which will store all the user information including a list of their projects.
 */
public class UserManager {

	public static ArrayList<User> allUsers = new ArrayList<User>();
	public static ArrayList<User> savedUsers;
	private static User loadedUser;
	
	
	public static User getLoadedUser() {
        return loadedUser;
    }
	
	public static ArrayList<User> getUsers() {
        return allUsers;
    }
	
	public static void createNewUser(final String theName, final String theEmail) {
		User newUser = new User(theName, theEmail);
		allUsers.add(newUser);
	}
	
	
	// Saves the ArrayList of projects to a file in the current working directory.
	public static void save() {
		
		//long name making it easy to search for
		String filename = "ThePiratesProjectSave";
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));			
			oos.writeObject(allUsers);	
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
		String filename = "ThePiratesProjectSave";
		
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			Object obj = ois.readObject();
			
			if (obj instanceof ArrayList<?>) {
				savedUsers = (ArrayList<User>) obj;
			}
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					System.out.println("ois closing error\n");
					System.out.println(e);
				}
			}
		}
	}
	
}