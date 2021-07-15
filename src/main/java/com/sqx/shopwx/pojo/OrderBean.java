package com.sqx.shopwx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sqx.shopwx.utils.NotNull;
import lombok.Data;

import java.util.Date;

@TableName("tbl_order")
@Data
public class OrderBean {

    @TableField(exist = false) // 自定义字段，数据表中不存在该字段
    private String json;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotNull(fieldName = "姓名")
    private String name;
    @NotNull(fieldName = "手机")
    private String mobile;
    @NotNull(fieldName = "地址")
    private String address;
    @NotNull(fieldName = "总价")
    private Integer total;
    private Date ctime;

}
