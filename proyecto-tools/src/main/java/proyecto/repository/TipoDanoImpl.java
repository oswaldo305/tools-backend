package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.TipoDano;
import proyecto.domain.TipoDano;
@Repository
@Scope("singleton")
public class TipoDanoImpl implements TipoDanoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public TipoDano findById(Integer id) {
		return entityManager.find(TipoDano.class, id);
	}

	@Override
	public void save(TipoDano tipoDano) {
		entityManager.persist(tipoDano);
		
		

	}

	@Override
	public void update(TipoDano tipoDano) {
		entityManager.merge(tipoDano);

	}

	@Override
	public void delete(TipoDano tipoDano) {
		entityManager.remove(tipoDano);

	}

	@Override
	public List<TipoDano> findAll() {
		String jpql = "SELECT art FROM TipoDano art";
		return entityManager.createQuery(jpql).getResultList();
	}

}
