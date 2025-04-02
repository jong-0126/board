package com.example.board.dto.password;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UpdatePasswordRequestDto {

    private final String oldPassword;

    private final String newPassword;

    public UpdatePasswordRequestDto(String newPassword, String oldPassword) {
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
    }
}
