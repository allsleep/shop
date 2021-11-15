package com.service.goods.service;

import com.common.pojo.Result;
import com.goods.pojo.Brand;
import com.goods.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findList();
}
