package proyecto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import proyecto.domain.Usuario;
import proyecto.domain.Usuario;
@Repository
@Scope("singleton")
public class UsuarioImpl implements UsuarioRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Usuario findById(String id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);
		
		

	}

	@Override
	public void update(Usuario usuario) {
		entityManager.merge(usuario);

	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);

	}

	@Override
	public List<Usuario> findAll() {
		String jpql = "SELECT art FROM Usuario art";
		return entityManager.createQuery(jpql).getResultList();
	}

}
