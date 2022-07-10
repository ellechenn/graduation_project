package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiaoshijibendangan_info")
public class JiaoshijibendanganInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Transient private List<Long> zhaopianflst;	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long>  getZhaopianflst() {
        return zhaopianflst;
    }
    public void setZhaopianflst(List<Long> zhaopianflst) {
		this.zhaopianflst = zhaopianflst;
    }

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
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }
        return nianling;
    }
    public void setNianling(String nianling) {
		this.nianling = nianling;
    }
        return xueli;
    }
    public void setXueli(String xueli) {
		this.xueli = xueli;
    }
        return xianzaizhicheng;
    }
    public void setXianzaizhicheng(String xianzaizhicheng) {
		this.xianzaizhicheng = xianzaizhicheng;
    }
        return minzu;
    }
    public void setMinzu(String minzu) {
		this.minzu = minzu;
    }
        return dianhuahaoma;
    }
    public void setDianhuahaoma(String dianhuahaoma) {
		this.dianhuahaoma = dianhuahaoma;
    }
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
    }
        return zhengzhimianmao;
    }
    public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
    }
        return renjiaokemu;
    }
    public void setRenjiaokemu(String renjiaokemu) {
		this.renjiaokemu = renjiaokemu;
    }
        return jiatingzhuzhi;
    }
    public void setJiatingzhuzhi(String jiatingzhuzhi) {
		this.jiatingzhuzhi = jiatingzhuzhi;
    }
        return shentizhuangkuang;
    }
    public void setShentizhuangkuang(String shentizhuangkuang) {
		this.shentizhuangkuang = shentizhuangkuang;
    }
        return xuexiao;
    }
    public void setXuexiao(String xuexiao) {
		this.xuexiao = xuexiao;
    }
        return zaibenxiaorenzhishijian;
    }
    public void setZaibenxiaorenzhishijian(String zaibenxiaorenzhishijian) {
		this.zaibenxiaorenzhishijian = zaibenxiaorenzhishijian;
    }
        return xuexijingli;
    }
    public void setXuexijingli(String xuexijingli) {
		this.xuexijingli = xuexijingli;
    }
        return gongzuojingli;
    }
    public void setGongzuojingli(String gongzuojingli) {
		this.gongzuojingli = gongzuojingli;
    }
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
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