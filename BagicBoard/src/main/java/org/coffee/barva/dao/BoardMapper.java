package org.coffee.barva.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.coffee.barva.domain.BoardVO;

public interface BoardMapper {
	@Select("<script>SELECT seq,content,title,user from board <where><if test=\"board!=null\"><if test=\" board.seq != null and board.seq != 0 \"> and seq = #{board.seq} </if><if test=\" board.content != null and board.content != '' \"> and content like CONCAT('%',#{board.content},'%') </if><if test=\" board.title != null and board.title != '' \"> and title like CONCAT('%',#{board.title},'%') </if><if test=\" board.user != null and board.user!=0 \"> and user = #{board.user} </if></if></where> LIMIT #{startNum},#{pageCount}</script>")
	@ResultMap("boardResultMap")
	public List<BoardVO> getBoard(Map<String,Object> map);

	@Select("SELECT seq,content,title,user FROM board WHERE seq=#{val}")
	@ResultMap("boardResultMap")
	public BoardVO getBoardSeq(int seq);


	@Select("<script>SELECT count(*) from board<where><if test=\" seq != null and seq != 0 \"> and seq = #{seq} </if><if test=\" content != null and content != '' \"> and content like  CONCAT('%',#{content},'%') </if><if test=\" title != null and title != '' \"> and title like  CONCAT('%',#{title},'%') </if><if test=\" user != null and user!=0 \"> and user = #{user} </if></where></script>")
	public int getTotalCount(BoardVO board);

	@Insert("INSERT INTO board(content,title,user) VALUES (#{content},#{title},#{user})")
	@Options(useGeneratedKeys = true, keyProperty="seq")
	public int insertBoard(BoardVO boardVO);


	@Update("<script> UPDATE board <set> content=#{content},title=#{title} </set> WHERE seq=#{seq}</script>")
	public int updateBoard(BoardVO boardVO);

	@Delete("DELETE FROM board WHERE seq=#{val}")
	public int deleteBoard(int seq);


}
