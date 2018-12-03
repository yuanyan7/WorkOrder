package cn.smbms.service.project;

import java.util.List;

import cn.smbms.pojo.Project;

public interface ProjectService {
	/**
	 * 查询所有项目信息
	 * 
	 * */
	public List<Project> getProjectList();

}
