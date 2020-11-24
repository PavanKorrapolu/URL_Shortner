package com.pavan.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedirectRepo extends JpaRepository<Redirect,Long> 
{
	Optional<Redirect> findByAlias(String alias);
	Boolean existsByAlias(String alias);
}
