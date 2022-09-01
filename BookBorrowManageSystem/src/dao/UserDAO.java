package dao;

import model.Users;

public interface UserDAO {
	//登录：功能：判断，用户名和密码在数据库中是否存在
	//方法名：findLongin
	//参数：有参数，用户名，密码；
	//返回值：布尔 true false
	public boolean findLogin(Users user) throws Exception;
		
		
}
