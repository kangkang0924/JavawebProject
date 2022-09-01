package mybookshop.dao;

import java.util.List;

import mybookshop.model.Categories;

public interface CategoriesDao {
	//获取分类
	public List<Categories> getCategories();
	//添加分类
	public boolean addCategory(Categories c);
	//更新分类
	public boolean updateCategory(Categories c);
}
