package com.example.biblioteca_back.dto;

public record BookDTO(
        String title,
        String author,
        String description,
        String genre,
        String cover
) {}

