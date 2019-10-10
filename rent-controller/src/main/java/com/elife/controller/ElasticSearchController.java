package com.elife.controller;

import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.UserOrder;
import com.elife.service.ItemRepository;
import com.elife.service.OrderDetailRepository;
import com.elife.service.OrderDetailService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @ResponseBody
    @RequestMapping("ESTest")
    public ResultData ESOrders(int regId,String keywords){
        ResultData  resultData = new ResultData();

        createOrderDetailIndexAndSaveList();

        List<OrderDetail> orderDetails = orderDetailRepository.getByProductName(keywords);
        List<UserOrder> userOrders = new ArrayList<>();
        if(orderDetails!=null&&orderDetails.size()!=0){
            for(int i = 0;i<orderDetails.size();i++){
                OrderDetail orderDetail = orderDetails.get(i);
                UserOrder userOrder = userOrderMapper.selectByOrderNo(orderDetail.getExtra2());
                if(userOrder!=null){
                    userOrders.add(userOrder);
                }
            }
        }

        if(userOrders!=null && userOrders.size()!=0){
            resultData.setCode(0);
            resultData.setData(userOrders);
        }else{
            resultData.setCode(3);
        }

        return resultData;
    }

    public void createOrderDetailIndexAndSaveList(){
        //从数据库中查询所有的订单详情信息
        List<OrderDetail> orderDetailList = orderDetailService.selectAllOrders();
        //先判断是否有值
        if( null != orderDetailList && orderDetailList.size() != 0 ){
            //判断是否已有索引
            if(elasticsearchTemplate.indexExists("orderdetail")){
                elasticsearchTemplate.deleteIndex(OrderDetail.class);
            }
            elasticsearchTemplate.createIndex(OrderDetail.class);
            elasticsearchTemplate.putMapping(OrderDetail.class);
            itemRepository.saveAll(orderDetailList);
            System.out.println("============创建索引成功==============");
        }else{
            if(elasticsearchTemplate.indexExists("orderdetail")){
                elasticsearchTemplate.deleteIndex(OrderDetail.class);
            }
            elasticsearchTemplate.createIndex(OrderDetail.class);
            elasticsearchTemplate.putMapping(OrderDetail.class);
            System.out.println("===========没有订单详情信息============");
        }
    }


}
