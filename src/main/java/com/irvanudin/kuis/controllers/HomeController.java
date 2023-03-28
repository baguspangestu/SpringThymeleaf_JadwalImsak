package com.irvanudin.kuis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irvanudin.kuis.models.JadwalModel;
import com.irvanudin.kuis.services.ApiService;

@Controller
public class HomeController {

    private final ApiService apiService;

    public HomeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
public String home(Model model) throws JsonProcessingException {
    String provinsi = "Lampung";
    String kabKota = "Kab. Pringsewu";
    String jsonString = apiService.getJadwal(provinsi, kabKota);
    ObjectMapper objectMapper = new ObjectMapper();
    JadwalModel jadwalModel = objectMapper.readValue(jsonString, JadwalModel.class);
    model.addAttribute("jadwal", jadwalModel);
    return "home";
}
}
