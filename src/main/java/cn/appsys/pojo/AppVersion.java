package cn.appsys.pojo;

import java.util.Date;

public class AppVersion {
	private Integer id; // ����id
	private Integer appId; // appId����Դ�ڣ�app_info�������id��
	private String softwareName;
	public String getSoftwareName() {
		return softwareName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	private String publishName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	public double getVersionSize() {
		return versionSize;
	}
	public void setVersionSize(double versionSize) {
		this.versionSize = versionSize;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	public String getApkLocPath() {
		return apkLocPath;
	}
	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}
	public String getApkFileName() {
		return apkFileName;
	}
	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}
	private String versionNo; // �汾��
	private String versionInfo; // �汾����
	private Integer publishStatus; // ����״̬����Դ�ڣ�data_dictionary��1 ������ 2 �ѷ��� 3// Ԥ������
	private String downloadLink; // ��������
	private double versionSize; // �汾��С����λ��M��
	private Integer createdBy; // �����ߣ���Դ��dev_user��������Ϣ����û�id��
	private Date creationDate; // ����ʱ��
	private Integer modifyBy; // �����ߣ���Դ��dev_user��������Ϣ����û�id��
	private Date modifyDate; // ���¸���ʱ��
	private String apkLocPath; // apk�ļ��ķ������洢·��
	private String apkFileName; // �ϴ���apk�ļ�����                                                             


}
