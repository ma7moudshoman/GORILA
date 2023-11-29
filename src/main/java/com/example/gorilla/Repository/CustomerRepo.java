package com.example.gorilla.Repository;

import com.example.gorilla.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    @Query(
            value = "SELECT * from Customer  where Customer.Date BETWEEN :stat_date AND :end_date",
            nativeQuery = true)
    public List<Customer>getCustomerByDate(@Param("stat_date")String statDate,@Param("end_date") String endDate);
    

}
