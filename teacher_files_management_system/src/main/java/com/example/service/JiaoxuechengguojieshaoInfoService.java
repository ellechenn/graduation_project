package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JiaoxuechengguojieshaoInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JiaoxuechengguojieshaoInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JiaoxuechengguojieshaoInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JiaoxuechengguojieshaoInfoService {

    @Resource
    private JiaoxuechengguojieshaoInfoDao jiaoxuechengguojieshaoInfoDao;
	
	//kuabiaojisuan3

    public JiaoxuechengguojieshaoInfo add(JiaoxuechengguojieshaoInfo jiaoxuechengguojieshaoInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // jiaoxuechengguojieshaoInfo.setAccount((double) 0);
	  
        jiaoxuechengguojieshaoInfoDao.insertSelective(jiaoxuechengguojieshaoInfo);
        return jiaoxuechengguojieshaoInfo;
    }

    public void delete(Long id) {
        jiaoxuechengguojieshaoInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JiaoxuechengguojieshaoInfo jiaoxuechengguojieshaoInfo) {
        //shangxchxuantupxian
		//youdianzan
        jiaoxuechengguojieshaoInfoDao.updateByPrimaryKeySelective(jiaoxuechengguojieshaoInfo);
    }

    public JiaoxuechengguojieshaoInfo findById(Long id) {
        return jiaoxuechengguojieshaoInfoDao.selectByPrimaryKey(id);
    }

    public List<JiaoxuechengguojieshaoInfoVo> findAll() {
        return jiaoxuechengguojieshaoInfoDao.findByXingming("all");
    }

    public PageInfo<JiaoxuechengguojieshaoInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoxuechengguojieshaoInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jiaoxuechengguojieshaoInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("教师")) {all = jiaoxuechengguojieshaoInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JiaoxuechengguojieshaoInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoxuechengguojieshaoInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jiaoxuechengguojieshaoInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = jiaoxuechengguojieshaoInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public JiaoxuechengguojieshaoInfoVo findByUserName(String name) {
//        return jiaoxuechengguojieshaoInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        JiaoxuechengguojieshaoInfo jiaoxuechengguojieshaoInfo = jiaoxuechengguojieshaoInfoDao.selectByPrimaryKey(id);
        if(jiaoxuechengguojieshaoInfo.getStatus().equals("是")){
            jiaoxuechengguojieshaoInfo.setStatus("否");
            jiaoxuechengguojieshaoInfoDao.updateByPrimaryKey(jiaoxuechengguojieshaoInfo);
        }else if(jiaoxuechengguojieshaoInfo.getStatus().equals("否")){
            jiaoxuechengguojieshaoInfo.setStatus("是");
            jiaoxuechengguojieshaoInfoDao.updateByPrimaryKey(jiaoxuechengguojieshaoInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
