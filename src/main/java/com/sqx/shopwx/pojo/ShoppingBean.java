package com.sqx.shopwx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tbl_shopping")
@Data
@NoArgsConstructor
public class ShoppingBean {

    public ShoppingBean(Integer oid, Integer pid, Integer count) {
        this.oid = oid;
        this.pid = pid;
        this.count = count;
    }


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer oid;
    private Integer pid;
    private Integer count;

}
