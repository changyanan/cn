package com.example.springelasticsearch.service;
import java.math.BigDecimal;

import com.example.springelasticsearch.document.EsProduct;
import com.example.springelasticsearch.repository.EsProductRepository;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author changyanan1
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductRepository productRepository;
    @Autowired
            private ElasticsearchClient elasticsearchClient;
    List<EsProduct> esProductList= new ArrayList<>();

    {
        EsProduct e1 = new EsProduct();
        e1.setId(1L);
        e1.setProductSn("ds001");
        e1.setBrandId(0L);
        e1.setBrandName("test");
        e1.setProductCategoryId(56L);
        e1.setProductCategoryName("种类");
        e1.setPic("url");
        e1.setName("充电器");
        e1.setSubTitle("头部");
        e1.setKeywords("小米");
        e1.setPrice(new BigDecimal("100"));
        e1.setSale(150);
        e1.setNewStatus(1);
        e1.setRecommandStatus(1);
        e1.setStock(20);
        e1.setPromotionType(221);
        e1.setSort(1);
        esProductList.add(e1);
    }

    @Override
    public int importAll() {

        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = new EsProduct();
        List<EsProduct> esProductList = new ArrayList<>();
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}
