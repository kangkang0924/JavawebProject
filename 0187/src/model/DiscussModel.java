package model;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.JDBCUtils;
import domain.Discuss;

/*
 * 处理评论数据的模型
 */
public class DiscussModel {
	
	private  boolean flag = false;
	
	//发布评论
	public boolean discussAdd(Discuss discuss) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("insert into discuss values(?,?,?,?,?)",null,discuss.getUid(),discuss.getComm(),discuss.getCommtime(),discuss.getIid());
		if(i>0){
			flag =  true;
		}
		 return flag;
	}
	
	//查看指定id的评论
	public List<Object[]> findDiscuss(int iid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> discuss = queryRunner.query("SELECT discuss.`uid`, comm ,commtime, user.`username`,iid FROM discuss,USER WHERE iid=? AND discuss.`uid`=user.`uid`", new ArrayListHandler(),iid);
		if (!(discuss == null)) {
			return discuss;
		}else{
			return null;
		}
	}
	
	//查询所有的评论信息
	public List<Object[]>  findAllDiscuss() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> allDiscuss = queryRunner.query("SELECT did,user.`username`,information.`itype`,information.`information`,comm,commtime FROM USER,information,discuss WHERE discuss.`uid`=user.`uid` AND information.`iid`=discuss.`iid`", new ArrayListHandler());
		if(!(allDiscuss == null)){
			return allDiscuss;
		}else{
			return null;
		}
	}
	
	//删除指定编号的评论信息
	public boolean DiscussDelete(int did) throws SQLException{
		QueryRunner qunQueryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int delete = qunQueryRunner.update("delete from discuss where did=?",did);
		if(delete>0){
			flag = true;
		}
		return flag;
	}
	
	//查看我发布的评论
	public List<Object[]>  MyDiscuss(int uid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> myDiscuss = queryRunner.query(" SELECT discuss.`did`,discuss.`comm`,discuss.`commtime`,information.`itype`,information.`information`,user.`username`FROM discuss,information,user WHERE discuss.`iid`=information.`iid` AND discuss.`uid`=? and information.`uid`=user.`uid`",new ArrayListHandler(),uid);
		if(!(myDiscuss == null)){
			return myDiscuss;
		}else{
			return null;
		}
	}
	
	//查看我发布的信息谁评论了
	public List<Object[]> DiscussMy(int uid)  throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> discussMy = queryRunner.query("SELECT discuss.`did`,discuss.`comm`,discuss.`commtime`,information.`itype`,information.`information`,user.`username` FROM discuss,information,USER WHERE information.`uid` = ? AND discuss.`iid`=information.`iid` AND user.`uid`=discuss.`uid`",new ArrayListHandler(),uid);
		if(!(discussMy == null)){
			return discussMy;
		}else{
			return null;
		}
	}
}
