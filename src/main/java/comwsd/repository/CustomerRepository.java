package comwsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comwsd.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
