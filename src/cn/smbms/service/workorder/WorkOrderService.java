package cn.smbms.service.workorder;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import cn.smbms.pojo.WorkOrder;

public interface WorkOrderService {
	/**
	 * 查询所有工单信息
	 * 
	 * */
	public List<WorkOrder> getWorkOrderList();
	/**
	 * 添加工单
	 * 
	 * */
	public boolean add(WorkOrder workOrder);

}
