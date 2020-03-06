import java.util.ArrayList;

/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a part object, with the idea that the user will create concrete classes that
 * inherit from it. It has String attributes to represent data that will be present in every concrete instance, as
 * well as an array of Parts that contains its children, and a Part that is its parent
 */
public class Part
{
	protected String name;
	protected String description;
	protected ArrayList<Part> children;
	protected Part parent;
	
	public Part()
	{
		name = "Name";
		description = "Description";
		children = new ArrayList<Part>();
		parent = null;
	}
	
	public Part(String name, String description, Part parent)
	{
		this.name = name;
		this.description = description;
		this.children = new ArrayList<Part> ();
		this.parent = parent;
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
	
	public ArrayList<Part> getChildren()
	{
		return children;
	}
	
	public void setChildren(ArrayList<Part> children)
	{
		this.children = children;
	}
	
	public Part getParent()
	{
		return parent;
	}
	
	public void setParent(Part parent)
	{
		this.parent = parent;
	}
	
	public void addChild(Part curr)
	{
		this.children.add(curr);
	}
	
	public String toString()
	{
		String str = "";
		str += (this.name + "\n");
		str += (this.description + "\n");
		
		if(this.children.size() != 0)
		{
			str += "Children: ";
			for(Part element: this.children)
			{
				str += (element.getName() + " ");
			}
			
			str += "\n";
		}
		else
		{
			str += "No children\n";
		}
		
		
		if(this.parent != null)
		{
			str += "Parent: ";
			str += this.parent.getName();
		}
		else
		{
			str += "No parent";
		}
		
		return str + "\n";
	}
}
