
/**
 * 
 * @author Malachi Beerram, Collin Mathis
 * This class represents a Centre Plan, a concrete implementation of a BusinessPlan.
 * Differences include three additional attributes that are unique to this plan.
 */
public class Centreplan extends BusinessPlan
{
	
	protected String institutionalMissionStatement;
	protected String programMissionStatement;
	protected boolean revised; 
	
	public Centreplan()
	{
		super();
		this.programMissionStatement = "";
		this.revised = false;
		
		//This statement is the same for all plans at Centre College
		this.institutionalMissionStatement = "Centre College’s "
				+ "mission is to prepare students for lives of learning, leadership, and service.";
	}
	
	public Centreplan(String name, String description, String date
			,String institutionalMissionStatement,String programMissionStatement,boolean revised)
	{
		super(name,description,date);
		this.programMissionStatement = programMissionStatement;
		this.revised = revised;
		this.institutionalMissionStatement = institutionalMissionStatement;
	}
	
	public void addChild(Goal curr)
	{
		this.planHeads.add(curr);
	}
	
	public String getInstitutionalMissionStatement()
	{
		return institutionalMissionStatement;
	}

	public void setInstitutionalMissionStatement(String institutionalMissionStatement)
	{
		this.institutionalMissionStatement = institutionalMissionStatement;
	}

	public String getProgramMissionStatement()
	{
		return programMissionStatement;
	}

	public void setProgramMissionStatement(String programMissionStatement)
	{
		this.programMissionStatement = programMissionStatement;
	}

	public boolean isRevised()
	{
		return revised;
	}

	public void setRevised(boolean revised)
	{
		this.revised = revised;
	}
	
}
