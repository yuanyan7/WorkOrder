package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.pojo.Project;
import cn.smbms.service.project.ProjectService;


@Controller
@RequestMapping("/project")
public class ProjectController {
	private Logger logger = Logger.getLogger(ProjectController.class);
	@Resource
	private ProjectService projectService;
	
	@RequestMapping(value="/proj.html")
	public String login(Model model){
		logger.debug("ProjectController welcome SMBMS==================");
		List<Project> proList=null;
		proList=projectService.getProjectList();
		model.addAttribute("proList", proList);
		return "proj";
	}

}
