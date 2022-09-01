package mybookshop.dao;

import java.util.List;

import mybookshop.model.OrderBook;
import mybookshop.model.OrderBookCustom;
import mybookshop.model.Orders;
/**
 * 订单操接口类
 */
public interface OrderDao {
	/**
	 * 添加订单
	 */
	public int addOrder(Orders order);
	/**
	 * 添加详细订单
	 */
	public boolean addOrderBook(OrderBook orderBook);
	
	/**
	 * 根据当前登录用户Id获取对应的订单
	 */
	public List<OrderBookCustom> getOrder(int userId);
	List<OrderBookCustom> getOrder();
	boolean delOrderByUserId(int userId);
	boolean comeOrderByUserId(int userId);
	
}
