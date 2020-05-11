package proyecto.servicio;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Estado;
import proyecto.domain.Maquinaria;
import proyecto.domain.Maquinaria;
import proyecto.domain.Sucursal;
import proyecto.repository.MaquinariaRepository;

@Service
@Scope("singleton")
public class MaquinariaServiceImpl implements MaquinariaService {

private static final Logger log=LoggerFactory.getLogger(MaquinariaServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private MaquinariaRepository maquinariaRepository;
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EstadoService estadoService;
	

	public void validarMaquinarias(Maquinaria maquinaria) throws Exception{
		try {
			Set<ConstraintViolation<Maquinaria>> constraintViolations = validator.validate(maquinaria);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Maquinaria> constraintViolation : constraintViolations) {
					throw new Exception(constraintViolation.getPropertyPath().toString()+" "+constraintViolation.getMessage());
					
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Maquinaria findById(Integer id) {
		return maquinariaRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Maquinaria maquinaria) throws Exception {
		if(maquinaria==null) {
			throw new Exception("Maquinaria es nulo");	
		}
		validarMaquinarias(maquinaria);
		Sucursal sucursal=sucursalService.findById(maquinaria.getSucursal().getIdSucursal());
		Estado estado=estadoService.findById(maquinaria.getEstado().getIdEstado());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		if(estado==null) {
			throw new Exception("estado es nulo");	
		}
		
		maquinaria.setSucursal(sucursal);
		maquinaria.setEstado(estado);
		maquinariaRepository.save(maquinaria);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Maquinaria maquinaria) throws Exception {
		if(maquinaria==null) {
			throw new Exception("Maquinaria es nulo");	
		}
		validarMaquinarias(maquinaria);
		Sucursal sucursal=sucursalService.findById(maquinaria.getSucursal().getIdSucursal());
		Estado estado=estadoService.findById(maquinaria.getEstado().getIdEstado());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		if(estado==null) {
			throw new Exception("estado es nulo");	
		}
		
		maquinaria.setSucursal(sucursal);
		maquinaria.setEstado(estado);
		maquinariaRepository.update(maquinaria);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Maquinaria maquinaria) throws Exception {
		if(maquinaria==null) {
			throw new Exception("Maquinaria es nulo");	
		}
		Maquinaria entityRemove=findById(maquinaria.getIdMaquinaria());
		
		maquinariaRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Maquinaria> findAll() {
		return maquinariaRepository.findAll();
	}

}
