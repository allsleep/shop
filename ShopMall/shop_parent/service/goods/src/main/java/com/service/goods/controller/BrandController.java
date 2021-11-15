package com.service.goods.controller;


import com.common.pojo.PageResult;
import com.common.pojo.Result;
import com.common.pojo.StatusCode;
import com.github.pagehelper.Page;
import com.goods.pojo.Brand;
import com.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/brand")
@RestController // 返回的是body
//@CrossOrigin    //开启跨域请求操作
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findList(){
        List<Brand> brandList = brandService.findList();
        return new Result<>(true, StatusCode.OK, "find all brand success", brandList);
    }

    @GetMapping(params="id")
    public Result<Brand> findById(@RequestParam("id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "find brand by id success", brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "add success");
    }

    @PutMapping(params="id")
    public Result update(@RequestParam("id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "update success");
    }

    @DeleteMapping(params="id")
    public Result delete(@RequestParam("id") Integer id){
        brandService.deleteById(id);
        return new Result(true, StatusCode.OK, "delete success");
    }

    @GetMapping("/search")
    public Result<List<Brand>> search(@RequestParam Map searchMap){
        List<Brand> list = brandService.findListByKeys(searchMap);
        return new Result<>(true, StatusCode.OK,"find success", list);
    }
    
    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Brand> pageInfo = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getResult());
        return new Result(true, StatusCode.OK, "find page success", pageResult);
    }

    @GetMapping("/searchPage/{page}/{size}")
    public Result findPageByKeys(@RequestParam Map searchMap, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Brand> pageInfo = brandService.findPageByKeys(searchMap, page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getResult());
        return new Result(true, StatusCode.OK, "find page success", pageResult);
    }

    @GetMapping(path="/category", params="categoryName")
    public Result<List<Map>> findBrandListByCategoryName(@RequestParam("categoryName") String  categoryName){
        List<Map> brandListByCategoryName = brandService.findBrandListByCategoryName(categoryName);
        return new Result<>(true, StatusCode.OK, "find success", brandListByCategoryName);
    }
}
