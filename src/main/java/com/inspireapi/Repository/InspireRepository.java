package com.inspireapi.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspireapi.Model.InspireSession;


public interface InspireRepository extends JpaRepository<InspireSession, UUID> {

}
