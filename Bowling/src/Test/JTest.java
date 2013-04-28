package Test;
import Model.Input_handler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JTest {
	ModelControllerTest ModelValid;
	ModelControllerTest ModelInvalid;
	Input_handler checker;
	LogClass logger ;
	
	@Before
	public void setup() {
		ModelValid = new ModelControllerTest();
		ModelValid.InitController("./ValidTest.txt");
		ModelInvalid= new ModelControllerTest();
		ModelInvalid.InitController("./InvalidTest.txt");		
		checker = new Input_handler();
		logger = new LogClass();
		
		
		
	}
	
	@Test			
	public void test() {
		
		logger.Log(" Is " + ModelValid.getFilePath() + " a Valid File ? : " +( checker.check_lists_sizes(ModelValid.getPlayer(0), ModelValid.getPlayer(1)) ) );
		logger.Log("Is " +  ModelInvalid.getFilePath() + " an Valid File ? : " + ( checker.check_lists_sizes(ModelInvalid.getPlayer(0), ModelInvalid.getPlayer(1)) ) );
		
		assertTrue( checker.check_lists_sizes(ModelValid.getPlayer(0), ModelValid.getPlayer(1) ) );
		assertTrue( checker.check_lists_values(ModelValid.getPlayer(0), ModelValid.getPlayer(1) ) );
		assertFalse( checker.check_lists_sizes(ModelInvalid.getPlayer(0), ModelInvalid.getPlayer(1)) );
		assertFalse( checker.check_lists_values(ModelInvalid.getPlayer(0), ModelInvalid.getPlayer(1)) );
	}

}
