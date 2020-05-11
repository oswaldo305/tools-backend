package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Mantenimiento;
import proyecto.domain.Mantenimiento;
@Repository
@Scope("singleton")
public class MantenimientoImpl implements MantenimientoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Mantenimiento findById(Integer id) {
		return entityManager.find(Mantenimiento.class, id);
	}

	@Override
	public void save(Mantenimiento mantenimiento) {
		entityManager.persist(mantenimiento);
		
		

	}

	@Override
	public void update(Mantenimiento mantenimiento) {
		entityManager.merge(mantenimiento);

	}

	@Override
	public void delete(Mantenimiento mantenimiento) {
		entityManager.remove(mantenimiento);

	}

	@Override
	public List<Mantenimiento> findAll() {
		String jpql = "SELECT art FROM Mantenimiento art";
		return entityManager.createQuery(jpql).getResultList();
	}

}
