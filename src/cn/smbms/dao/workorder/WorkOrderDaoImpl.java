package cn.smbms.dao.workorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.WorkOrder;
@Repository
public class WorkOrderDaoImpl implements WorkOrderDao{
//查询所有工单信息
	@Override
	public List<WorkOrder> getWorkOrderList(Connection connection) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;//结果集
		List<WorkOrder> worklist = new ArrayList<WorkOrder>();
		if(connection != null){
			String sql = "SELECT w.id,p.projectName,w.executor,w.description,w.orderLevel,w.createDate FROM project AS p INNER JOIN workorder AS w ON p.`id`=w.`projectId` ORDER BY createDate DESC;";
			Object[] params = {};
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			while(rs.next()){
				WorkOrder wro = new WorkOrder();
				wro.setId(rs.getInt("id"));
				wro.setProjectName(rs.getString("projectName"));
				wro.setExecutor(rs.getString("executor"));
				wro.setDescription(rs.getString("description"));
				wro.setOrderLevel(rs.getInt("orderLevel"));
				wro.setCreateDate(rs.getDate("createDate"));
				worklist.add(wro);
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return worklist;
	}
//添加工单
	@Override
	public int add(Connection connection, WorkOrder workOrder) throws Exception {
		PreparedStatement pstm = null;
		int updateRows = 0;
		if(null != connection){
			String sql = "insert into workorder (projectId,executor,description,orderLevel,createDate) " +
					"values(?,?,?,?,?)";
			Object[] params = {workOrder.getProjectId(),workOrder.getExecutor(),
					workOrder.getDescription(),workOrder.getOrderLevel(),workOrder.getCreateDate()};
					
			updateRows = BaseDao.execute(connection, pstm, sql, params);
			BaseDao.closeResource(null, pstm, null);
		}
		return updateRows;
	}
	
}
