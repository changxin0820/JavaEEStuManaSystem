package com.JavaG.service;

import com.JavaG.domain.Score;
import com.JavaG.domain.ReportCard;

/**
 * @author 邓育永
 * @date 2020/12/17 0:59
 */
public interface ReportCardService {
    public ReportCard selectReportCard(ReportCard reportCard);
    public int insertScore(Score score);
}
