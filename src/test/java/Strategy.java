
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a Strategy, a concrete implementation of a Part.
 * The only difference is that addChild only accepts an ActionPlan, in order to preserve the VMOSA hierarchy
 */
public class Strategy extends Part
{
	public Strategy()
	{
		super();
	}
	
	public Strategy(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	public void addChild(ActionPlan p)
	{
		this.getChildren().add(p);
	}
}
