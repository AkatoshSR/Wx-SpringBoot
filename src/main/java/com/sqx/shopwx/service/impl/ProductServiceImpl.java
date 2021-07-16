package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public ProductBean getProductById(Integer id) {
        QueryWrapper<ProductBean> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return getOne(wrapper);
    }

    // 添加商品
    @Override
    public boolean addProduct(ProductBean productBean) {
        return save(productBean);
    }

    // 根据id删除商品
    @Override
    public boolean deleteProductById(Integer id) {
        return removeById(id);
    }

    // 修改商品
    @Override
    public boolean updateProduct(ProductBean productBean) {
        return updateById(productBean);
    }

    // 获取图片
    @Override
    public String logo(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        file.transferTo(new File("E:/a_resources/a_resources/create/shop/file/" + fileName));
        return fileName;
    }

    // 修改图片
    @Override
    public boolean updateLogo(ProductBean productBean) throws IOException {
        return updateById(productBean);
    }

    // 修改tup
    @Override
    public boolean updateLogoPic(ProductBean productBean) throws IOException {
        return false;
    }


    // 获取热卖商品
    @Override
    public List<ProductBean> getHotProduct() {
        QueryWrapper<ProductBean> wrapper = new QueryWrapper<>();
        wrapper.eq("hot", 1);
        return list(wrapper);
    }

    @Override
    public Page<ProductBean> getListByPage(long current, long limit, ProductBean productBean) {
        Page<ProductBean> page = new Page<>(current, limit);
        // 构建条件
        QueryWrapper<ProductBean> wrapper = new QueryWrapper<>();
        Integer id = productBean.getId();
        Integer cid = productBean.getCid();
        String product = productBean.getProduct();

        if (cid != null){
            wrapper.eq("cid",cid);
        }
        if (id != null) {
            wrapper.eq("id", id);
        }
        if (product != null) {
            wrapper.like("product", product);
        }

        Page<ProductBean> productBeanPage = page(page, wrapper);
        return productBeanPage;
    }
}
