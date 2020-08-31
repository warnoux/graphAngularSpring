package com.warnoux.graph.repository;

import com.warnoux.graph.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<Element, Integer> {
}
