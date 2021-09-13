package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.SupplierDto;
import br.edu.unoesc.pi2.restaurantes.mappers.SupplierMapper;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import br.edu.unoesc.pi2.restaurantes.repositorys.SupplierRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Set<SupplierDto> findAllSuppliers() {
        var supplierMapper = SupplierMapper.INSTANCE;

        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::supplierToSupplierDto)
                .collect(Collectors.toSet());
    }

    public SupplierDto findSupplier(Integer id) throws NotFoundException {
        var supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier id: " + id + " not found"));
        var supplierMapper = SupplierMapper.INSTANCE;

        return supplierMapper.supplierToSupplierDto(supplier);
    }

    public Supplier newSupplier(SupplierDto supplierDto) {
        var supplierMapper = SupplierMapper.INSTANCE;

        var supplier = supplierMapper.supplierDtoToSupplier(supplierDto);

        return supplierRepository.save(supplier);
    }

}
