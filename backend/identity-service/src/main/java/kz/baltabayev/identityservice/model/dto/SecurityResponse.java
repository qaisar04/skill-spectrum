package kz.baltabayev.identityservice.model.dto;

import kz.baltabayev.identityservice.model.entity.User;

public record SecurityResponse(User user,
                               String token) {
}
