package cn.appsys.pojo;

import java.util.Date;

public class AppInfo {
	private Integer id;// 主键id
	private String softwareName;// 软件名称
	private String APKName;// APK名称（唯一）
	private String supportROM;// 支持ROM
	private String interfaceLanguage;// 界面语言
	private double softwareSize;// 软件大小（单位：M）
	private Date updateDate;// 更新日期
	private Integer devId;// 开发者id（来源于：dev_user表的开发者id）
	private String appInfo;// 应用简介
	private Integer status;// 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架// 5 已下架）
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
	private Date onSaleDate;// 上架时间
	private Date offSaleDate;// 下架时间
	private Integer flatformId;// 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
	private Integer categoryLevel3;// 所属三级分类（来源于：data_dictionary）
	private Integer downloads;// 下载量（单位：次）
	private Integer createdBy;// 创建者（来源于dev_user开发者信息表的用户id）
	private Date creationDate;//
	private Integer modifyBy;//
	private Date modifyDate;// 最新更新时间
	private Integer categoryLevel1;// 所属一级分类（来源于：data_dictionary）
	private Integer categoryLevel2;// 所属二级分类（来源于：data_dictionary）
	private String logoPicPath;// LOGO图片url路径
	private String logoLocPath;// LOGO图片的服务器存储路径
	private Integer versionId;// 最新的版本id

}
