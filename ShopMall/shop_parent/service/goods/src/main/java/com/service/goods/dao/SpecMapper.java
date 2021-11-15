package com.service.goods.dao;

import com.goods.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import java.util.Map;

//规格表
@Repository
public interface SpecMapper extends Mapper<Spec> {

    @Select("SELECT name,options FROM tb_spec WHERE template_id in(SELECT templateId FROM tb_category WHERE name=#{categoryName})")
    public List<Map> findSpecListByCategoryName(@Param("categoryName") String categoryName);
}
