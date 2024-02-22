package kz.baltabayev.identityservice.model.payload;

public record DeveloperSavingRequest(
        String name,
        String email,
        String position
) {
}
