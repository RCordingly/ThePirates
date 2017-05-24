package project;

import gui.GUIPage;

import java.io.Serializable;

/**
 * @author Ryan Hansen
 *
 * Abstract class which declares the getters and setters for the
 * project classes.
 */

@SuppressWarnings("serial") // suppressing warning about no serialization number because this class
							// will not be instantiated.
public abstract class Project  implements Serializable {

    //TODO: Clean up this class. This class really should only have variables/methods that ALL projects will use.
    //TODO: Along with that, many of methods should be abstract/don't need public access.

	protected String name;
	protected double initialCost;
	protected double monthlyCost;
	protected int quantity;
	protected double pricePerUnit;
	protected double electricityUsage;
	protected double gasUsage;
	protected double waterUsage;
	protected double monthlySavings;

	public abstract GUIPage getSummaryPage();

    public abstract GUIPage getEditPage();

    public void setName(String theName) {
		this.name = theName;
	}

	public String getName() {
		return this.name;
	}
		
	//Getters and setters for initialCost
	public void setIntialCost(double theInitialCost) {
		this.initialCost = theInitialCost;
	}
	
	public abstract double getInitialCost();
	
	//Getters and setters for monthlyCost
	public void setMonthlyCost(double theMonthlyCost) {
		this.monthlyCost = theMonthlyCost;
	}
	
	public double getMonthlyCost() {
		return this.monthlyCost;
	}
	
	//Getters and setters for quantity
	public void setQuantity(int theQuantity) {
		this.quantity = theQuantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	//Getters and setters for pricePerUnit
	public void setPricePerUnit(double thePricePerUnit){
		this.pricePerUnit = thePricePerUnit;
	}
	
	public double getPricePerUnit() {
		return this.pricePerUnit;
	}
	
	//Getters and setters for electicityUsage
	public void setElectricityUsage(double theElectricityUsage){
		this.electricityUsage = theElectricityUsage;
	}
	
	public double getElectricityUsage() {
		return this.electricityUsage;
	}
	
	//Getters and setters for gasUsage
	public void setGasUsage(double theGasUsage) {
		this.gasUsage = theGasUsage;
	}
	public double getGasUsage() {
		return this.gasUsage;
	}
	
	//Getters and setters for waterUsage
	public void setWaterUsage(double theWaterUsage) {
		this.waterUsage = theWaterUsage;
	}
	public double getWaterUsage() {
		return this.waterUsage;
	}

	public abstract double getMonthlySavings();
}
