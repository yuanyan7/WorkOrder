package cn.smbms.dao.project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao{
//查询所有项目
	@Override
	public List<Project> getProjectList(Connection connection) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;//结果集
		List<Project> proList = new ArrayList<Project>();
		if(connection != null){
			String sql = "select * from project";
			Object[] params = {};
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			while(rs.next()){
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setProjectName(rs.getString("projectName"));
				proList.add(pro);
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return proList;
	}
}
