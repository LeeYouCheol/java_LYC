package kr.green.springpr.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
    public String getEmail(@Param("me_id")String id);
}
