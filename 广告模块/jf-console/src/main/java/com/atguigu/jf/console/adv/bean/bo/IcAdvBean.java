package com.atguigu.jf.console.adv.bean.bo;

import java.util.Date;

public class IcAdvBean {
	 private Long advId;

	    private Short advPos;

	    private String advName;

	    private String advPic;

	    private String advUrl;

	    private String advDesc;

	    private Long advOrder;

	    private Date advStartTime;

	    private Date advEndTime;

	    private Long advAreaId;

	    private Short advState;

	    private Short dataState;
	    
	    private String areaName;
	    
	    

	    public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}

		public Long getAdvId() {
	        return advId;
	    }

	    public void setAdvId(Long advId) {
	        this.advId = advId;
	    }

	    public Short getAdvPos() {
	        return advPos;
	    }

	    public void setAdvPos(Short advPos) {
	        this.advPos = advPos;
	    }

	    public String getAdvName() {
	        return advName;
	    }

	    public void setAdvName(String advName) {
	        this.advName = advName == null ? null : advName.trim();
	    }

	    public String getAdvPic() {
	        return advPic;
	    }

	    public void setAdvPic(String advPic) {
	        this.advPic = advPic == null ? null : advPic.trim();
	    }

	    public String getAdvUrl() {
	        return advUrl;
	    }

	    public void setAdvUrl(String advUrl) {
	        this.advUrl = advUrl == null ? null : advUrl.trim();
	    }

	    public String getAdvDesc() {
	        return advDesc;
	    }

	    public void setAdvDesc(String advDesc) {
	        this.advDesc = advDesc == null ? null : advDesc.trim();
	    }

	    public Long getAdvOrder() {
	        return advOrder;
	    }

	    public void setAdvOrder(Long advOrder) {
	        this.advOrder = advOrder;
	    }

	    public Date getAdvStartTime() {
	        return advStartTime;
	    }

	    public void setAdvStartTime(Date advStartTime) {
	        this.advStartTime = advStartTime;
	    }

	    public Date getAdvEndTime() {
	        return advEndTime;
	    }

	    public void setAdvEndTime(Date advEndTime) {
	        this.advEndTime = advEndTime;
	    }

	    public Long getAdvAreaId() {
	        return advAreaId;
	    }

	    public void setAdvAreaId(Long advAreaId) {
	        this.advAreaId = advAreaId;
	    }

	    public Short getAdvState() {
	        return advState;
	    }

	    public void setAdvState(Short advState) {
	        this.advState = advState;
	    }

	    public Short getDataState() {
	        return dataState;
	    }

	    public void setDataState(Short dataState) {
	        this.dataState = dataState;
	    }

}
