package io.codekaffee.pocs.authserver.dtos;


public record UserDTO(String firstName, String lastName, String email, String password) {
    
}