package com.inwaiders.plames.modules.management.dao.manager;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inwaiders.plames.modules.management.domain.manager.impl.ManagerImpl;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerImpl, Long>{

	@QueryHints({
		@QueryHint(name = "org.hibernate.cacheable", value = "true")
	})
	@Query("SELECT m FROM Manager m WHERE m.login = :login AND m.deleted != true")
	public ManagerImpl getByLogin(@Param(value = "login") String login);
	
	@QueryHints({
		@QueryHint(name = "org.hibernate.cacheable", value = "true")
	})
	@Override
	@Query("SELECT m FROM Manager m WHERE m.id = :id AND m.deleted != true")
	public ManagerImpl getOne(@Param(value = "id") Long id);
	
	@Override
	@Query("SELECT m FROM Manager m WHERE m.deleted != true")
	public List<ManagerImpl> findAll();
	
	@Override
	@Query("SELECT COUNT(*) FROM Manager m WHERE m.deleted != true")
	public long count();
}
