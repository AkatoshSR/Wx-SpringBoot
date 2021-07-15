package com.sqx.shopwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqx.shopwx.pojo.OrderBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<OrderBean> {
}
