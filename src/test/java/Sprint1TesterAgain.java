import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Sprint1TesterAgain
{
	//Simple test to ensure the default constructor, Eclipse-generated getters/setters work
	@Test
	void testConstructor()
	{
		Part a = new Part();
		a.setName("Test");
		assertEquals(a.getName(), "Test");
	}
	
	@Test
	void testToString()
	{
		Vision vision1 = new Vision("TestTwo - Vision1","TestTwo - Vision1 - Fake description", null);
		System.out.println(vision1);
	}
	
	//Instantiates a realistic example of a VMOSA class, saves it to the disk, decodes it, and resaves it to
	//ensure that the XML functions work
	@Test
	void testVMOSA()
	{
		//(String name, String description, String date)
		VMOSA test = new VMOSA("TestTwo","In order to test","3/02/2020");
		Vision vision1 = new Vision("TestTwo - Vision1","TestTwo - Vision1 - Fake description", null);
			Mission mission1 = new Mission("TestTwo - Mission","TestTwo - V1Mission1 - Fake description", vision1);
				Objective objective1 = new Objective("TestTwo - Objective","TestTwo - M1-Objective1 - Fake description", mission1);
				mission1.addChild(objective1);
			vision1.addChild(mission1);
		test.addChild(vision1);
		
		Vision Vision2 = new Vision("TestTwo - Vision2","TestTwo - Vision2 - Fake description", null);	
		test.addChild(Vision2);
		
		Vision Vision3 = new Vision("TestTwo - Vision3","TestTwo - Vision3 - Fake description", null);
		test.addChild(Vision3);
		
		test.savePlan("testVMOSAOut.xml");
				
		VMOSA testthree = (VMOSA) BusinessPlan.openPlan("testVMOSAOut.xml");
		
		testthree.savePlan("testVMOSAIn.xml");	
	}
	
	@Test
	void testCentre()
	{	
		Centreplan test = new Centreplan("Four", "Desc", "3 March 2020", "Institutional statement", 
				"program statement", false);
		Goal goalOne = new Goal("GoalOne", "Desc1", null);
			SLO SLOone = new SLO("SLO one", "SLOdescOne", goalOne, "Target", "Rubric", true);
		goalOne.addChild(SLOone);
		Goal goalTwo = new Goal("GoalTwo", "Desc2", null);
		
		test.addChild(goalOne);
		test.addChild(goalTwo);
		
		test.savePlan("testFourIn.xml");
		
		Centreplan testFourIn = (Centreplan) BusinessPlan.openPlan("testFourIn.xml");
		
		testFourIn.savePlan("testFourOut.xml");
	}

}
