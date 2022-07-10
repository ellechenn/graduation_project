package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JiaoshixinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JiaoshixinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JiaoshixinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JiaoshixinxiInfoService {

    @Resource
    private JiaoshixinxiInfoDao jiaoshixinxiInfoDao;
	
	//kuabiaojisuan3

    public JiaoshixinxiInfo add(JiaoshixinxiInfo jiaoshixinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        int count = jiaoshixinxiInfoDao.checkRepeat("gonghao", jiaoshixinxiInfo.getGonghao(), null);
if (count > 0) {
	throw new CustomException("1001", "该工号\"" + jiaoshixinxiInfo.getGonghao() + "\"已存在");
}
      // jiaoshixinxiInfo.setAccount((double) 0);
	  
        jiaoshixinxiInfoDao.insertSelective(jiaoshixinxiInfo);
        return jiaoshixinxiInfo;
    }

    public void delete(Long id) {
        jiaoshixinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JiaoshixinxiInfo jiaoshixinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        jiaoshixinxiInfoDao.updateByPrimaryKeySelective(jiaoshixinxiInfo);
    }

    public JiaoshixinxiInfo findById(Long id) {
        return jiaoshixinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<JiaoshixinxiInfoVo> findAll() {
        return jiaoshixinxiInfoDao.findByGonghao("all");
    }

    public PageInfo<JiaoshixinxiInfoVo> findPage(String gonghao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoshixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jiaoshixinxiInfoDao.findByGonghao(gonghao);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JiaoshixinxiInfoVo> findPageqt(String gonghao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaoshixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jiaoshixinxiInfoDao.findByGonghao(gonghao);
		
	
	
        
        return PageInfo.of(all);
    }

   // public JiaoshixinxiInfoVo findByUserName(String name) {
//        return jiaoshixinxiInfoDao.findByUsername(name);
//    }

	public JiaoshixinxiInfo login(String gonghao, String mima) {
        JiaoshixinxiInfo jiaoshixinxiInfo = jiaoshixinxiInfoDao.findByGonghaozj(gonghao);
        if (jiaoshixinxiInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(mima).equalsIgnoreCase(jiaoshixinxiInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return jiaoshixinxiInfo;
    }
	
    public void changeStatus(Long id) {
        JiaoshixinxiInfo jiaoshixinxiInfo = jiaoshixinxiInfoDao.selectByPrimaryKey(id);
        if(jiaoshixinxiInfo.getStatus().equals("是")){
            jiaoshixinxiInfo.setStatus("否");
            jiaoshixinxiInfoDao.updateByPrimaryKey(jiaoshixinxiInfo);
        }else if(jiaoshixinxiInfo.getStatus().equals("否")){
            jiaoshixinxiInfo.setStatus("是");
            jiaoshixinxiInfoDao.updateByPrimaryKey(jiaoshixinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	 public void update2(JiaoshixinxiInfoVo jiaoshixinxiInfo) {
        //shangxchxuantupxian
        if (StringUtils.isEmpty(jiaoshixinxiInfo.getMima())) {
            // 默认密码123456
            jiaoshixinxiInfo.setMima(SecureUtil.md5("123456"));
        } else {
            jiaoshixinxiInfo.setMima(SecureUtil.md5(jiaoshixinxiInfo.getMima()));
        }
        jiaoshixinxiInfoDao.updateByPrimaryKeySelective(jiaoshixinxiInfo);
    }
	
   
}
