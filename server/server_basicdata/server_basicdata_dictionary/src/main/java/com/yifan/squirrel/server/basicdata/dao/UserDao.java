package com.yifan.squirrel.server.basicdata.dao;



import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by yifan on 2017/5/8.
 */
@Repository
public interface UserDao {

    @Select("SELECT * FROM tbl_user")
    List<UserDto> getUserList();

    @Select("SELECT * FROM tbl_user WHERE userId = #{userId}")
    UserDto getUserById(@Param("userId") String userId);

    @Update("UPDATE tbl_user SET sex = #{sex} WHERE userId = #{userId}")
    void updateUserEmailById(@Param("userId") String userId, @Param("sex") String sex);

    @Delete("DELETE FROM tbl_user WHERE userId = #{userId}")
    void deleteUserById(@Param("userId") String userId);

    void insertUser(UserDto user);
}
