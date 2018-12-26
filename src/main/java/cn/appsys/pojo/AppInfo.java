package cn.appsys.pojo;

import java.util.Date;

public class AppInfo {
	private Integer id;// ����id
	private String softwareName;// �������
	private String APKName;// APK���ƣ�Ψһ��
	private String supportROM;// ֧��ROM
	private String interfaceLanguage;// ��������
	private double softwareSize;// �����С����λ��M��
	private Date updateDate;// ��������
	private Integer devId;// ������id����Դ�ڣ�dev_user��Ŀ�����id��
	private String appInfo;// Ӧ�ü��
	private Integer status;// ״̬����Դ�ڣ�data_dictionary��1 ����� 2 ���ͨ�� 3 ��˲�ͨ�� 4 ���ϼ�// 5 ���¼ܣ�
	private String flatformName;
	private String category1Name;
	private String category2Name;
	public String getFlatformName() {
		return flatformName;
	}
	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}
	public String getCategory1Name() {
		return category1Name;
	}
	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}
	public String getCategory2Name() {
		return category2Name;
	}
	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}
	public String getCategory3Name() {
		return category3Name;
	}
	public void setCategory3Name(String category3Name) {
		this.category3Name = category3Name;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	private String category3Name;
	private String statusName;
	private String versionNo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(double softwareSize) {
		this.softwareSize = softwareSize;
	}
	
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(Integer flatformId) {
		this.flatformId = flatformId;
	}
	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
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
	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	private Date onSaleDate;// �ϼ�ʱ��
	private Date offSaleDate;// �¼�ʱ��
	private Integer flatformId;// ����ƽ̨����Դ�ڣ�data_dictionary��1 �ֻ� 2 ƽ�� 3 ͨ�ã�
	private Integer categoryLevel3;// �����������ࣨ��Դ�ڣ�data_dictionary��
	private Integer downloads;// ����������λ���Σ�
	private Integer createdBy;// �����ߣ���Դ��dev_user��������Ϣ����û�id��
	private Date creationDate;//
	private Integer modifyBy;//
	private Date modifyDate;// ���¸���ʱ��
	private Integer categoryLevel1;// ����һ�����ࣨ��Դ�ڣ�data_dictionary��
	private Integer categoryLevel2;// �����������ࣨ��Դ�ڣ�data_dictionary��
	private String logoPicPath;// LOGOͼƬurl·��
	private String logoLocPath;// LOGOͼƬ�ķ������洢·��
	private Integer versionId;// ���µİ汾id

}
