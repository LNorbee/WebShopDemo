package comwsd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comwsd.model.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {

	List<Products> findAll();
}
