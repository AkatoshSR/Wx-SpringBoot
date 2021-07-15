package com.sqx.shopwx.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sqx.shopwx.utils.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_product")
public class ProductBean {

    @TableField(exist = false)  // 数据表没有该字段，自定义字段
    private String category;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotNull
    private String product;
    @NotNull
    private Integer price;
    @NotNull
    private Integer num;
    @NotNull
    private String logo;
    private Integer hot;
    private Integer cid;

}
