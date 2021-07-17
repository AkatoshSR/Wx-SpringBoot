package com.sqx.shopwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqx.shopwx.pojo.OrderBean;
import com.sqx.shopwx.pojo.ProductBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderBean> {

    @Select("select tbl_product.* ,tbl_shopping.count from tbl_shopping "
                +"left join tbl_product on tbl_shopping.pid = tbl_product.id "
                +"where oid=#{oid}"
        )
        List<ProductBean> getProduct(@Param("oid")int oid);
}
