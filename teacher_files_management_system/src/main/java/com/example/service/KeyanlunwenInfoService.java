package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.KeyanlunwenInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.KeyanlunwenInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.KeyanlunwenInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class KeyanlunwenInfoService {

    @Resource
    private KeyanlunwenInfoDao keyanlunwenInfoDao;
	
	//kuabiaojisuan3

    public KeyanlunwenInfo add(KeyanlunwenInfo keyanlunwenInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // keyanlunwenInfo.setAccount((double) 0);
	  
        keyanlunwenInfoDao.insertSelective(keyanlunwenInfo);
        return keyanlunwenInfo;
    }

    public void delete(Long id) {
        keyanlunwenInfoDao.deleteByPrimaryKey(id);
    }

    public void update(KeyanlunwenInfo keyanlunwenInfo) {
        //shangxchxuantupxian
		//youdianzan
        keyanlunwenInfoDao.updateByPrimaryKeySelective(keyanlunwenInfo);
    }

    public KeyanlunwenInfo findById(Long id) {
        return keyanlunwenInfoDao.selectByPrimaryKey(id);
    }

    public List<KeyanlunwenInfoVo> findAll() {
        return keyanlunwenInfoDao.findByXingming("all");
    }

    public PageInfo<KeyanlunwenInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanlunwenInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = keyanlunwenInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("教师")) {all = keyanlunwenInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<KeyanlunwenInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanlunwenInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = keyanlunwenInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = keyanlunwenInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public KeyanlunwenInfoVo findByUserName(String name) {
//        return keyanlunwenInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        KeyanlunwenInfo keyanlunwenInfo = keyanlunwenInfoDao.selectByPrimaryKey(id);
        if(keyanlunwenInfo.getStatus().equals("是")){
            keyanlunwenInfo.setStatus("否");
            keyanlunwenInfoDao.updateByPrimaryKey(keyanlunwenInfo);
        }else if(keyanlunwenInfo.getStatus().equals("否")){
            keyanlunwenInfo.setStatus("是");
            keyanlunwenInfoDao.updateByPrimaryKey(keyanlunwenInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
