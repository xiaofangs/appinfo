package cn.appsys.pojo;

import java.util.List;

public class AppCategory {
	private Integer id;// ����ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	private String categoryCode;// �������
	private String categoryName;// ��������
	private Integer parentId;// �����ڵ�id
	private Integer createdBy;// �����ߣ���Դ��backend_user�û�����û�id��
	private String creationTime;// ����ʱ��
	private Integer modifyBy;// �����ߣ���Դ��backend_user�û�����û�id��
	private String modifyDate;//     select,insert,update,references  ���¸���ʱ��                                        


}
