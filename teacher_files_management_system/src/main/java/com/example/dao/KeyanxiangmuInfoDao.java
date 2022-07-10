package com.example.dao;

import com.example.entity.KeyanxiangmuInfo;
import com.example.vo.KeyanxiangmuInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface KeyanxiangmuInfoDao extends Mapper<KeyanxiangmuInfo> {
    List<KeyanxiangmuInfoVo> findByXingming(@Param("xingming") String xingming);
	List<KeyanxiangmuInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("gonghao") String gonghao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from keyanxiangmu_info where gonghao = #{gonghao}")
    KeyanxiangmuInfo selectByGonghao(String gonghao);
	
	@Select("SELECT * FROM keyanxiangmu_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}
