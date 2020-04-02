import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Actions.*;
import Calculation.StandardQuoteCalculationTest;
import Quotation.*;
import Users.*;

@RunWith(Suite.class)
@SuiteClasses({ 
	AcceptActionTest.class,
	ActionFactoryTest.class,
	ClimbActionTest.class,
	RejectActionTest.class,
	SubmitActionTest.class,
	ApplicantStateTest.class,
	ManagerStateTest.class,
	PolicyStateTest.class,
	SupervisorStateTest.class,
	BrokerTest.class,
	ManagerTest.class,
	SupervisorTest.class,
	QuoteTest.class,
	StandardQuoteCalculationTest.class
})

public class AllTests {
	

}
