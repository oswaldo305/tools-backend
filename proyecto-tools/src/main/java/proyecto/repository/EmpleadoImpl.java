package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
@Repository
@Scope("singleton")
public class EmpleadoImpl implements EmpleadoRespository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Empleado findById(Integer id) {
		return entityManager.find(Empleado.class, id);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Empleado empleado) {
		entityManager.persist(empleado);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Empleado empleado) {
		entityManager.merge(empleado);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Empleado empleado) {
		entityManager.remove(empleado);

	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Empleado> findAll() {
		String jpql = "SELECT emp FROM Empleado emp";
		return entityManager.createQuery(jpql).getResultList();
	}

}
