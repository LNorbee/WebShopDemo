package comwsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comwsd.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
