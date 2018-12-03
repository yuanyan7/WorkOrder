package cn.smbms.service.project;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.project.ProjectDao;
import cn.smbms.pojo.Project;


@Service("projectService")
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectDao projectDao;
	@Override
	public List<Project> getProjectList() {
		// TODO Auto-generated method stub
				Connection connection = null;
				List<Project> proList = null;
				try {
					connection = BaseDao.getConnection();
					proList = projectDao.getProjectList(connection);//查询所有项目信息
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					BaseDao.closeResource(connection, null, null);
				}
				return proList;
	}
	

}
