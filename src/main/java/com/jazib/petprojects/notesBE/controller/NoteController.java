package com.jazib.petprojects.notesBE.controller;

import com.jazib.petprojects.notesBE.model.Note;
import com.jazib.petprojects.notesBE.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public Note save(@RequestBody Note note)
    {
        return noteService.save(note);
    }

    @GetMapping("/all")
    public List<Note> getAll() {
        return noteService.findAll();
    }

}
