package com.sqx.shopwx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_user")
public class UserBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;

}
