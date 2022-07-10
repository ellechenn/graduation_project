package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JiaoxuegongzuoliangInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JiaoxuegongzuoliangInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JiaoxuegongzuoliangInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JiaoxuegongzuoliangInfoService {

    @Resource
    private JiaoxuegongzuoliangInfoDao jiaoxuegongzuoliangInfoDao;
	
	//kuabiaojisuan3

    public JiaoxuegongzuoliangInfo add(JiaoxuegongzuoliangInfo jiaoxuegongzuoliangInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // jiaoxuegongzuoliangInfo.setAccount((double) 0);
	  
        jiaoxuegongzuoliangInfoDao.insertSelective(jiaoxuegongzuoliangInfo);
        return jiaoxuegongzuoliangInfo;
    }

    public void delete(Long id) {
        jiaoxuegongzuoliangInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JiaoxuegongzuoliangInfo jiaoxuegongzuoliangInfo) {
        //shangxchxuantupxian
		//youdianzan
        jiaoxuegongzuoliangInfoDao.updateByPrimaryKeySelective(jiaoxuegongzuoliangInfo);
    }

    public JiaoxuegongzuoliangInfo findById(Long id) {
        return jiaoxuegongzuoliangInfoDao.selectByPrimaryKey(id);
    }

    public List<JiaoxuegongzuoliangInfoVo> findAll() {
        return jiaoxuegongzuoliangInfoDao.findByXingming("all");
    }

    public PageInfo<JiaoxuegongzuoliangInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoxuegongzuoliangInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jiaoxuegongzuoliangInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("教师")) {all = jiaoxuegongzuoliangInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JiaoxuegongzuoliangInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoxuegongzuoliangInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jiaoxuegongzuoliangInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = jiaoxuegongzuoliangInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public JiaoxuegongzuoliangInfoVo findByUserName(String name) {
//        return jiaoxuegongzuoliangInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        JiaoxuegongzuoliangInfo jiaoxuegongzuoliangInfo = jiaoxuegongzuoliangInfoDao.selectByPrimaryKey(id);
        if(jiaoxuegongzuoliangInfo.getStatus().equals("是")){
            jiaoxuegongzuoliangInfo.setStatus("否");
            jiaoxuegongzuoliangInfoDao.updateByPrimaryKey(jiaoxuegongzuoliangInfo);
        }else if(jiaoxuegongzuoliangInfo.getStatus().equals("否")){
            jiaoxuegongzuoliangInfo.setStatus("是");
            jiaoxuegongzuoliangInfoDao.updateByPrimaryKey(jiaoxuegongzuoliangInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
