package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Maquinaria;
import proyecto.domain.Maquinaria;
@Repository
@Scope("singleton")
public class MaquinariaImpl implements MaquinariaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Maquinaria findById(Integer id) {
		return entityManager.find(Maquinaria.class, id);
	}

	@Override
	public void save(Maquinaria maquinaria) {
		entityManager.persist(maquinaria);
		
		

	}

	@Override
	public void update(Maquinaria maquinaria) {
		entityManager.merge(maquinaria);

	}

	@Override
	public void delete(Maquinaria maquinaria) {
		entityManager.remove(maquinaria);

	}

	@Override
	public List<Maquinaria> findAll() {
		String jpql = "SELECT art FROM Maquinaria art";
		return entityManager.createQuery(jpql).getResultList();
	}
}
