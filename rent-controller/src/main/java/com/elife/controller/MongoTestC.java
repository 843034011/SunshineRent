/*

package com.elife.controller;

import com.elife.dao.MongoTestDao;
import com.elife.pojo.Pictures;
import com.elife.pojo.remarks;
import com.sun.corba.se.impl.interceptors.PICurrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.peer.PanelPeer;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MongoTestC {

    @Autowired
    private MongoTestDao mtdao;

    @GetMapping(value = "/test1")
    public void saveTest() throws Exception {
        remarks mgtest = new remarks();
        mgtest.setId(3);
        mgtest.setOrder_id(10);
        List<Pictures> pictures=new ArrayList<Pictures>();
        Pictures p=new Pictures();
        Pictures p1=new Pictures();
        p.setPicture("http://pxm37tv32.bkt.clouddn.com/%E5%9C%BA%E5%9C%B01b.jpg");
        p1.setPicture("http://pxm37tv32.bkt.clouddn.com/%E5%9C%BA%E5%9C%B01c.jpg");
        pictures.add(p);
        pictures.add(p1);
        mgtest.setPicture(pictures);
        mtdao.saveTest(mgtest);
    }

    @GetMapping(value = "/test2")
    public remarks findTestByRegId() {
       remarks mgtest = mtdao.findTestByRegId(4);
        System.out.println("mgtest is " + mgtest);
        return mgtest;
    }

    @GetMapping(value = "/test3")
    public void updateTest() {
       remarks mgtest = new remarks();
        mgtest.setId(11);

        mtdao.updateTest(mgtest);
    }

    @GetMapping(value = "/test4")
    public void deleteTestById() {
        mtdao.deleteTestById(11);
    }
}


*/
