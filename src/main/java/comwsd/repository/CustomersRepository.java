package comwsd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comwsd.entities.Customers;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer> {

	// SELECT * FROM customers
	List<Customers> findAll();
}
