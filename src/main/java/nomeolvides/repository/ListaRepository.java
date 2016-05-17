package nomeolvides.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import nomeolvides.entities.Lista;

@Component
public interface ListaRepository extends JpaRepository<Lista, Long> {

	List<Lista> findByUser(String user);


}
