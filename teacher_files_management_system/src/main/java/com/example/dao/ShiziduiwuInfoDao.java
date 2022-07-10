package com.example.dao;

import com.example.entity.ShiziduiwuInfo;
import com.example.vo.ShiziduiwuInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ShiziduiwuInfoDao extends Mapper<ShiziduiwuInfo> {
    List<ShiziduiwuInfoVo> findByZhanghao(@Param("zhanghao") String zhanghao);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from shiziduiwu_info where zhanghao = #{zhanghao}")
    ShiziduiwuInfo selectByZhanghao(String zhanghao);
	
	@Select("SELECT * FROM shiziduiwu_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	ShiziduiwuInfoVo findByZhanghaozj(String zhanghao);

}
