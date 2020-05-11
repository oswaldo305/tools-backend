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

import proyecto.domain.Empleado;
import proyecto.domain.Estado;
import proyecto.domain.Reporte;
import proyecto.domain.Reporte;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.repository.ReporteRepository;
@Service
@Scope("singleton")
public class ReporteServiceImpl implements ReporteService {
private static final Logger log=LoggerFactory.getLogger(ReporteServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private ReporteRepository reporteRepository;
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private TipoDanoService tipoDanoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	

	public void validarReportes(Reporte reporte) throws Exception{
		try {
			Set<ConstraintViolation<Reporte>> constraintViolations = validator.validate(reporte);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Reporte> constraintViolation : constraintViolations) {
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
	public Reporte findById(Integer id) {
		return reporteRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Reporte reporte) throws Exception {
		if(reporte==null) {
			throw new Exception("Reporte es nulo");	
		}
		validarReportes(reporte);
		Sucursal sucursal=sucursalService.findById(reporte.getSucursal().getIdSucursal());
		Empleado empleado=empleadoService.findById(reporte.getEmpleado().getIdEmpleado());
		TipoDano tipoDano=tipoDanoService.findById(reporte.getTipoDano().getIdTipoDano());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		if(tipoDano==null) {
			throw new Exception("tipoDano es nulo");	
		}
		
		reporte.setSucursal(sucursal);
		reporte.setEmpleado(empleado);
		reporte.setTipoDano(tipoDano);
		reporteRepository.save(reporte);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Reporte reporte) throws Exception {
		if(reporte==null) {
			throw new Exception("Reporte es nulo");	
		}
		validarReportes(reporte);
		Sucursal sucursal=sucursalService.findById(reporte.getSucursal().getIdSucursal());
		Empleado empleado=empleadoService.findById(reporte.getEmpleado().getIdEmpleado());
		TipoDano tipoDano=tipoDanoService.findById(reporte.getTipoDano().getIdTipoDano());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		if(tipoDano==null) {
			throw new Exception("tipoDano es nulo");	
		}
		
		reporte.setSucursal(sucursal);
		reporte.setEmpleado(empleado);
		reporte.setTipoDano(tipoDano);
		reporteRepository.update(reporte);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Reporte reporte) throws Exception {
		if(reporte==null) {
			throw new Exception("Reporte es nulo");	
		}
		Reporte entityRemove=findById(reporte.getIdReporte());
		
		reporteRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Reporte> findAll() {
		return reporteRepository.findAll();
	}

}
