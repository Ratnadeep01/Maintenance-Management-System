package com.example.Maintenance.Request.System.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.Maintenance.Request.System.models.Complaints;
import com.example.Maintenance.Request.System.services.ComplaintService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@CrossOrigin
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService compService;  

    @PostMapping("/post")
    public ResponseEntity<String> postComplaint(@RequestBody Complaints comp) {
        try {
            compService.insertComplaint(comp);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
        }catch(DataAccessException dae) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Server Error: " + dae.getMessage());

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create complaint: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getMethodName() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(compService.getComplaint());

        }catch(DataAccessException dae) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Server Error: " + dae.getMessage());

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to fetch complaints " + e.getMessage());
        }
   }

    @GetMapping("/filter")
    public ResponseEntity<Object> filterComplaints(
            @RequestParam(required = false) 
            String priority,
            @RequestParam(required = false) 
            String status) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(compService.filterComplaints(priority, status));
        } catch (DataAccessException dae) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Database Server Error: " + dae.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Failed to filter complaints: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDetails(@PathVariable int id, @RequestParam String title, @RequestParam String description) {
         
         try {
                compService.updateComplaint(id, title, description);
                return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
          }catch(DataAccessException dae) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Server Error: " + dae.getMessage());
    
          }catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete complaint: " + e.getMessage());
          }
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable int id) {
          try {
                compService.deleteComplaint(id);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
          }catch(DataAccessException dae) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Server Error: " + dae.getMessage());
    
          }catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete complaint: " + e.getMessage());
          }
     }
    

    


}
