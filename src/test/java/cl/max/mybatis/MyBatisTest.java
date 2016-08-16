package cl.max.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.max.mybatis.config.IBatisConfigurator;
import cl.max.mybatis.config.IBatisConfiguratorException;
import cl.max.mybatis.services.ActorMapper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for MyBatisApp.
 */
public class MyBatisTest extends TestCase
{
	private static Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	private SqlSession session=null;
	private ActorMapper actorMapper=null;

	public void setUp() {
		try {
			session = new IBatisConfigurator().getSqlSession(null,null);
			actorMapper = session.getMapper(ActorMapper.class);
		} catch (IBatisConfiguratorException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testIBatisConfigurator(){
	//	session=null;
		assertNotNull(session);
	}
	public void testActorMapper() {
		//actorMapper=null; 
		assertNotNull(actorMapper);
	}
	public static void testMyBatisApp() {
		MyBatisApp.main(null);
	}
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( MyBatisTest.class );
	}
	

}
