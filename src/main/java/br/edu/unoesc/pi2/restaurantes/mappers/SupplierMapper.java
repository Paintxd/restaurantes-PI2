package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.SupplierDto;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "inCharge", target = "inCharge")
    @Mapping(source = "insertionDate", target = "insertionDate")
    @Mapping(source = "cnpj", target = "cnpj")
    @Mapping(source = "stateIdentifier", target = "stateIdentifier")
    @Mapping(source = "status", target = "status")
    SupplierDto supplierToSupplierDto(Supplier supplier);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "inCharge", target = "inCharge")
    @Mapping(source = "insertionDate", target = "insertionDate")
    @Mapping(source = "cnpj", target = "cnpj")
    @Mapping(source = "stateIdentifier", target = "stateIdentifier")
    @Mapping(source = "status", target = "status")
    Supplier supplierDtoToSupplier(SupplierDto supplierDto);

}
