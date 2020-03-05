import java.util.ArrayList;

/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a Vision, a concrete implementation of a Part.
 * The only difference is that addChild only accepts a Mission, in order to preserve the VMOSA hierarchy
 */
public class Vision extends Part
{
	public Vision()
	{
		super();
	}
	
	public Vision(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	public void addChild(Mission curr)
	{
		this.children.add(curr);
	}
}
