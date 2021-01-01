package com.JavaG.service.impl;

import com.JavaG.dao.ReportCardDao;
import com.JavaG.domain.Score;
import com.JavaG.domain.ReportCard;
import com.JavaG.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 邓育永
 * @date 2020/12/17 1:01
 */
@Service("reportCardService")
public class ReportCardServiceImpl implements ReportCardService {
    //引用类型的自动注入@Autowired
    @Autowired
    private ReportCardDao reportCardDao;

    @Override
    public ReportCard selectReportCard(ReportCard reportCard) {
        return reportCardDao.selectReportCard(reportCard);
    }

    @Override
    public int insertScore(Score score) {
        return reportCardDao.insertScore(score);
    }
}
