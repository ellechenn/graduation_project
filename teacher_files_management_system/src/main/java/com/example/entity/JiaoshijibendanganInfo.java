package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiaoshijibendangan_info")
public class JiaoshijibendanganInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gonghao")	private String gonghao;	@Column(name = "xingming")	private String xingming;	@Column(name = "xingbie")	private String xingbie;	@Column(name = "nianling")	private String nianling;	@Column(name = "xueli")	private String xueli;	@Column(name = "xianzaizhicheng")	private String xianzaizhicheng;	@Column(name = "minzu")	private String minzu;	@Column(name = "dianhuahaoma")	private String dianhuahaoma;	@Column(name = "shenfenzheng")	private String shenfenzheng;	@Column(name = "youxiang")	private String youxiang;	@Column(name = "zhengzhimianmao")	private String zhengzhimianmao;	@Column(name = "renjiaokemu")	private String renjiaokemu;	@Column(name = "jiatingzhuzhi")	private String jiatingzhuzhi;	@Column(name = "shentizhuangkuang")	private String shentizhuangkuang;	@Column(name = "xuexiao")	private String xuexiao;	@Column(name = "zaibenxiaorenzhishijian")	private String zaibenxiaorenzhishijian;	@Column(name = "xuexijingli")	private String xuexijingli;	@Column(name = "gongzuojingli")	private String gongzuojingli;	@Column(name = "zhaopian")	private String zhaopian;	
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
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }	public String getNianling() {
        return nianling;
    }
    public void setNianling(String nianling) {
		this.nianling = nianling;
    }	public String getXueli() {
        return xueli;
    }
    public void setXueli(String xueli) {
		this.xueli = xueli;
    }	public String getXianzaizhicheng() {
        return xianzaizhicheng;
    }
    public void setXianzaizhicheng(String xianzaizhicheng) {
		this.xianzaizhicheng = xianzaizhicheng;
    }	public String getMinzu() {
        return minzu;
    }
    public void setMinzu(String minzu) {
		this.minzu = minzu;
    }	public String getDianhuahaoma() {
        return dianhuahaoma;
    }
    public void setDianhuahaoma(String dianhuahaoma) {
		this.dianhuahaoma = dianhuahaoma;
    }	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }	public String getYouxiang() {
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
    }	public String getZhengzhimianmao() {
        return zhengzhimianmao;
    }
    public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
    }	public String getRenjiaokemu() {
        return renjiaokemu;
    }
    public void setRenjiaokemu(String renjiaokemu) {
		this.renjiaokemu = renjiaokemu;
    }	public String getJiatingzhuzhi() {
        return jiatingzhuzhi;
    }
    public void setJiatingzhuzhi(String jiatingzhuzhi) {
		this.jiatingzhuzhi = jiatingzhuzhi;
    }	public String getShentizhuangkuang() {
        return shentizhuangkuang;
    }
    public void setShentizhuangkuang(String shentizhuangkuang) {
		this.shentizhuangkuang = shentizhuangkuang;
    }	public String getXuexiao() {
        return xuexiao;
    }
    public void setXuexiao(String xuexiao) {
		this.xuexiao = xuexiao;
    }	public String getZaibenxiaorenzhishijian() {
        return zaibenxiaorenzhishijian;
    }
    public void setZaibenxiaorenzhishijian(String zaibenxiaorenzhishijian) {
		this.zaibenxiaorenzhishijian = zaibenxiaorenzhishijian;
    }	public String getXuexijingli() {
        return xuexijingli;
    }
    public void setXuexijingli(String xuexijingli) {
		this.xuexijingli = xuexijingli;
    }	public String getGongzuojingli() {
        return gongzuojingli;
    }
    public void setGongzuojingli(String gongzuojingli) {
		this.gongzuojingli = gongzuojingli;
    }	public String getZhaopian() {
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