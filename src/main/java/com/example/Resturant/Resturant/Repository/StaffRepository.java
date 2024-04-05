package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

}
