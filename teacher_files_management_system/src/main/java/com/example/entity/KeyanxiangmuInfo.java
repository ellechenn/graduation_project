package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "keyanxiangmu_info")
public class KeyanxiangmuInfo extends Account {
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
        return shijian;
    }
    public void setShijian(String shijian) {
		this.shijian = shijian;
    }
        return xiangmumingcheng;
    }
    public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
    }
        return xiangmufaqiren;
    }
    public void setXiangmufaqiren(String xiangmufaqiren) {
		this.xiangmufaqiren = xiangmufaqiren;
    }
        return canyurenshu;
    }
    public void setCanyurenshu(String canyurenshu) {
		this.canyurenshu = canyurenshu;
    }
        return shifouhuojiang;
    }
    public void setShifouhuojiang(String shifouhuojiang) {
		this.shifouhuojiang = shifouhuojiang;
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