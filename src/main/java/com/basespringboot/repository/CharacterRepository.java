package com.basespringboot.repository;

import com.basespringboot.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    
}

