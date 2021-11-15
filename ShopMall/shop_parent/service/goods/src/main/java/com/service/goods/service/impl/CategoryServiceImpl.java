package com.service.goods.service.impl;

import com.goods.pojo.Category;
import com.service.goods.dao.CategoryMapper;
import com.service.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> findList() {
        return categoryMapper.selectAll();
    }
}
