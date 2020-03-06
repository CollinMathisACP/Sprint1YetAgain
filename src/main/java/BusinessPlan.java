import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * 
 * This class represents a Business Plan object, with the idea that the user will create concrete classes that
 * inherit from it. It has String attributes to represent data that will be present in every concrete instance, as
 * well as an array of Parts that contains the heads of each plan.
 *
 */
public class BusinessPlan
{
	protected String name;
	protected String description;
	protected String date;
	protected ArrayList<Part> planHeads;
	
	public BusinessPlan()
	{
		name = "Name";
		description = "Description";
		date = "Date";
		planHeads = new ArrayList<Part>();
	}
	
	public BusinessPlan(String name, String description, String date)
	{
		this.name = name;
		this.description = description;
		this.date = date;
		this.planHeads = new ArrayList<Part> ();
	}
	
	public void addChild(Part curr)
	{
		this.planHeads.add(curr);
	}
	
	public Part getChildByName(String name)
	{		
		Part p = null;
		for(int i = 0; i < planHeads.size(); i++)
		{
			//Call the helper for the head of each tree
			Part current = getChildByNameHelper(planHeads.get(0), name);
			
			if(current != null)
			{
				p = current;
			}
		}
		
		return p;
	}
	

	
	private Part getChildByNameHelper(Part child, String name)
	{
		Part dum = null;
		if (child.getName().equals(name)){
			//We've found the node 
			dum = child;
		}else {
			ArrayList<Part> listofKids = child.getChildren();
			if (listofKids.size() > 0) {
				for(int i = 0; i < listofKids.size(); i++) {
					//We have not found the node yet. Search this node's children
					Part test  = getChildByNameHelper(listofKids.get(i), name);
					if (test != null) {
						dum =  test;
					}
				}
			}else {
				//Base case: the current node is a leaf and we have not found the node
				dum =  null;
			}
		}
		
		return dum;
		

	}
	
	public Part removeChildByName(String name)
	{
		//Find the node to be removed
		Part toBeRemoved = this.getChildByName(name);
		
		if(toBeRemoved == null)
		{
			return null;
		}
		
		else
		{
			//Remove the node by removing it from its parent's children array
			Part parent = toBeRemoved.getParent();
			
			//the node to be removed is a plan head
			if(parent == null)
			{
				this.planHeads.remove(toBeRemoved);
				return toBeRemoved;
			}
			
			else
			{
				parent.getChildren().remove(parent);
				return toBeRemoved;
			}
			
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public ArrayList<Part> getPlanHeads()
	{
		return planHeads;
	}
	
	public void setPlanHeads(ArrayList<Part> planHeads)
	{
		this.planHeads = planHeads;
	}
	
	//Saves this instance to a xml file, with the parameter being the file name.
	//Will throw a FileNotFoundException if it fails.
	public void savePlan(String filename)
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	//Static method that decodes an xml representation of a BusinessPlan, and returns it
	public static BusinessPlan openPlan(String filename)
	{
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		BusinessPlan openedFile=(BusinessPlan)decoder.readObject();
		
		return openedFile;
		
	}
	
	public String toString()
	{
		String str = "";
		str += (this.name + "\n");
		str += (this.description + "\n");
		str += (this.date + "\n");
		
		if(this.planHeads.size() != 0)
		{
			for(Part element: planHeads)
			{
				str += toStringHelper(element);
			}
		}
		else
		{
			str += "No children\n";
		}
		
		return str;

	}
	
	private String toStringHelper(Part p)
	{
		String str = "";
		str += p.toString();
		for(Part element: p.getChildren())
		{
			str += this.toStringHelper(element);
		}
		
		return str;
	}
}
