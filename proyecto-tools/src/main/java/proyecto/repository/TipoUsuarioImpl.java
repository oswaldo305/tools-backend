package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.TipoUsuario;
import proyecto.domain.TipoUsuario;
@Repository
@Scope("singleton")
public class TipoUsuarioImpl implements TipoUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public TipoUsuario findById(Integer id) {
		return entityManager.find(TipoUsuario.class, id);
	}

	@Override
	public void save(TipoUsuario tipoUsuario) {
		entityManager.persist(tipoUsuario);
		
		

	}

	@Override
	public void update(TipoUsuario tipoUsuario) {
		entityManager.merge(tipoUsuario);

	}

	@Override
	public void delete(TipoUsuario tipoUsuario) {
		entityManager.remove(tipoUsuario);

	}

	@Override
	public List<TipoUsuario> findAll() {
		String jpql = "SELECT art FROM TipoUsuario art";
		return entityManager.createQuery(jpql).getResultList();
	}
}
