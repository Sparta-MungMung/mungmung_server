package com.sparta.mungmung.service;

import com.sparta.mungmung.domain.User;
import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.dto.SignupRequestDto;
import com.sparta.mungmung.dto.UserRequestDto;
import com.sparta.mungmung.exception.ApiRequestException;
import com.sparta.mungmung.repository.ReservationRepository;
import com.sparta.mungmung.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public void registerUser(SignupRequestDto requestDto){
        String username = requestDto.getUserName();

        Optional<User> found = userRepository.findByUserName(username);
        if (found.isPresent()) {
            throw new ApiRequestException("중복된 사용자 ID 가 존재합니다.");
        }

        String password = requestDto.getPassword();
        String passwordConfirm = requestDto.getConfirmPassword();

        if (!password.isEmpty() && !passwordConfirm.isEmpty()) {
            if (password.length() >= 6 && password.length() <= 20) {
                if (!password.equals(passwordConfirm)) {
                    throw new ApiRequestException("패스워드가 일치하지 않습니다!");
                }
            } else {
                throw new ApiRequestException("비밀번호는  6~20자리를 사용해야 합니다.");
            }
        } else {
            throw new ApiRequestException("패스워드를 입력해 주세요.");
        }
        String dogName = requestDto.getDogName();

        User user = new User(username,password,dogName);
        userRepository.save(user);


    }

    @Transactional
    public void setImage(UserRequestDto userRequestDto, User user){
        User user1 = userRepository.findById(user.getUserId()).orElseThrow(
                ()-> new NullPointerException("NO ID")
        );
        user1.update(userRequestDto);
    }

}
