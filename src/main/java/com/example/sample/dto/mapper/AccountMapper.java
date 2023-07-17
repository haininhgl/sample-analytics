package com.example.sample.dto.mapper;

import com.example.sample.dto.AccountDTO;
import com.example.sample.entity.Account;
import com.example.sample.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {
}