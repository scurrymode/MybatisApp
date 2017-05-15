/*
 * config.xml을 읽어들여 어떤 DBMS를 사용할 것인지를 결정한다.
 * db와 실제 작업을 담당하는 객체인 SqlSession 객체를 반환해주는 SqlSessionFactory를 생성하자!
 * */

package mybatis.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigManager {
	private static ConfigManager instance;
	SqlSessionFactory factory;
	
	private ConfigManager(){
		String resource = "mybatis/config/config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 factory= new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static ConfigManager getInstance() {
		if(instance==null){
			instance=new ConfigManager();
		}
		return instance;
	}
	
	//dao들을 위해 SqlSession 을 반환해주는 메서드
	public SqlSession getSession(){
		SqlSession session =null;
		session = factory.openSession();
		return session;
	}	
	//다 사용한 세션 반환
	public void close(SqlSession session){
		session.close();
	}
	
}
