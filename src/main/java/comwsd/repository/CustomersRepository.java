package comwsd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import comwsd.entities.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Integer> {

	List<Customers> findAll();
}
