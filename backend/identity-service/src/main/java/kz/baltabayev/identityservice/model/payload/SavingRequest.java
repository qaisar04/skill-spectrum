package kz.baltabayev.identityservice.model.payload;

public record SavingRequest(
        String name,
        String email
) {
}
