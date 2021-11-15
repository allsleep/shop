package com.service.goods.dao;

import com.goods.pojo.Brand;
import feign.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface BrandMapper extends Mapper<Brand> {

    @Select("select name, image from tb_brand where id in (select brandId from tb_category_brand where categoryId in (select id from tb_category where name=#{categoryName}))")
    public List<Map> findBrandListByCategoryName(@Param("categoryName") String categoryName);
}
