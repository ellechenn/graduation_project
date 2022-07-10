package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiaoxuegongzuoliang_info")
public class JiaoxuegongzuoliangInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")
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
    }
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
        return xuenian;
    }
    public void setXuenian(String xuenian) {
		this.xuenian = xuenian;
    }
        return xueqi;
    }
    public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
    }
        return kechengmingcheng;
    }
    public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
    }
        return jiaoxueneirong;
    }
    public void setJiaoxueneirong(String jiaoxueneirong) {
		this.jiaoxueneirong = jiaoxueneirong;
    }
        return jiaoxuekeshi;
    }
    public void setJiaoxuekeshi(String jiaoxuekeshi) {
		this.jiaoxuekeshi = jiaoxuekeshi;
    }
        return jiaoxueduixiang;
    }
    public void setJiaoxueduixiang(String jiaoxueduixiang) {
		this.jiaoxueduixiang = jiaoxueduixiang;
    }
        return jiaoxuebanrenshu;
    }
    public void setJiaoxuebanrenshu(String jiaoxuebanrenshu) {
		this.jiaoxuebanrenshu = jiaoxuebanrenshu;
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