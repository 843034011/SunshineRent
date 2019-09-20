package com.elife.service.impl;

import com.elife.mapper.EvaluatePictureMapper;
import com.elife.pojo.EvaluatePicture;
import com.elife.service.EvaluatePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author byf
 */
@Service
public class EvaluatePictureServiceImpl implements EvaluatePictureService {

    @Autowired
    EvaluatePictureMapper evaluatePictureMapper;

    @Override
    public int insertEvaluatePicture(EvaluatePicture evaluatePicture) {
        int result = evaluatePictureMapper.insertEvaluatePicture(evaluatePicture);
        System.out.println("result = " + result);
        return result;
    }
}
