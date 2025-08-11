package com.example.Maintenance.Request.System.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Maintenance.Request.System.models.Complaints;
import com.example.Maintenance.Request.System.repositories.ComplaintRepo;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepo compRepo;

    public void insertComplaint(Complaints comp) {
        compRepo.save(comp);
    }
    public List<Complaints> getComplaint() {
        List<Complaints> compList =  compRepo.findAll();
        compList.sort(new Comparator<Complaints>() {
            @Override
            public int compare(Complaints c1, Complaints c2) {
                return -(c1.getUpdatedTime().compareTo(c2.getUpdatedTime()));
            }
        });
        return compList;
    }

    public List<Complaints> filterComplaints(String priority, String status) {
        return compRepo.findByPriorityAndStatus(priority, status);
    }

    public void deleteComplaint(int id) {
        compRepo.deleteById(id);
    }
    public void updateComplaint(int id, String title, String description) {
        compRepo.updateComplaintById(id, title, description);
    }

}
