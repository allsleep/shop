package com.service.goods.service;

import com.github.pagehelper.Page;
import com.goods.pojo.Brand;
import feign.Param;
import java.util.List;
import java.util.Map;

public interface BrandService {
    //品牌列表查询
    List<Brand> findList();

    //根据id查询品牌
    Brand findById(Integer id);

    //品牌的新增
    void add(Brand brand);

    //品牌的更新
    void update(Brand brand);

    //品牌删除
    void deleteById(Integer id);

    //品牌列表条件查询
    List<Brand> findListByKeys(Map<String, Object> searchMap);

    /*品牌列表分页查询
     * @param page 当前是第几页
     * @param size 每页显示多少
     */
    Page<Brand> findPage(int page, int size);

    //品牌列表分页、条件查询
    Page<Brand> findPageByKeys(Map<String, Object> searchMap, int page, int size);

    //根据分类名称查询品牌列表
    public List<Map> findBrandListByCategoryName(@Param("categoryName") String categoryName);

}
