package cn.smbms.pojo;

import java.util.Date;

public class WorkOrder {
	private Integer id;
	private Integer projectId;
	private String executor;
	private String description;
	private Integer orderLevel;
	private Date createDate;
	private String projectName;
	
	

	public WorkOrder(Integer id, Integer projectId, String executor, String description, Integer orderLevel,
			Date createDate, String projectName) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.executor = executor;
		this.description = description;
		this.orderLevel = orderLevel;
		this.createDate = createDate;
		this.projectName = projectName;
	}

	
	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public WorkOrder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrderLevel() {
		return orderLevel;
	}
	public void setOrderLevel(Integer orderLevel) {
		this.orderLevel = orderLevel;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
