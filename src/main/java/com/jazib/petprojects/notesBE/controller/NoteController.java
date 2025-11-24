package com.jazib.petprojects.notesBE.controller;

import com.jazib.petprojects.notesBE.model.Note;
import com.jazib.petprojects.notesBE.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public Note save(@AuthenticationPrincipal UserDetails user, @RequestBody Note note)
    {
        note.setUserId(user.getUsername());
        return noteService.save(note);
    }

    @GetMapping("/all")
    public List<Note> getAll(@AuthenticationPrincipal UserDetails user) {
        final String username = user.getUsername();
        return noteService.findAllByUserName(username);
    }

}
