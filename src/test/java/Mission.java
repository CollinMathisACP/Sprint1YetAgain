
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a Mission, a concrete implementation of a Part.
 * The only difference is that addChild only accepts a Objective, in order to preserve the VMOSA hierarchy
 */
public class Mission extends Part
{
	public Mission()
	{
		super();
	}
	
	public Mission(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	public void addChild(Objective p)
	{
		this.getChildren().add(p);
	}
}
