package com.service.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goods.pojo.Brand;
import com.service.goods.dao.BrandMapper;
import com.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findList() {
        List<Brand> brandList = brandMapper.selectAll();
        return brandList;
    }

    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Override
    @Transactional
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    @Transactional
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findListByKeys(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null){
            //根据品牌名称模糊查询
            if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                 criteria.andLike("name", "%"+searchMap.get("name")+"%");
            }
            //根据品牌首字母
            else if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter",searchMap.get("letter"));
            }
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public Page<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> page1 =  (Page<Brand>) brandMapper.selectAll();
        return page1;
    }

    @Override
    public Page<Brand> findPageByKeys(Map<String, Object> searchMap, int page, int size) {
        //设置分页
        PageHelper.startPage(page, size);
        //设置当前查询条件
        Page<Brand> pageInfo = (Page<Brand>)this.findListByKeys(searchMap);
        return pageInfo;
    }

    @Override
    public List<Map> findBrandListByCategoryName(String categoryName) {
        List<Map> brandListByCategoryName = brandMapper.findBrandListByCategoryName(categoryName);
        return brandListByCategoryName;
    }
}
