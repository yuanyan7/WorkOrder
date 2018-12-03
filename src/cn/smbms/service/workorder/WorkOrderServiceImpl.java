package cn.smbms.service.workorder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.BaseDao;

import cn.smbms.dao.workorder.WorkOrderDao;

import cn.smbms.pojo.WorkOrder;
@Service("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService{
	@Resource
	private WorkOrderDao workOrderDao;
	
		
	@Override
	public List<WorkOrder> getWorkOrderList() {
		Connection connection = null;
		List<WorkOrder> workOrderList = null;
		try {
			connection = BaseDao.getConnection();
			workOrderList = workOrderDao.getWorkOrderList(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return workOrderList;
	}

		@Override
		public boolean add(WorkOrder workOrder) {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connection connection = null;
			try {
				connection = BaseDao.getConnection();
				connection.setAutoCommit(false);//开启JDBC事务管理.//先将事务设为手动提交
				int updateRows = workOrderDao.add(connection, workOrder);
				connection.commit();//提交事务
				if(updateRows > 0){
					flag = true;
					System.out.println("add success--添加成功!");
				}else{
					System.out.println("add failed--添加失败!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					System.out.println("rollback==================");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally{
				//在service层进行connection连接的关闭
				BaseDao.closeResource(connection, null, null);
			}
			return flag;
	}

}
