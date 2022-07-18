package com.example.paragonordersservice.Services;

public interface TokenService {
    boolean checkToken(String token);
    String checkRole(String token);
}
