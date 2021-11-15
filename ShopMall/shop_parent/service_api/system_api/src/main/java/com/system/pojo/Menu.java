package com.system.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * menu实体类
 * @author 黑马架构师2.5
 *
 */
@Table(name="tb_menu")
@Data
public class Menu implements Serializable {

	@Id
	private String id;//菜单ID
	
	private String name;//菜单名称
	private String icon;//图标
	private String url;//URL
	private String parentId;//上级菜单ID

}
