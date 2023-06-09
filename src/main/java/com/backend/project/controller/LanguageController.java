package com.backend.project.controller;

import com.backend.project.model.Genre;
import com.backend.project.model.Language;
import com.backend.project.repository.GenreRepository;
import com.backend.project.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "${FRONTEND_URL}")
@RestController
@RequestMapping("/api")
public class LanguageController {

  @Autowired
  LanguageRepository languageRepository;

  @PostMapping("/language")
  public List<Language> createLanguages(@RequestBody List<Language> languagesList) {
//        try {
    for (Language l: languagesList) {
      Optional<Language> languageData = languageRepository.findById(l.getId());
      if (languageData.isPresent()) {
        Language _language = languageData.get();
        System.out.println("Modify");
        _language.setName(l.getName());
        _language.setEnglishName(l.getEnglishName());

        Language __language = languageRepository.save(_language);
      } else {
        Language _language = languageRepository.save(l);
      }
    }
    return languagesList;
  }

  @GetMapping("/language/all")
  public List<Language> getAllLanguages() {
    return languageRepository.findAll();
  }
}
