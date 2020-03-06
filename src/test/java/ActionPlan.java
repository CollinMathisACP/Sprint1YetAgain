
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents an ActionPlan, a concrete implementation of a Part.
 * The only difference is that addChild displays a warning that you
 * are violating the VMOSA hierarchy
 */
public class ActionPlan extends Part
{
	public ActionPlan()
	{
		super();
	}
	
	public ActionPlan(String name, String description, Part parent)
	{
		super(name,description,parent);
	}
	
	@Override
	public void addChild(Part p)
	{
			System.out.println("You are breaking the buisness plan format");
			return;
	}
}
