package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiaoxuechengguojieshao_info")
public class JiaoxuechengguojieshaoInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")	private String gonghao;	@Column(name = "xingming")	private String xingming;	@Column(name = "riqi")	private String riqi;	@Column(name = "suohuodejiangxiang")	private String suohuodejiangxiang;	@Column(name = "jiangxiangneirong")	private String jiangxiangneirong;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//gextsexttpzidxuan

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getRiqi() {
        return riqi;
    }
    public void setRiqi(String riqi) {
		this.riqi = riqi;
    }	public String getSuohuodejiangxiang() {
        return suohuodejiangxiang;
    }
    public void setSuohuodejiangxiang(String suohuodejiangxiang) {
		this.suohuodejiangxiang = suohuodejiangxiang;
    }	public String getJiangxiangneirong() {
        return jiangxiangneirong;
    }
    public void setJiangxiangneirong(String jiangxiangneirong) {
		this.jiangxiangneirong = jiangxiangneirong;
    }	

	public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

}