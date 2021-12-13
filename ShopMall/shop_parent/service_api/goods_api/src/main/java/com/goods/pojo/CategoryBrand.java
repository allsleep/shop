package com.goods.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_category_brand")
public class CategoryBrand {

    //分类id
    @Id
    private Integer categoryId;

    //品牌id
    @Id
    private Integer brandId;
}
