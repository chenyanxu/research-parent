package com.kalix.research.competition.biz;

import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.research.competition.api.dao.ICompetitionInfoBeanDao;
import com.kalix.research.competition.api.query.CompetitionChartDTO;
import com.kalix.research.competition.entities.CompetitionInfoBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/18.
 */
public class CompetitionStatistics {
    private static String statisticsType = "0";//默认按时间段统计
    private static String statistics_year = "";//按特定年的月份段统计
    private static String statistics_startYear = "";//按开始年进行统计
    private static String statistics_endYear = "";//按结束年统计

    /**
     * @param jsonStr json格式的条件，如果条件为大于的，那么前台需要传入"参数名：begin:gt"
     */
    public static String getStatisticsType(String jsonStr) {
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")) {
                if (entry.getKey().equals("statistics_type")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        statisticsType = entry.getValue();
                    }
                }
                if (entry.getKey().equals("statistics_year")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        statistics_year = entry.getValue();
                        if (StringUtils.isEmpty(statistics_year)) {
                            statistics_year = String.valueOf(new Date().getYear());
                        }
                    }
                }
                if (entry.getKey().equals("statistics_startYear")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        statistics_startYear = entry.getValue();
                        if (StringUtils.isEmpty(statistics_startYear)) {
                            statistics_startYear = String.valueOf(new Date().getYear());
                        }
                    }
                }
                if (entry.getKey().equals("statistics_endYear")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        statistics_endYear = entry.getValue();
                        if (StringUtils.isEmpty(statistics_endYear)) {
                            statistics_endYear = String.valueOf(new Date().getYear());
                        }
                    }
                }
            }
        }

        return statisticsType;
    }

    /**
     * @param jsonStr json格式的条件，如果条件为大于的，那么前台需要传入"参数名：begin:gt"
     */
    public static String getSqlWhere(String jsonStr) {
        String result = "";
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")) {
                if (entry.getKey().contains(":begin:gt")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        result = result + " and " + entry.getKey().split(":")[0] + " >= '" + entry.getValue() + "'";
                    }
                } else if (entry.getKey().contains(":begin:lt")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        result = result + " and " + entry.getKey().split(":")[0] + " <= '" + entry.getValue() + "'";
                    }
                } else if (entry.getKey().contains(":end:gt")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        result = result + " and " + entry.getKey().split(":")[0] + " >= '" + entry.getValue() + "'";
                    }
                } else if (entry.getKey().contains(":end:lt")) {
                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                        result = result + " and " + entry.getKey().split(":")[0] + " <= '" + entry.getValue() + "'";
                    }
                } else if (entry.getKey().equals("statisticsType")) {
                    continue;
                } else {
                    result = result + " and " + entry.getKey() + " = " + entry.getValue();
                }
            }
        }

        return result;
    }

    // 按照时间段进行统计
    public static List<CompetitionChartDTO> statisticsByBetweenDate(ICompetitionInfoBeanDao dao, String jsonStr) {
        // 获取统计的条件
        String condition = CompetitionStatistics.getSqlWhere(jsonStr);

        // 根据条件统计每种展赛类别的展赛信息数目
        String statistics_sql = "select (select label from research_dict d where d.value = r.type and d.type = '展赛类别' ) as label,count(*) as cnt from " + dao.getTableName() + " r where 1=1 " + condition + " group by type";
        List<CompetitionChartDTO> tempList = dao.findByNativeSql(statistics_sql, CompetitionChartDTO.class, null);

        int total = 0;
        for (int i = 0; i < tempList.size(); i++) {
            total += tempList.get(i).getCnt();
        }

        for (int j = 0; j < tempList.size(); j++) {
            tempList.get(j).setPercentage(tempList.get(j).getCnt() / (float) total);
        }

        return tempList;
    }

    /**
     * --按月分组统计
     * select     to_char(to_timestamp(start_time_of_date::bigint), 'YYYY-MM') as d ,  count(cdr_id)  as  total_call,sum (call_duration::integer /60 +1)   as  total_duration  from  cdr
     * where  to_timestamp(start_time_of_date::bigint)  between  '2010-01-01'   and    '2010-12-12'   group by d
     */
    public static List<CompetitionChartDTO> statisticsByMonth(ICompetitionInfoBeanDao dao, String jsonStr) {
        String statistics_sql = "select to_char(compstarttime, 'YYYY-MM') as label, count(id)  as cnt from  research_competition_info where to_char(compstarttime,'YYYY-MM-DD') between '" + statistics_year + "-01-01' and '" + statistics_year + "-12-12' group by label";
        List<CompetitionChartDTO> tempList = dao.findByNativeSql(statistics_sql, CompetitionChartDTO.class, null);
        return tempList;
    }

    //按照季度进行统计
    public static List<CompetitionChartDTO> statisticsByQuarter(ICompetitionInfoBeanDao dao, String jsonStr) {
        List<CompetitionChartDTO> tempList = new ArrayList<>();
        //首先获取各个月份的
        List<CompetitionChartDTO> monthList = statisticsByMonth(dao, jsonStr);

        int firstQuarter = 0, secondQuarter = 0, thirdQuarter = 0, forthQuarter = 0;
        if (monthList != null) {
            CompetitionChartDTO tempDTO = new CompetitionChartDTO();
            for (int i = 0; i < monthList.size(); i++) {
                if (monthList.get(i).getLabel().contains("-01") || monthList.get(i).getLabel().contains("-02") || monthList.get(i).getLabel().contains("-03")) {
                    firstQuarter += monthList.get(i).getCnt();
                }
                if (monthList.get(i).getLabel().contains("-04") || monthList.get(i).getLabel().contains("-05") || monthList.get(i).getLabel().contains("-06")) {
                    secondQuarter += monthList.get(i).getCnt();
                }
                if (monthList.get(i).getLabel().contains("-07") || monthList.get(i).getLabel().contains("-08") || monthList.get(i).getLabel().contains("-09")) {
                    thirdQuarter += monthList.get(i).getCnt();
                }
                if (monthList.get(i).getLabel().contains("-10") || monthList.get(i).getLabel().contains("-11") || monthList.get(i).getLabel().contains("-12")) {
                    forthQuarter += monthList.get(i).getCnt();
                }
            }

            tempDTO.setLabel("第1季度");
            tempDTO.setCnt(firstQuarter);
            tempList.add(tempDTO);

            tempDTO.setLabel("第2季度");
            tempDTO.setCnt(secondQuarter);
            tempList.add(tempDTO);

            tempDTO.setLabel("第3季度");
            tempDTO.setCnt(thirdQuarter);
            tempList.add(tempDTO);

            tempDTO.setLabel("第4季度");
            tempDTO.setCnt(forthQuarter);
            tempList.add(tempDTO);
        }

        return tempList;
    }

    /**
     * --按年分组查看
     * select     to_char(to_timestamp(start_time_of_date::bigint), 'YYYY') as d ,  count(cdr_id)  as  total_call,sum (call_duration::integer /60 +1)   as  total_duration  from  cdr
     * where  to_timestamp(start_time_of_date::bigint)  between  '2010-01-01'   and    '2010-12-12'   group by d
     */
    public static List<CompetitionChartDTO> statisticsByYear(ICompetitionInfoBeanDao dao, String jsonStr) {
        String statistics_sql = "select to_char(compstarttime, 'YYYY-MM') as label, count(id)  as cnt from  research_competition_info where to_char(compstarttime,'YYYY-MM-DD') between '" + (statistics_startYear.equals("") == true ? "2017" : statistics_startYear) + "-01-01' and '" + (statistics_endYear.equals("") == true ? "2020" : statistics_endYear) + "-12-12' group by label";
        List<CompetitionChartDTO> tempList = dao.findByNativeSql(statistics_sql, CompetitionChartDTO.class, null);
        return tempList;
    }
}


/**
 * --按小时分组查看
 * select     to_char(to_timestamp(start_time_of_date::bigint), 'YYYY-MM-DD  HH24 ' ) as d ,  count(cdr_id)  as  total_call,sum (call_duration::integer /60 +1)   as  total_duration  from  cdr
 * where  to_timestamp(start_time_of_date::bigint)  between  '2010-01-01'   and    '2010-12-12'   group by d  order  by  d
 * <p/>
 * --按秒分组查看
 * select     to_char(to_timestamp(start_time_of_date::bigint), 'YYYY-MM-DD  HH24:MI:SS ' ) as d ,  count(cdr_id)  as  total_call,sum (call_duration::integer /60 +1)   as  total_duration  from  cdr
 * where  to_timestamp(start_time_of_date::bigint)  between  '2010-01-01'   and    '2010-12-12'   group by d
 */