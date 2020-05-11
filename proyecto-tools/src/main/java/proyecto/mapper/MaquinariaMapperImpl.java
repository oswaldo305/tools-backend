package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Estado;
import proyecto.domain.Maquinaria;
import proyecto.domain.Maquinaria;
import proyecto.domain.Sucursal;
import proyecto.dto.MaquinariaDTO;
import proyecto.dto.MaquinariaDTO;
import proyecto.servicio.EmpleadoService;
import proyecto.servicio.EstadoService;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class MaquinariaMapperImpl implements MaquinariaMapper {

	@Autowired
	SucursalService sucursalService;
	
	@Autowired
	EstadoService estadoService;
	
	@Override
	@Transactional(readOnly = true)
	public MaquinariaDTO maquinariaToMaquinariaDTO(Maquinaria maquinaria) throws Exception {
		try {
            MaquinariaDTO maquinariaDTO = new MaquinariaDTO();

            maquinariaDTO.setIdMaquinaria(maquinaria.getIdMaquinaria());
           
            maquinariaDTO.setNombreMaquina((maquinaria.getNombreMaquina() !=null)
            		? maquinaria.getNombreMaquina() : null);	
            
            maquinariaDTO.setDetalle((maquinaria.getDetalle() !=null)
            		? maquinaria.getDetalle() : null);
            
            maquinariaDTO.setIdEstado((maquinaria.getEstado().getIdEstado() !=null)
            		? maquinaria.getEstado().getIdEstado() : null);

            maquinariaDTO.setIdSucursal((maquinaria.getSucursal().getIdSucursal() !=null)
            		? maquinaria.getSucursal().getIdSucursal() : null);

            
            
          

            return maquinariaDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Maquinaria maquinariaDTOToMaquinaria(MaquinariaDTO maquinariaDTO) throws Exception {
		try {
            Maquinaria maquinaria = new Maquinaria();

            maquinaria.setIdMaquinaria(maquinariaDTO.getIdMaquinaria());
           
            maquinaria.setNombreMaquina((maquinariaDTO.getNombreMaquina() !=null)
            		? maquinariaDTO.getNombreMaquina() : null);
            
            maquinaria.setDetalle((maquinariaDTO.getDetalle() !=null)
            		? maquinariaDTO.getDetalle() : null);
          
            Sucursal sucursal=new Sucursal();
            Estado estado =new Estado();
           
           
            if (maquinariaDTO.getIdSucursal() != null) {
                sucursal = sucursalService.findById(maquinariaDTO.getIdSucursal());
            }
            if (maquinariaDTO.getIdEstado() != null) {
                estado = estadoService.findById(maquinariaDTO.getIdEstado());
            }

            if (sucursal != null) {
                maquinaria.setSucursal(sucursal);
            }

            if (estado != null) {
                maquinaria.setEstado(estado);
            }
            return maquinaria;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<MaquinariaDTO> listMaquinariaToListMaquinariaDTO(List<Maquinaria> listMaquinaria) throws Exception {
		try {
            List<MaquinariaDTO> maquinariaDTOs = new ArrayList<MaquinariaDTO>();

            for (Maquinaria maquinaria : listMaquinaria) {
            	MaquinariaDTO maquinariaDTO = maquinariaToMaquinariaDTO(maquinaria);

                maquinariaDTOs.add(maquinariaDTO);
            }

            return maquinariaDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Maquinaria> listMaquinariaDTOToListMaquinaria(List<MaquinariaDTO> listMaquinariaDTO) throws Exception {
		try {
            List<Maquinaria> listMaquinaria = new ArrayList<Maquinaria>();

            for (MaquinariaDTO maquinariaDTO : listMaquinariaDTO) {
                Maquinaria maquinaria = maquinariaDTOToMaquinaria(maquinariaDTO);

                listMaquinaria.add(maquinaria);
            }

            return listMaquinaria;
        } catch (Exception e) {
            throw e;
        }
	}

}
