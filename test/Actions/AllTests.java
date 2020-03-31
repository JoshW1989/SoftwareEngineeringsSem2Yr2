package Actions;
import Quotation.*;
import Users.*;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ActionTestCases.class,
	ApplicantStateTest.class, ManagerStateTest.class, SupervisorStateTest.class,
	BrokerTest.class, ManagerTest.class, SupervisorTest.class, PolicyStateTest.class})
public class AllTests {

}
