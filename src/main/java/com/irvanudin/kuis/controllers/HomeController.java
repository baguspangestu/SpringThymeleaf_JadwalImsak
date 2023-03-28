package com.irvanudin.kuis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.irvanudin.kuis.services.ApiService;

@Controller
public class HomeController {

    private final ApiService apiService;

    public HomeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String home(Model model) {
        String jadwal = apiService.getJadwal("Lampung", "Kab. Pringsewu");
        model.addAttribute("jadwal", jadwal);
        return "home";
    }
}
