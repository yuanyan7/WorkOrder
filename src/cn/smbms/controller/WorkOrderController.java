package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.pojo.Project;
import cn.smbms.pojo.WorkOrder;
import cn.smbms.service.project.ProjectService;
import cn.smbms.service.workorder.WorkOrderService;

@Controller
@RequestMapping("/workOrder")
public class WorkOrderController {
	private Logger logger = Logger.getLogger(WorkOrderController.class);
	@Resource
	private ProjectService projectService;
	@Resource
	private WorkOrderService workOrderService;
	
	@RequestMapping(value="/add.html")
	public String addWork(HttpServletRequest request,Model model){
		int proId=Integer.parseInt(request.getParameter("proId"));
		model.addAttribute("proId", proId);
			return "add";
		}
	
	@RequestMapping(value="/work.html")
	public String getWorkorderList(HttpServletRequest request,Model model) throws Exception{
		
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		String executor=request.getParameter("executor");
		String description=request.getParameter("description");
		Integer orderLevel=Integer.parseInt(request.getParameter("orderLevel"));
		WorkOrder wo=new WorkOrder();
		wo.setProjectId(projectId);
		wo.setExecutor(executor);
		wo.setDescription(description);
		wo.setOrderLevel(orderLevel);
		workOrderService.add(wo);
		List<WorkOrder> workOrderList=workOrderService.getWorkOrderList();
		request.setAttribute("workOrderList", workOrderList);
		return "work";
	}

}
