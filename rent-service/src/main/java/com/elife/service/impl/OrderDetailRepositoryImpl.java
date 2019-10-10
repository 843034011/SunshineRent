package com.elife.service.impl;

import com.elife.pojo.OrderDetail;
import com.elife.service.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailRepositoryImpl implements com.elife.service.OrderDetailRepository {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return itemRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getByProductName(String productName) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("productName",productName);
        Iterable<OrderDetail> iterable = itemRepository.search(matchQueryBuilder);
        iterable.forEach(e->orderDetailList.add(e));

        for(int i=0;i<orderDetailList.size();i++){
            orderDetailList.get(i).toString();
        }

        return orderDetailList;
    }
}
