
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a Goal, a concrete implementation of a Part.
 * The only difference is that addChild only accepts an SLO, in order to preserve the Centre Plan hierarchy
 */
public class Goal extends Part
{

	public Goal()
	{
		super();
	}
	
	public Goal(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	public void addChild(SLO curr)
	{
		this.children.add(curr);
	}
	
}
