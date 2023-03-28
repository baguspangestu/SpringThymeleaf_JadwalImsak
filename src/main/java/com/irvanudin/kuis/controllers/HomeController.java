package com.irvanudin.kuis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irvanudin.kuis.models.JadwalModel;
import com.irvanudin.kuis.models.KabKotaModel;
import com.irvanudin.kuis.models.ProvinsiModel;
import com.irvanudin.kuis.services.ApiService;

@Controller
public class HomeController {

    private final ApiService apiService;

    public HomeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String home(Model model) throws JsonProcessingException {
        // Init Variable
        String initProvinsi = "Lampung";
        String initKabKota = "Kab. Pringsewu";
        // JsonString
        String provinsiJString = apiService.getProvinsi();
        String kabKotaJString = apiService.getKabKota(initProvinsi);
        String jadwalJString = apiService.getJadwal(initProvinsi, initKabKota);
        // Json to Object
        ObjectMapper objectMapper = new ObjectMapper();
        ProvinsiModel provinsi = objectMapper.readValue(provinsiJString, ProvinsiModel.class);
        KabKotaModel kabKota = objectMapper.readValue(kabKotaJString, KabKotaModel.class);
        JadwalModel jadwal = objectMapper.readValue(jadwalJString, JadwalModel.class);
        // Add to Model
        model.addAttribute("provinsi", provinsi);
        model.addAttribute("kabKota", kabKota);
        model.addAttribute("jadwal", jadwal);
        // Return View
        return "home";
    }
}
