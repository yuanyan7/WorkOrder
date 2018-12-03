package cn.smbms.dao.project;

import java.sql.Connection;
import java.util.List;

import cn.smbms.pojo.Project;

public interface ProjectDao {
	/**
	 * 查询所有项目信息
	 * 
	 * */
	public List<Project> getProjectList(Connection connection)throws Exception;
	

}
