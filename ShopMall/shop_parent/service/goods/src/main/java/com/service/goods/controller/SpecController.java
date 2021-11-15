package com.service.goods.controller;


import com.common.pojo.Result;
import com.common.pojo.StatusCode;
import com.service.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/spec")
@RestController // 返回的是body
//@CrossOrigin    //开启跨域请求操作
public class SpecController {
    @Autowired
    public SpecService specService;

    @GetMapping("/category/{categoryName}")
    public Result<List<Map>> findSpecListByCategoryName(@PathVariable("categoryName") String categoryName) {
        List<Map> specListByCategoryName = specService.findSpecListByCategoryName(categoryName);
        return new Result<>(true, StatusCode.OK, "find success", specListByCategoryName);
    }

}
