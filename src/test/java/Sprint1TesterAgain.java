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
	void testPartToString()
	{
		Vision vision1 = new Vision("Vision1","V1 ToString test", null);
		System.out.println(vision1 + "\n");
		
		Mission mission1 = new Mission("Mission1","M1 ToString test", vision1);
		vision1.addChild(mission1);
		mission1.setParent(mission1);
		
		System.out.println(vision1 + "\n");
		System.out.println(mission1 + "\n");
	}
	
	@Test
	void testFindNode()
	{
		VMOSA test = new VMOSA("TestTwo","In order to test","3/02/2020");
		Vision target = new Vision("Target","TestTwo - Vision1 - Fake description", null);
			Mission mission1 = new Mission("TestTwo - Mission","TestTwo - V1Mission1 - Fake description", target);
				Objective target2 = new Objective("Target2","TestTwo - M1-Objective1 - Fake description", mission1);
				mission1.addChild(target2);
			target.addChild(mission1);
		test.addChild(target);
		
		assertEquals(test.getChildByName("Target"), target);
		assertEquals(test.getChildByName("Target2"), target2);		
		assertEquals(test.getChildByName("Should not exist"), null);
	}
	
	@Test
	void testRemoveNode()
	{
		VMOSA test = new VMOSA("TestTwo","In order to test","3/02/2020");
		Vision target = new Vision("Target","TestTwo - Vision1 - Fake description", null);
			Mission mission1 = new Mission("TestTwo - Mission","TestTwo - V1Mission1 - Fake description", target);
				Objective target2 = new Objective("Target2","TestTwo - M1-Objective1 - Fake description", mission1);
				mission1.addChild(target2);
			target.addChild(mission1);
		test.addChild(target);
		
		assertEquals(target2, test.removeChildByName(target2.getName()));
		assertEquals(target, test.removeChildByName(target.getName()));
	}
	
	@Test
	void testBusinessPlanToString()
	{
		VMOSA test = new VMOSA("A1","A1Desc","A1Date");
		Vision vision1 = new Vision("B1","B1 Desc", null);
			Mission mission1 = new Mission("C1","C1 Desc", vision1);
				Objective objective1 = new Objective("D1","D1 Desc", mission1);
				mission1.addChild(objective1);
			vision1.addChild(mission1);
		test.addChild(vision1);
		
		System.out.println("------BP------\n" + test);
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
		
		assertEquals(test.toString(), testFourIn.toString());
	}

}
