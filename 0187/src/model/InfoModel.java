package model;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JDBCUtils;
import domain.*;

public class InfoModel {
	
	private  boolean flag = false;
	
	//��Ϣ�������
	public  boolean infoTypeAdd(InfoType infoType) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("insert into infotype values(?,?)",null,infoType.getInfo_typename());
		if(i>0){
			flag = true; System.out.println("��Ϣ������ӳɹ�");
		}
		return flag;
	}
	
	//��ѯ������Ϣ����
	public List<InfoType> infoTypeAll() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<InfoType> list = queryRunner.query("select * from infotype", new BeanListHandler<InfoType>(InfoType.class));
		return list;
	}
	
	//ɾ��ָ����ŵ���Ϣ����
	public Boolean infoTypeDelete(int typeid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("delete from infotype where info_typeid=?",typeid);
		if(i>0){
			flag = true;
		}
		return flag;
	}
	//��ѯ�������Ϣ
	public List<Object[]> informationAll( ) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> infoAll = queryRunner.query("SELECT iid,itype,information,username,information.`phone`,pubtime,detail FROM information ,USER WHERE information.`uid`=user.`uid`"
				,new ArrayListHandler());
//		for(Object[] objects : infoAll){
//			System.out.println(Arrays.toString(objects));
//		}
		return infoAll;
	}
	
	//ɾ��ָ����ŵ���Ϣ
	public boolean informationDelete(int iid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("delete from information where iid =?",iid);
		if(i>0){
			//ɾ���ɹ�
			flag = true;
		}
		return flag;
	}
	
	//�鿴��Ϣ����
	public Object[] informationDetail(int iid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] detail = queryRunner.query("select detail from information where iid=?", new ArrayHandler(),iid );
		return detail;
	}
	
	//������Ϣ
	public boolean InfoAdd(Information info) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int i = queryRunner.update("insert into information values(?,?,?,?,?,?,?)",null,info.getItype(),info.getInformation(),info.getDetail(),info.getUid(),info.getPhone(),info.getPubtime());
		if(i>0){
			flag = true;
		}
		return flag;
	}
	
	//��ѯ�Լ���������Ϣ
	public List<Object[]> MyPubInfo(int uid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> myPubInfo = queryRunner.query("select * from information where uid =?", new ArrayListHandler(),uid);
		if(!(myPubInfo == null)){
			return myPubInfo;
		}else {
			return null;
		}
	}
	
	//��ѯָ�����͵���Ϣ
	public List<Object[]> InfoFindByType(String itype) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Object[]> infoFindByType = queryRunner.query("SELECT * FROM information,USER WHERE itype= ? AND information.`uid`=user.`uid`", new ArrayListHandler(),itype);
		if(!(infoFindByType == null)){
			return infoFindByType;
		}else{
			return null;
		}
	}
}
