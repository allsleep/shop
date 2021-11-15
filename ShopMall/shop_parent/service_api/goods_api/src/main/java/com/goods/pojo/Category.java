package com.goods.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="tb_category")
@Data
public class Category {
    @Id
    private Integer id;

    private String name; // 分类名称

    @Column(name="goodsNum")
    private Integer goodsNum; //商品数量

    @Column(name="isShow")
    private String isShow;//是否显示

    @Column(name="isMenu")
    private String isMenu;//是否导航

    private Integer seq;//排序

    @Column(name="parentId")
    private Integer parentId;//上级ID

    @Column(name="templateId")
    private Integer templateId;//模板ID

//    @ManyToMany
//    private List<BrandCategory> brandCategory;
}
