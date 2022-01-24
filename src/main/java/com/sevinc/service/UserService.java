package com.sevinc.service;

import com.sevinc.dto.UserDto;
import com.sevinc.entity.User;
import com.sevinc.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
