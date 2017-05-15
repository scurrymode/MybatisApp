<%@page import="app.emp.Emp"%>
<%@page import="app.emp.EmpDAO"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%! EmpDAO empDAO = new EmpDAO(); %>
<%

//List list = ss.selectList("selectAll");
/*
	String resource = "mybatis/config/config.xml";
	InputStream inputStream = null;
	
	try {
		inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
		e.printStackTrace();
	}
	//jdbc 상투적 코드에서는 쿼리문을 수행하기 위해 PreparedStatement객체를 생성해야 했지만 mybatis를 이용하면 SqlSession만 이용하면 된다.
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
	SqlSession ss = factory.openSession();
	//쿼리문이 존재하는 mapper xml의 아이디를 조회하여 쿼리문 수행!!
	
*/

	Emp emp = empDAO.select(7369);
	out.print("사원의 이름은? "+emp.getEname());
//	List list=empDAO.select();
//	out.print("총 사원수는? "+list.size());

%>