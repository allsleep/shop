package com.goods.pojo;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table(name="tb_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(generator="JDBC", strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;    //图片地址
    private String letter;   //牌子首字母
    private Integer seq;     //排序

//    @ManyToMany
//    private List<BrandCategory> brandCategory;
}