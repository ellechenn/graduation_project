package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JiaoshijibendanganInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JiaoshijibendanganInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JiaoshijibendanganInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JiaoshijibendanganInfoService {

    @Resource
    private JiaoshijibendanganInfoDao jiaoshijibendanganInfoDao;
	
	//kuabiaojisuan3

    public JiaoshijibendanganInfo add(JiaoshijibendanganInfo jiaoshijibendanganInfo) {
        List<Long> zhaopianflst = jiaoshijibendanganInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            jiaoshijibendanganInfo.setZhaopian(zhaopianflst.toString());
        }
		
		        //shangxchxuantupxian
        // 唯一校验
        
      // jiaoshijibendanganInfo.setAccount((double) 0);
	  
        jiaoshijibendanganInfoDao.insertSelective(jiaoshijibendanganInfo);
        return jiaoshijibendanganInfo;
    }

    public void delete(Long id) {
        jiaoshijibendanganInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JiaoshijibendanganInfo jiaoshijibendanganInfo) {
        List<Long> zhaopianflst = jiaoshijibendanganInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            jiaoshijibendanganInfo.setZhaopian(zhaopianflst.toString());
        }
		
		        //shangxchxuantupxian
		//youdianzan
        jiaoshijibendanganInfoDao.updateByPrimaryKeySelective(jiaoshijibendanganInfo);
    }

    public JiaoshijibendanganInfo findById(Long id) {
        return jiaoshijibendanganInfoDao.selectByPrimaryKey(id);
    }

    public List<JiaoshijibendanganInfoVo> findAll() {
        return jiaoshijibendanganInfoDao.findByXingming("all");
    }

    public PageInfo<JiaoshijibendanganInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoshijibendanganInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jiaoshijibendanganInfoDao.findByXingming(xingming);}

        if (user.getLevel().equals("师资队伍")) {all = jiaoshijibendanganInfoDao.findByXingming(xingming);}


		if (user.getLevel().equals("教师")) {all = jiaoshijibendanganInfoDao.findByXingminglist2(xingming,user.getGonghao()); }
        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JiaoshijibendanganInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoshijibendanganInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jiaoshijibendanganInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = jiaoshijibendanganInfoDao.findByXingminglist2(xingming,user.getGonghao()); }
        
	
	
        
        return PageInfo.of(all);
    }

   // public JiaoshijibendanganInfoVo findByUserName(String name) {
//        return jiaoshijibendanganInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        JiaoshijibendanganInfo jiaoshijibendanganInfo = jiaoshijibendanganInfoDao.selectByPrimaryKey(id);
        if(jiaoshijibendanganInfo.getStatus().equals("是")){
            jiaoshijibendanganInfo.setStatus("否");
            jiaoshijibendanganInfoDao.updateByPrimaryKey(jiaoshijibendanganInfo);
        }else if(jiaoshijibendanganInfo.getStatus().equals("否")){
            jiaoshijibendanganInfo.setStatus("是");
            jiaoshijibendanganInfoDao.updateByPrimaryKey(jiaoshijibendanganInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
