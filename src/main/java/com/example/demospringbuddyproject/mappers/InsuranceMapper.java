package com.example.demospringbuddyproject.mappers;

import com.example.demospringbuddyproject.dto.InsuranceDto;
import com.example.demospringbuddyproject.model.Insurance;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InsuranceMapper {
    Insurance insuranceDtoToInsurance(InsuranceDto insuranceDto);

    InsuranceDto insuranceToInsuranceDto(Insurance insurance);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Insurance updateInsuranceFromInsuranceDto(InsuranceDto insuranceDto, @MappingTarget Insurance insurance);
}
