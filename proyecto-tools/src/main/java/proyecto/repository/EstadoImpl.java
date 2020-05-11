package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Estado;
@Repository
@Scope("singleton")
public class EstadoImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estado findById(Integer id) {
		return entityManager.find(Estado.class, id);
	}

	@Override
	public void save(Estado estado) {
		entityManager.persist(estado);
		
		

	}

	@Override
	public void update(Estado estado) {
		entityManager.merge(estado);

	}

	@Override
	public void delete(Estado estado) {
		entityManager.remove(estado);

	}

	@Override
	public List<Estado> findAll() {
		String jpql = "SELECT art FROM Estado art";
		return entityManager.createQuery(jpql).getResultList();
	}

}
