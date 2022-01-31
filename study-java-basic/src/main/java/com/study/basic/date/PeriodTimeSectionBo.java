package com.study.basic.date;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-09-03 11:07
 *@describe:
 *@version:
 */
@Data
@Accessors(chain = true)
public class PeriodTimeSectionBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date periodStartTime;

    private Date periodEndTime;

    private Integer timeType;

    private Long secondsInterval;


}
