package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.SupplierViewDto;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import br.edu.unoesc.pi2.restaurantes.models.SupplierStatusEnum;
import br.edu.unoesc.pi2.restaurantes.repositorys.SupplierRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findSupplier(Integer id) throws NotFoundException {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier id: " + id + " not found"));
    }

    public Supplier newSupplier(SupplierViewDto supplierDto) {
        var supplier = supplierDto.getSupplier();

        return supplierRepository.save(supplier);
    }

    public Supplier disableSupplier(Integer id) throws NotFoundException {
        var supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier id: " + id + " not found"));

        supplier.setStatus(SupplierStatusEnum.INACTIVE);

        return supplierRepository.save(supplier);
    }

}
