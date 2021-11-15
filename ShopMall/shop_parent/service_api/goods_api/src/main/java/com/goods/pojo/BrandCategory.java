package com.goods.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_category_brand")
public class BrandCategory {
    @Id
    private int id;

    private int brandId;
    private int categoryId;
}
