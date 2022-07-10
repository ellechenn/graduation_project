package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "keyanzhuanli_info")
public class KeyanzhuanliInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")	private String gonghao;	@Column(name = "xingming")	private String xingming;	@Column(name = "shijian")	private String shijian;	@Column(name = "zhuanlimingcheng")	private String zhuanlimingcheng;	@Column(name = "shifoupizhun")	private String shifoupizhun;	
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
    }	public String getShijian() {
        return shijian;
    }
    public void setShijian(String shijian) {
		this.shijian = shijian;
    }	public String getZhuanlimingcheng() {
        return zhuanlimingcheng;
    }
    public void setZhuanlimingcheng(String zhuanlimingcheng) {
		this.zhuanlimingcheng = zhuanlimingcheng;
    }	public String getShifoupizhun() {
        return shifoupizhun;
    }
    public void setShifoupizhun(String shifoupizhun) {
		this.shifoupizhun = shifoupizhun;
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