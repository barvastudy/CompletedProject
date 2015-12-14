package org.coffee.barva.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.coffee.barva.domain.UserVO;
public interface UserMapper {
	@Select("<script> SELECT seq,user_id,user_pw FROM user_info <where><if test=\" seq!=null and seq!=0\"> and seq=#{seq} </if><if test=\"userId!=null and userId != '' \"> and user_id like #{userId}</if><if test=\"userPw!=null and userPw!='' \"> and user_pw like #{userPw}</if></where></script>")
	@ResultMap("userResultMap")
	public List<UserVO> getUser(UserVO user);
	@Insert("INSERT INTO user_info(user_id,user_pw) VALUES (#{userId},#{userPw})")
	public int inserUser(UserVO user);
	@Delete("DELETE FROM user_info WHERE user_id=#{userId}")
	public int deleteUser(UserVO user);
	@Update("UPDATE user_info SET user_id=#{userId},user_pw=#{userPw} WHERE seq=#{seq}")
	public int UpdateUser(UserVO user);
}