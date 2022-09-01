package model;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Exam;
import domain.User;
import utils.JDBCUtils;

public class ExamModel {

	//查询所有学生成绩信息的方法
	private  boolean flag = false;
	public User login(User user) throws SQLException {
		// 连接数据库：通过传入的用户名和密码去数据库中进行查询
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User existUser = queryRunner.query("select * from user where username =? and password =?",
				new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
		return existUser;
	}
	
	
	
	public List<Exam> QueryAllNum() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Exam> list = queryRunner.query("select * from exam", new BeanListHandler<Exam>(Exam.class));
		return list;
		
	}

}
