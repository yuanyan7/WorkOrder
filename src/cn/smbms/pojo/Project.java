package cn.smbms.pojo;

public class Project {
	private Integer id;
	private String projectName;
	
	public Project(Integer id, String projectName) {
		super();
		this.id = id;
		this.projectName = projectName;
	}
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
