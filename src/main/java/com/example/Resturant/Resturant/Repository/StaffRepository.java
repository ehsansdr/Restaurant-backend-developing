package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    /** be careful if you can not use this type:
     * @Query("select s.last_name from Staff s where s.staff_id =  :staffId")
     * use this type
     * @Query(
     *             value = "select first_name from Staff s where staff_id = ?1",
     *             nativeQuery = true
     *     )
     *
     *     the value = "(use mysql statement , not jpql statement)"
     *
     *     */
    @Query(
            value = "select first_name from Staff s where staff_id = ?1",
            nativeQuery = true
    )
    String getFirstNameById(int staffId);


    //String getFirstNameById(int staffId);
    @Query(
            value = "select last_name from Staff s where staff_id = ?1",
            nativeQuery = true
    )
    String getLastNameById(@Param("staffId")int id);

}
