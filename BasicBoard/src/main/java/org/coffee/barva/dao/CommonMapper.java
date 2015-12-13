package org.coffee.barva.dao;

import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastIndex();
}
