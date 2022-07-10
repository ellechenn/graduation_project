package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "shiziduiwu_info")
public class ShiziduiwuInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "zhanghao")	private String zhanghao;	@Column(name = "mima")	private String mima;	@Column(name = "mingcheng")	private String mingcheng;	@Column(name = "level")	private String level;	
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

	
	public String getZhanghao() {
        return zhanghao;
    }
    public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }	public String getMingcheng() {
        return mingcheng;
    }
    public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
    }	public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
		this.level = level;
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