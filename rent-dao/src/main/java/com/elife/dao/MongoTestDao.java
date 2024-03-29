package com.elife.dao;


import com.elife.pojo.RentRegister;
import com.elife.pojo.Zans;
import com.elife.pojo.remarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Component
public class MongoTestDao {


    @Autowired
    private MongoTemplate mongoTemplate;
/*
*
     * 创建对象*/



    public void saveTest(remarks test) {
        mongoTemplate.save(test);
    }




    public List<remarks> findALL() {
       /*Query query = new Query(Criteria.where("reg_id").is(regId));*/
        List<remarks> remark= mongoTemplate.findAll(remarks.class);

        return remark;
    }

/*
     * 更新对象*/



    public remarks updateTest(remarks remarks) {

        System.out.println( "regid+++++++"+remarks.getReg_id() );
        System.out.println("zan+++++++++"+remarks.getZan().toString());
        Zans zans=new Zans();
        zans.setZan(remarks.getZan().get(0).getZan());
        System.out.println(zans.getZan());
        Query query = new Query(Criteria.where("reg_id").is(remarks.getReg_id()));
         remarks remarks1 = mongoTemplate.findOne(query, remarks.class);
        System.out.println(remarks1.toString()+"cdevuiuvhuhdviohjdsfvjf");
        List<Zans> zansList = remarks1.getZan();
        zansList.add(zans);
        mongoTemplate.updateFirst(query,new Update().set("zan", zansList), remarks.class);
        return remarks;
    }

/**
     * 删除对象
     *
     * */

/*
Query query = new Query(Criteria.where("reg_id").is(remarks.getReg_id()));*/
    public void delete(remarks remarks) {
        System.out.println( "regid+++++++"+remarks.getReg_id() );
        System.out.println("zan+++++++++"+remarks.getZan().toString());
        Zans zans=new Zans();
        zans.setZan(remarks.getZan().get(0).getZan());


        System.out.println("zandddd++++++++++++=="+zans.toString());
        Query query = new Query(Criteria.where("reg_id").is(remarks.getReg_id()));
        remarks remarks1 = mongoTemplate.findOne(query, remarks.class);
        List<Zans> zansList = remarks1.getZan();
        System.out.println("oooooooo"+zansList.get(1));
        for(int i=0;i<zansList.size();i++)
        {
            if(zansList.get(i).getZan()==zans.getZan()){
                zansList.remove(i);
            }
        }

        System.out.println(zansList.toString());
        mongoTemplate.updateFirst(query,new Update().set("zan", zansList), remarks.class);
    }


}
