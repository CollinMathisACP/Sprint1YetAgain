
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents an Objective, a concrete implementation of a Part.
 * The only difference is that addChild only accepts a Strategy, in order to preserve the VMOSA hierarchy
 */
public class Objective extends Part
{
	public Objective()
	{
		super();
	}
	
	public Objective(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	public void addChild(Strategy curr)
	{
		this.children.add(curr);
	}
}
