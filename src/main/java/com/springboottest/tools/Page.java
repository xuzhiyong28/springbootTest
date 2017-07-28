package com.springboottest.tools;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
public class Page {
    //一页显示的记录数
    private int numPerPage;
    //记录总数
    private int totalRows;
    //总页数
    private int totalPages;
    //当前页码
    private int currentPage;
    //起始行数
    private int startIndex;
    //结束行数
    private int lastIndex;
    //结果集存放List
    private List<Map<String, Object>> resultList;

    public Page(String sql, int currentPage, int numPerPage, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null)
            throw new IllegalArgumentException("jdbcTemplate is null");
        if (sql == null || "".equals(sql))
            throw new IllegalArgumentException("sql语句为空");
        //设置每页显示记录数
        setNumPerPage(numPerPage);
        //设置要显示的页数
        setCurrentPage(currentPage);
        StringBuffer totalSQL = new StringBuffer(" SELECT COUNT(*) FROM ( ");
        totalSQL.append(sql);
        totalSQL.append(" ) totalTable");
        setTotalRows(jdbcTemplate.queryForObject(totalSQL.toString(), Integer.class));
        //计算总页数
        setTotalPages();
        //计算起始行数
        setStartIndex();
        //计算结束行数
        setLastIndex();

        StringBuffer paginationSQL = new StringBuffer();
        paginationSQL.append(sql);
        paginationSQL.append(" limit " + startIndex + " , " + lastIndex);
        setResultList(jdbcTemplate.queryForList(paginationSQL.toString()));
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public List<Map<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map<String, Object>> resultList) {
        this.resultList = resultList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    //计算总页数
    public void setTotalPages() {
        if (totalRows % numPerPage == 0) {
            this.totalPages = totalRows / numPerPage;
        } else {
            this.totalPages = (totalRows / numPerPage) + 1;
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * numPerPage;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    //计算结束时候的索引
    public void setLastIndex() {
        if (totalRows < numPerPage) {
            this.lastIndex = totalRows;
        } else if ((totalRows % numPerPage == 0) || (totalRows % numPerPage != 0 && currentPage < totalPages)) {
            this.lastIndex = currentPage * numPerPage;
        } else if (totalRows % numPerPage != 0 && currentPage == totalPages) {//最后一页
            this.lastIndex = totalRows;
        }
    }
}
