
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
	
	public void addChild(Part curr)
	{
		System.out.println("Warning: you are violating the VMOSA hierarchy!");
		this.children.add(curr);
	}
}
