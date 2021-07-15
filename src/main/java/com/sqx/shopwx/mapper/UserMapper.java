package com.sqx.shopwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqx.shopwx.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserBean> {

    @Select("select * from tbl_user where username = #{username} and password = #{password}")
    UserBean getUser(@Param("username") String username, @Param("password") String password);

}
