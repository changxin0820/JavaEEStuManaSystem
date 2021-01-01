package com.JavaG.dao;

import com.JavaG.domain.ReportCard;
import com.JavaG.domain.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @author 邓育永
 * @date 2020/12/17 0:55
 */
public interface ReportCardDao {


    // 查询所有成绩
    public ReportCard selectReportCard(ReportCard reportCard);

    // 添加成绩
    public int insertScore(Score score);

}
