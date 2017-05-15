/*
 * config.xml�� �о�鿩 � DBMS�� ����� �������� �����Ѵ�.
 * db�� ���� �۾��� ����ϴ� ��ü�� SqlSession ��ü�� ��ȯ���ִ� SqlSessionFactory�� ��������!
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
	
	//dao���� ���� SqlSession �� ��ȯ���ִ� �޼���
	public SqlSession getSession(){
		SqlSession session =null;
		session = factory.openSession();
		return session;
	}	
	//�� ����� ���� ��ȯ
	public void close(SqlSession session){
		session.close();
	}
	
}
