package com.betrybe.products.dtos;

public record ResponseDTO<T>(String message, T data) {
}