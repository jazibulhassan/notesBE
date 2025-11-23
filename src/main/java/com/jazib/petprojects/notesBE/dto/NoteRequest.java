package com.jazib.petprojects.notesBE.dto;

import jakarta.validation.constraints.NotBlank;

public class NoteRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
