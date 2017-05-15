package app.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.ConfigManager;

public class EmpDAO {
	ConfigManager manager = ConfigManager.getInstance();
	
	//jdbc 상투적 코드..
	public List select(){
		List list = null;
		SqlSession session = manager.getSession();
		list = session.selectList("Emp.selectAll");
		manager.close(session);
		return list;
	}
	
	public Emp select(int ka){
		Emp emp;
		SqlSession session = manager.getSession();
		emp = session.selectOne("select", ka);
		manager.close(session);
		return emp;
	}
}
