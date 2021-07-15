package com.sqx.shopwx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sqx.shopwx.utils.NotNull;
import lombok.Data;

@TableName("tbl_member")
@Data
public class MemberBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Integer money;
    @NotNull
    private String mobile;
    @NotNull
    private String name;

}
