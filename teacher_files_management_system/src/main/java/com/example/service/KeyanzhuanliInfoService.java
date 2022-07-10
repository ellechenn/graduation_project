package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.KeyanzhuanliInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.KeyanzhuanliInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.KeyanzhuanliInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class KeyanzhuanliInfoService {

    @Resource
    private KeyanzhuanliInfoDao keyanzhuanliInfoDao;
	
	//kuabiaojisuan3

    public KeyanzhuanliInfo add(KeyanzhuanliInfo keyanzhuanliInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // keyanzhuanliInfo.setAccount((double) 0);
	  
        keyanzhuanliInfoDao.insertSelective(keyanzhuanliInfo);
        return keyanzhuanliInfo;
    }

    public void delete(Long id) {
        keyanzhuanliInfoDao.deleteByPrimaryKey(id);
    }

    public void update(KeyanzhuanliInfo keyanzhuanliInfo) {
        //shangxchxuantupxian
		//youdianzan
        keyanzhuanliInfoDao.updateByPrimaryKeySelective(keyanzhuanliInfo);
    }

    public KeyanzhuanliInfo findById(Long id) {
        return keyanzhuanliInfoDao.selectByPrimaryKey(id);
    }

    public List<KeyanzhuanliInfoVo> findAll() {
        return keyanzhuanliInfoDao.findByXingming("all");
    }

    public PageInfo<KeyanzhuanliInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanzhuanliInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = keyanzhuanliInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("教师")) {all = keyanzhuanliInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<KeyanzhuanliInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanzhuanliInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = keyanzhuanliInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = keyanzhuanliInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public KeyanzhuanliInfoVo findByUserName(String name) {
//        return keyanzhuanliInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        KeyanzhuanliInfo keyanzhuanliInfo = keyanzhuanliInfoDao.selectByPrimaryKey(id);
        if(keyanzhuanliInfo.getStatus().equals("是")){
            keyanzhuanliInfo.setStatus("否");
            keyanzhuanliInfoDao.updateByPrimaryKey(keyanzhuanliInfo);
        }else if(keyanzhuanliInfo.getStatus().equals("否")){
            keyanzhuanliInfo.setStatus("是");
            keyanzhuanliInfoDao.updateByPrimaryKey(keyanzhuanliInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
