package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.KeyanxiangmuInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.KeyanxiangmuInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.KeyanxiangmuInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class KeyanxiangmuInfoService {

    @Resource
    private KeyanxiangmuInfoDao keyanxiangmuInfoDao;
	
	//kuabiaojisuan3

    public KeyanxiangmuInfo add(KeyanxiangmuInfo keyanxiangmuInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // keyanxiangmuInfo.setAccount((double) 0);
	  
        keyanxiangmuInfoDao.insertSelective(keyanxiangmuInfo);
        return keyanxiangmuInfo;
    }

    public void delete(Long id) {
        keyanxiangmuInfoDao.deleteByPrimaryKey(id);
    }

    public void update(KeyanxiangmuInfo keyanxiangmuInfo) {
        //shangxchxuantupxian
		//youdianzan
        keyanxiangmuInfoDao.updateByPrimaryKeySelective(keyanxiangmuInfo);
    }

    public KeyanxiangmuInfo findById(Long id) {
        return keyanxiangmuInfoDao.selectByPrimaryKey(id);
    }

    public List<KeyanxiangmuInfoVo> findAll() {
        return keyanxiangmuInfoDao.findByXingming("all");
    }

    public PageInfo<KeyanxiangmuInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanxiangmuInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = keyanxiangmuInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("教师")) {all = keyanxiangmuInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<KeyanxiangmuInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<KeyanxiangmuInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = keyanxiangmuInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("教师")) {all = keyanxiangmuInfoDao.findByXingminglist2(xingming,user.getGonghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public KeyanxiangmuInfoVo findByUserName(String name) {
//        return keyanxiangmuInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        KeyanxiangmuInfo keyanxiangmuInfo = keyanxiangmuInfoDao.selectByPrimaryKey(id);
        if(keyanxiangmuInfo.getStatus().equals("是")){
            keyanxiangmuInfo.setStatus("否");
            keyanxiangmuInfoDao.updateByPrimaryKey(keyanxiangmuInfo);
        }else if(keyanxiangmuInfo.getStatus().equals("否")){
            keyanxiangmuInfo.setStatus("是");
            keyanxiangmuInfoDao.updateByPrimaryKey(keyanxiangmuInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
