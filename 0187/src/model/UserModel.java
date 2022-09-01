package model;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import utils.JDBCUtils;
import domain.User;


/**
 * �������ݵ�JavaBean
 * 
 * @author jt
 *
 */
public class UserModel {

	/**
	 * �����û���¼�ķ�����
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	private  boolean flag = false;
	public User login(User user) throws SQLException {
		// �������ݿ⣺ͨ��������û���������ȥ���ݿ��н��в�ѯ
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User existUser = queryRunner.query("select * from user where username =? and password =?",
				new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
		return existUser;
	}
	
//	@Test
//	//�������ӳɹ�
//	public void login() throws SQLException {
//		 �������ݿ⣺ͨ��������û���������ȥ���ݿ��н��в�ѯ
//		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
//		User existUser = queryRunner.query("select * from user where username = ? and password = ?",
//				new BeanHandler<User>(User.class),"�����","123456");
//		System.out.println(existUser);
	
	//ע���ʵ��
	public boolean register(User user) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int update = queryRunner.update("insert into user values(?,?,?,?,?,?,?,?)",null,user.getUsername(),
				user.getPassword(),user.getNickname(),user.getPhone(),user.getSex(),user.getAddress(),user.getLim());
		if (update>0) {
			flag = true;
		}
		return flag;
	}
	
	//�������� �����Ϣ
	public User ForgetPassword(User user) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String str = "%"+user.getUsername()+"%";
		String str1 =  "%"+user.getAddress()+"%";
		User user1 = queryRunner.query("SELECT * FROM USER WHERE username LIKE ? AND address LIKE ?",
					new BeanHandler<User>(User.class),str,str1);
		
		//������
		System.out.println(user1);
		
		return user1;
	}
	
	//�����Ϣͨ�� ���и���
	public boolean UpdatePassword(User user) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("update user set password=? where username=?",user.getPassword(),user.getUsername());
		if(i>0){
			flag = true;
		}
		return flag;
	}
	
	//��ѯ�����û�
	public List<User> QueryAllUser() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		   List<User> list = queryRunner.query("SELECT * FROM USER",new BeanListHandler<User>(User.class));
		return list;
	}
	
	//����������id��
	public Object[] UserId(String username) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] uid = queryRunner.query("select uid from user where username=?", new ArrayHandler(),username);
		return uid;
	}
	
	//��������������ϸ��Ϣ
	public User UserID(String username) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User user = queryRunner.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
		return user;
	}
	//�����û���Ϣ
	public Boolean UpdateInfo(User user) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int update = queryRunner.update("update user set nickname=?,password=?,phone=?,address=?,sex=? where uid=?",user.getNickname(),user.getPassword(),user.getPhone(),user.getAddress(),user.getSex(),user.getUid());
		if(update>0){
			flag = true;
		}
		return flag;
	}
}