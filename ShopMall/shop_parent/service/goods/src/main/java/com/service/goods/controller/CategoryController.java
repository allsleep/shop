package com.service.goods.controller;

import com.common.pojo.Result;
import com.common.pojo.StatusCode;
import com.goods.pojo.Category;
import com.service.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/category")
@RestController // 返回的是body
//@CrossOrigin    //开启跨域请求操作
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result<List<Category>> findList(){
        List<Category> brandList = categoryService.findList();
        return new Result<>(true, StatusCode.OK, "find all category success", brandList);
    }
}
