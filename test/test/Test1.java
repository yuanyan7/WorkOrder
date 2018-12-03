package test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Project;
import cn.smbms.pojo.WorkOrder;
import cn.smbms.service.project.ProjectService;
import cn.smbms.service.workorder.WorkOrderService;

public class Test1 {
	private static Logger logger = Logger.getLogger(Test1.class);
	
	@Test
	public void testGetProjectList() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		ProjectService project1= (ProjectService) ctx.getBean("projectService");//对应@Service("projectService")
		logger.info("testGetProjectList");
		Connection connection = null;
		List<Project> proList = null;
	
		try {
			connection = BaseDao.getConnection();
			proList = project1.getProjectList();
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		for (Project projects : proList) {
			System.out.println(projects.getProjectName());
		}
	}
	@Test
	public void testGetWolist(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		WorkOrderService workService = (WorkOrderService) ctx.getBean("workOrderService");
		logger.info("testGetWolist");
		Connection conn=null;
		List<WorkOrder> woList=null;
	
		conn=BaseDao.getConnection();
		try {
			woList=workService.getWorkOrderList();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(conn, null, null);
		}
		for (WorkOrder workOrder : woList) {
				logger.debug("aaaaaaaaaaaaa");
				System.out.println(workOrder.getProjectId()+workOrder.getExecutor()+workOrder.getDescription()+workOrder.getOrderLevel()+workOrder.getCreateDate());
				
			}
		
		
	}
	@Test
	public void testAddWolist(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		WorkOrderService workService=  (WorkOrderService) ctx.getBean("workOrderService");
		//logger.info("testGetWolist");
		logger.debug("testGetWolist");
		Connection conn=null;
		boolean woList=false;
		WorkOrder wo=new WorkOrder();
		wo.setProjectId(1);
		wo.setExecutor("老王");
		wo.setDescription("qqqqq");
		wo.setOrderLevel(2);
		wo.setCreateDate(new Date());
		conn=BaseDao.getConnection();
		try {
			woList=workService.add(wo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(conn, null, null);
		}
		System.out.println(woList);
	}
}
