package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.ShiziduiwuInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.ShiziduiwuInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.ShiziduiwuInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ShiziduiwuInfoService {

    @Resource
    private ShiziduiwuInfoDao shiziduiwuInfoDao;
	
	//kuabiaojisuan3

    public ShiziduiwuInfo add(ShiziduiwuInfo shiziduiwuInfo) {
        //shangxchxuantupxian
        // 唯一校验
        int count = shiziduiwuInfoDao.checkRepeat("zhanghao", shiziduiwuInfo.getZhanghao(), null);
if (count > 0) {
	throw new CustomException("1001", "该账号\"" + shiziduiwuInfo.getZhanghao() + "\"已存在");
}
      // shiziduiwuInfo.setAccount((double) 0);
	  
        shiziduiwuInfoDao.insertSelective(shiziduiwuInfo);
        return shiziduiwuInfo;
    }

    public void delete(Long id) {
        shiziduiwuInfoDao.deleteByPrimaryKey(id);
    }

    public void update(ShiziduiwuInfo shiziduiwuInfo) {
        //shangxchxuantupxian
		//youdianzan
        shiziduiwuInfoDao.updateByPrimaryKeySelective(shiziduiwuInfo);
    }

    public ShiziduiwuInfo findById(Long id) {
        return shiziduiwuInfoDao.selectByPrimaryKey(id);
    }

    public List<ShiziduiwuInfoVo> findAll() {
        return shiziduiwuInfoDao.findByZhanghao("all");
    }

    public PageInfo<ShiziduiwuInfoVo> findPage(String zhanghao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ShiziduiwuInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = shiziduiwuInfoDao.findByZhanghao(zhanghao);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<ShiziduiwuInfoVo> findPageqt(String zhanghao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ShiziduiwuInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = shiziduiwuInfoDao.findByZhanghao(zhanghao);
		
	
	
        
        return PageInfo.of(all);
    }

   // public ShiziduiwuInfoVo findByUserName(String name) {
//        return shiziduiwuInfoDao.findByUsername(name);
//    }

	public ShiziduiwuInfo login(String zhanghao, String mima) {
        ShiziduiwuInfo shiziduiwuInfo = shiziduiwuInfoDao.findByZhanghaozj(zhanghao);
        if (shiziduiwuInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(mima).equalsIgnoreCase(shiziduiwuInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return shiziduiwuInfo;
    }
	
    public void changeStatus(Long id) {
        ShiziduiwuInfo shiziduiwuInfo = shiziduiwuInfoDao.selectByPrimaryKey(id);
        if(shiziduiwuInfo.getStatus().equals("是")){
            shiziduiwuInfo.setStatus("否");
            shiziduiwuInfoDao.updateByPrimaryKey(shiziduiwuInfo);
        }else if(shiziduiwuInfo.getStatus().equals("否")){
            shiziduiwuInfo.setStatus("是");
            shiziduiwuInfoDao.updateByPrimaryKey(shiziduiwuInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	 public void update2(ShiziduiwuInfoVo shiziduiwuInfo) {
        //shangxchxuantupxian
        if (StringUtils.isEmpty(shiziduiwuInfo.getMima())) {
            // 默认密码123456
            shiziduiwuInfo.setMima(SecureUtil.md5("123456"));
        } else {
            shiziduiwuInfo.setMima(SecureUtil.md5(shiziduiwuInfo.getMima()));
        }
        shiziduiwuInfoDao.updateByPrimaryKeySelective(shiziduiwuInfo);
    }
	
   
}
