package com.example.sample.dto.mapper;

import com.example.sample.dto.CustomerDTO;
import com.example.sample.entity.Customer;
import com.example.sample.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}