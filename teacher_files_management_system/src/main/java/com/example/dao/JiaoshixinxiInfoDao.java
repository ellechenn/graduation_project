package com.example.dao;

import com.example.entity.JiaoshixinxiInfo;
import com.example.vo.JiaoshixinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiaoshixinxiInfoDao extends Mapper<JiaoshixinxiInfo> {
    List<JiaoshixinxiInfoVo> findByGonghao(@Param("gonghao") String gonghao);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiaoshixinxi_info where gonghao = #{gonghao}")
    JiaoshixinxiInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM jiaoshixinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	JiaoshixinxiInfoVo findByGonghaozj(String gonghao);

}
