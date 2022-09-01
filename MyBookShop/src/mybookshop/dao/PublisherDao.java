package mybookshop.dao;

import java.util.List;

import mybookshop.model.Publishers;


public interface PublisherDao {
	//获取出版社
	public List<Publishers> getPublisher();
	//添加出版社
	public boolean addPublisher(Publishers p);
	//更新出版社
	public boolean upPublisher(Publishers p);
}
