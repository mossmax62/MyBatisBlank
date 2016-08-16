package cl.max.mybatis.services;

import java.util.List;

import org.apache.ibatis.exceptions.IbatisException;

import cl.max.mybatis.domain.Actor;

public interface ActorMapper {
	public List<Actor> list() throws IbatisException;

}
