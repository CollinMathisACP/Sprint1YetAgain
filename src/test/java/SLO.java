/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents an SLO, a concrete implementation of a Part.
 * The only difference is that addChild displays a warning that you
 * are violating the Centre Plan hierarchy
 * */
public class SLO extends Part
{	
		protected String target; 
		protected String rubicName;
		protected boolean targetAchieved;
		
		public SLO()
		{
			super();
			this.target = ""; 
			this.rubicName = "";
			this.targetAchieved = false;
		}
		
		public SLO(String name, String description, Part parent, 
				String target,String rubicName, boolean targetAchieved)
		{
			super(name,description,parent);
			this.target = target; 
			this.rubicName = rubicName;
			this.targetAchieved = targetAchieved;
		}
		
		public void addChild(Part curr)
		{
			System.out.println("Warning: you are violating the CentrePlan hierarchy!");
			this.children.add(curr);
		}
		
		public String getTarget()
		{
			return target;
		}

		public void setTarget(String target)
		{
			this.target = target;
		}

		public String getRubicName()
		{
			return rubicName;
		}

		public void setRubicName(String rubicName)
		{
			this.rubicName = rubicName;
		}

		public boolean isTargetAchieved()
		{
			return targetAchieved;
		}

		public void setTargetAchieved(boolean targetAchieved)
		{
			this.targetAchieved = targetAchieved;
		}

	

}
