package cl.max.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import cl.max.mybatis.config.IBatisConfigurator;
import cl.max.mybatis.config.IBatisConfiguratorException;
import cl.max.mybatis.domain.Actor;
import cl.max.mybatis.services.ActorMapper;

/**
 *  MyBatisApp template blank application
 *  Autor: Maximiliano Mussuto
 *
 */
public class MyBatisApp 
{	
	private static Logger logger = LoggerFactory.getLogger(MyBatisApp.class);

	public static void main( String[] args )
	{
		try {

			SqlSession sqlSession = new IBatisConfigurator().getSqlSession(null,null);
			ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
			List<Actor> list = mapper.list();
			String json =  new Gson().toJson(list);
			
			
			
			if(!logger.isInfoEnabled()){
				logger.info("Working");
				logger.info(json);
			}else{
				System.out.println(json);
				System.out.println("NotOK");
			}
				
    		/*for(Actor a: list){
    			logger.debug(a.toString());
    		}*/
				
			
			
			
			
			
			

			//System.out.println(json);

		} catch (IBatisConfiguratorException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
