import java.util.ArrayList;

/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a VMOSA, a concrete implementation of a BusinessPlan.
 * The only difference is that addChild only accepts a Vision, in order to preserve the VMOSA hierarchy
 */
public class VMOSA extends BusinessPlan
{
	public VMOSA()
	{
		super();
	}
	
	public VMOSA(String name, String description, String date)
	{
		super(name,description,date);
	}
	
	public void addChild(Vision curr)
	{
		this.planHeads.add(curr);
	}
	
}
