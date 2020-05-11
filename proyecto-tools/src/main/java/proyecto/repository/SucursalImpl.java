package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Sucursal;
import proyecto.domain.Sucursal;
@Repository
@Scope("singleton")
public class SucursalImpl implements SucursalRespository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Sucursal findById(Integer id) {
		return entityManager.find(Sucursal.class, id);
	}

	@Override
	public void save(Sucursal sucursal) {
		entityManager.persist(sucursal);
		
		

	}

	@Override
	public void update(Sucursal sucursal) {
		entityManager.merge(sucursal);

	}

	@Override
	public void delete(Sucursal sucursal) {
		entityManager.remove(sucursal);

	}

	@Override
	public List<Sucursal> findAll() {
		String jpql = "SELECT art FROM Sucursal art";
		return entityManager.createQuery(jpql).getResultList();
	}

}
