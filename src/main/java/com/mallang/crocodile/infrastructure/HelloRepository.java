package com.mallang.crocodile.infrastructure;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloRepository {
	Integer countAll();
}
