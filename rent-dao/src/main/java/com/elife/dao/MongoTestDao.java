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
        List<Zans> zansList = remarks.getZan();

        Query query = new Query(Criteria.where("reg_id").is(remarks.getReg_id()));
        zansList.add(zans);
        mongoTemplate.updateFirst(query,new Update().set("zan", zansList), remarks.class);

        /*  System.out.println(likeComment.toString());

       Comment comment = mongoTemplate.findOne(query, Comment.class);
        List<LikeComment> likeCommentList = comment.getLikeCommentList();
        for (int i = 0; i < likeCommentList.size(); i++) {
/          System.out.println(likeCommentList.get(i).toString());
        }
//        likeCommentList.remove(likeComment);
//        mongoTemplate.updateFirst(query, new Update().set("likeCommentList", likeCommentList), Comment.class);*/

       /* Update update = new Update().set("zan", remarks.getZans());*/

      /*  Update update = new Update().set("age", remarks.getZans()).set("name", remarks.getName());*/
        //更新查询返回结果集的第一条
      /* */



        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
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
        List<Zans> zansList = remarks.getZan();

        Query query = new Query(Criteria.where("reg_id").is(remarks.getReg_id()));
        zansList.remove(zans);
        mongoTemplate.updateFirst(query,new Update().set("zan", zansList), remarks.class);
    }


}
