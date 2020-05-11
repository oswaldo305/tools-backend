package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Reporte;
import proyecto.domain.Reporte;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.dto.ReporteDTO;
import proyecto.dto.ReporteDTO;
import proyecto.servicio.EmpleadoService;
import proyecto.servicio.SucursalService;
import proyecto.servicio.TipoDanoService;
@Component
@Scope("singleton")
public class ReporteMapperImpl implements ReporteMapper {

	@Autowired
	SucursalService sucursalService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	TipoDanoService tipoDanoService;
	
	
	@Override
	@Transactional(readOnly = true)
	public ReporteDTO reporteToReporteDTO(Reporte reporte) throws Exception {
		try {
            ReporteDTO reporteDTO = new ReporteDTO();

            reporteDTO.setIdReporte(reporte.getIdReporte());
            
            
            
            reporteDTO.setFechaCita((reporte.getFechaCita() != null)
            		? reporte.getFechaCita() : null);
            
            reporteDTO.setFechaReporte((reporte.getFechaReporte() !=null)
            		? reporte.getFechaReporte() : null);
            
           
            reporteDTO.setIdTipoDano((reporte.getTipoDano().getIdTipoDano() !=null)
            		? reporte.getTipoDano().getIdTipoDano() : null);
            reporteDTO.setIdEmpleado((reporte.getEmpleado().getIdEmpleado() !=null)
            		? reporte.getEmpleado().getIdEmpleado() : null);

            reporteDTO.setIdSucursal((reporte.getSucursal().getIdSucursal() !=null)
            		? reporte.getSucursal().getIdSucursal() : null);

            
            
          

            return reporteDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Reporte reporteDTOToReporte(ReporteDTO reporteDTO) throws Exception {
		try {
            Reporte reporte = new Reporte();

            reporte.setIdReporte(reporteDTO.getIdReporte());

            reporte.setFechaCita((reporte.getFechaCita() != null)
            		? reporte.getFechaCita() : null);
            
            reporte.setFechaReporte((reporteDTO.getFechaReporte() !=null)
            		? reporteDTO.getFechaReporte() : null);
          
            Sucursal sucursal=new Sucursal();
            Empleado empleado =new Empleado();
            TipoDano tipoDano =new TipoDano();
           
           
            if (reporteDTO.getIdSucursal() != null) {
                sucursal = sucursalService.findById(reporteDTO.getIdSucursal());
            }
            if (reporteDTO.getIdEmpleado() != null) {
                empleado = empleadoService.findById(reporteDTO.getIdEmpleado());
            }
            if (reporteDTO.getIdTipoDano() != null) {
                tipoDano = tipoDanoService.findById(reporteDTO.getIdTipoDano());
            }

            if (sucursal != null) {
                reporte.setSucursal(sucursal);
            }
            if (tipoDano != null) {
                reporte.setTipoDano(tipoDano);
            }

            if (empleado != null) {
                reporte.setEmpleado(empleado);
            }
            return reporte;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReporteDTO> listReporteToListReporteDTO(List<Reporte> listReporte) throws Exception {
		try {
            List<ReporteDTO> reporteDTOs = new ArrayList<ReporteDTO>();

            for (Reporte reporte : listReporte) {
            	ReporteDTO reporteDTO = reporteToReporteDTO(reporte);

                reporteDTOs.add(reporteDTO);
            }

            return reporteDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reporte> listReporteDTOToListReporte(List<ReporteDTO> listReporteDTO) throws Exception {
		try {
            List<Reporte> listReporte = new ArrayList<Reporte>();

            for (ReporteDTO reporteDTO : listReporteDTO) {
                Reporte reporte = reporteDTOToReporte(reporteDTO);

                listReporte.add(reporte);
            }

            return listReporte;
        } catch (Exception e) {
            throw e;
        }
	}
}


