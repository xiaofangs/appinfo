package cn.appsys.pojo;

public class AdPromotion {
	private Integer id; // ����id
	private Integer appId; // appId����Դ�ڣ�app_info�������id��
	private String adPicPath; // ���ͼƬ�洢·��
	private Integer adPV; // �������
	private Integer carouselPosition; // �ֲ�λ��1-n��
	private String startTime; // ��Чʱ��
	private String endTime; // ʧЧʱ��
	private Integer createdBy; // �����ߣ���Դ��backend_user�û�����û�id��
	private String creationDate; // ����ʱ��
	private Integer modifyBy; // �����ߣ���Դ��backend_user�û�����û�id��
	private String modifyDate; // ���¸���ʱ��
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
	public String getAdPicPath() {
		return adPicPath;
	}
	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}
	public Integer getAdPV() {
		return adPV;
	}
	public void setAdPV(Integer adPV) {
		this.adPV = adPV;
	}
	public Integer getCarouselPosition() {
		return carouselPosition;
	}
	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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

}
