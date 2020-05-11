package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Reporte;
import proyecto.domain.Reporte;
@Repository
@Scope("singleton")
public class ReporteImpl implements ReporteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Reporte findById(Integer id) {
		return entityManager.find(Reporte.class, id);
	}

	@Override
	public void save(Reporte reporte) {
		entityManager.persist(reporte);
		
		

	}

	@Override
	public void update(Reporte reporte) {
		entityManager.merge(reporte);

	}

	@Override
	public void delete(Reporte reporte) {
		entityManager.remove(reporte);

	}

	@Override
	public List<Reporte> findAll() {
		String jpql = "SELECT art FROM Reporte art";
		return entityManager.createQuery(jpql).getResultList();
	}
}
