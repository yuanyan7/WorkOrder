package cn.smbms.dao.workorder;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import cn.smbms.pojo.WorkOrder;

public interface WorkOrderDao {
	/**
	 * 查询所有工单信息
	 * 
	 * */
	public List<WorkOrder> getWorkOrderList(Connection connection)throws Exception;
	/**
	 * 添加工单
	 * 
	 * */
	public int add(Connection connection,WorkOrder workOrder)throws Exception;

}
