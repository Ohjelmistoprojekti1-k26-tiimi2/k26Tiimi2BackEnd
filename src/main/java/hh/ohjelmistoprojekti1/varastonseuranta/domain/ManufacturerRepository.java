package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

    List<Product> findByName(String manufacturer);

}
