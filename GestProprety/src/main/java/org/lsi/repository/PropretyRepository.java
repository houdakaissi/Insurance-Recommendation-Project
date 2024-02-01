
package org.lsi.repository;
import java.util.List;
import java.util.Optional;

import net.bytebuddy.dynamic.DynamicType;
import org.lsi.entities.Proprety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropretyRepository extends JpaRepository<Proprety, String> {

	Optional<Proprety> findById(Long id);


	List<Proprety> findByOwnerId(Long id);

}
