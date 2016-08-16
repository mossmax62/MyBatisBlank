package cl.max.mybatis.config;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.max.mybatis.config.IBatisConfiguratorException;

public class IBatisConfigurator {
    private static Logger logger = LoggerFactory
            .getLogger( IBatisConfigurator.class );
//    private static IBatisConfigurator instance = null;
    
    private static final String DEFAULT_CONFIG = "mybatis-config.xml";
    
    private static SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    
    public IBatisConfigurator() {
        
    }
    
//    public static synchronized IBatisConfigurator getInstance() {
//        if ( instance == null )
//            instance = new IBatisConfigurator();
//        return instance;
//    }
    
    /**
     * Devuelve la instancia de la sesion de persistencia.
     * 
     * 
     * @param props
     *            , por defecto va el valor en nulo.
     * @param type
     *            , por defecto es nulo pero para implementaci�n del
     *            batch Update debe usarse el tipo ExecutorType.BATCH
     * @return SqlSession, objeto de la instancia de session de
     *         persistencia.
     * @throws IBatisConfiguratorException
     * @since 1.0
     */
    public synchronized SqlSession getSqlSession( final Properties props,
            ExecutorType type ) throws IBatisConfiguratorException {
        return getSqlSession( DEFAULT_CONFIG, props, type );
    }
    
    synchronized SqlSession getSqlSession( final String resourceName,
            final Properties props, ExecutorType type )
            throws IBatisConfiguratorException {
        try {
            if ( factory == null ) {
                final Reader reader = Resources
                        .getResourceAsReader( resourceName );
                logger.debug( "Using " + resourceName + " as reader (" + reader
                        + ")" );
                if ( reader == null ) {
                    throw new IBatisConfiguratorException(
                            "Can't open MyBatis config file. (" + resourceName
                                    + ")" );
                }
                final SqlSessionFactoryBuilder factoryBuild = new SqlSessionFactoryBuilder();
                IBatisConfigurator.factory = factoryBuild.build( reader, props );
            }
            sqlSession = type != null ? factory.openSession( type ) : factory
                    .openSession();
            return sqlSession;
        }
        catch ( IOException e ) {
            throw new IBatisConfiguratorException( e );
        }
        catch ( Exception e ) {
            throw new IBatisConfiguratorException( e );
        }
    }
    
    /**
     * Devuelve la instancia de la sesion de persistencia.
     * 
     * @return SqlSession, objeto de la instancia de session de
     *         persistencia.
     * @throws IBatisConfiguratorException
     * @since 1.0
     */
    public SqlSession getSqlSession() throws IBatisConfiguratorException {
        if ( sqlSession != null ) {
            return sqlSession;
        }
        return null;
        
    }
}
