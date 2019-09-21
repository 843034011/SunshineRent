package com.elife.dao;


import com.elife.pojo.remarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

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
       /* Query query = new Query(Criteria.where("reg_id").is(regId));*/
        List<remarks> remark= mongoTemplate.findAll(remarks.class);

        return remark;
    }

/*
     * 更新对象*/



/*    public void updateTest(remarks test) {
        Query query = new Query(Criteria.where("id").is(test.getId()));
 Update update = new Update().set("age", test.getAge()).set("name", test.getName());


        //更新查询返回结果集的第一条
 mongoTemplate.updateFirst(query, update, remarks.class);


        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }*/

/**
     * 删除对象
     *
     * @param id*/


/*
    public void deleteTestById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,remarks.class);
    }*/


}
