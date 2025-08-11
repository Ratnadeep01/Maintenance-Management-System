package com.example.Maintenance.Request.System.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Maintenance.Request.System.models.Complaints;

import jakarta.transaction.Transactional;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaints, Integer>{

     @Query(value = """
        SELECT * FROM complaints 
        WHERE (:priority IS NULL OR priority = :priority)
          AND (:status IS NULL OR status = :status)
        ORDER BY updated_time DESC
        """, nativeQuery = true)
    List<Complaints> findByPriorityAndStatus(
        @Param("priority") 
        String priority,
        @Param("status") 
        String status
    );


    @Modifying
    @Transactional
    @Query(
        value = "UPDATE complaints SET title = :title, description = :description, updated_at = CURRENT_DATE, updated_time = CURRENT_TIME WHERE id = :id", 
        nativeQuery = true)
    void updateComplaintById(
        @Param("id")
        int id, 
        @Param("title")
        String title, 
        @Param("description")
        String description
        );

}
