package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.ProductMapper;
import com.sqx.shopwx.pojo.ProductBean;
import com.sqx.shopwx.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductBean> implements ProductService {

    // 获取商品列表
    @Override
    public List<ProductBean> getProductList(Integer id) {
        QueryWrapper<ProductBean> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", id);
        return list(wrapper);
    }

    // 添加商品
    @Override
    public boolean addProduct(ProductBean productBean) {
        return save(productBean);
    }

    // 根据id删除商品
    @Override
    public boolean deleteProductById(int id) {
        return removeById(id);
    }

    // 获取图片
    @Override
    public String logo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File("E:/a_resources/a_resources/create/shop/file/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    // 获取热卖商品
    @Override
    public List<ProductBean> getHotProduct() {
        QueryWrapper<ProductBean> wrapper = new QueryWrapper<>();
        wrapper.eq("hot", 1);
        return list(wrapper);
    }
}
