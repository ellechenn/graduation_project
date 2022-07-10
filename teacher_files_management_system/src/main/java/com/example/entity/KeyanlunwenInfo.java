package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "keyanlunwen_info")
public class KeyanlunwenInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")	private String gonghao;	@Column(name = "xingming")	private String xingming;	@Column(name = "shijian")	private String shijian;	@Column(name = "lunwenmingcheng")	private String lunwenmingcheng;	@Column(name = "shifoufabiao")	private String shifoufabiao;	
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
    }	public String getLunwenmingcheng() {
        return lunwenmingcheng;
    }
    public void setLunwenmingcheng(String lunwenmingcheng) {
		this.lunwenmingcheng = lunwenmingcheng;
    }	public String getShifoufabiao() {
        return shifoufabiao;
    }
    public void setShifoufabiao(String shifoufabiao) {
		this.shifoufabiao = shifoufabiao;
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