package com.irvanudin.kuis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irvanudin.kuis.models.JadwalModel;
import com.irvanudin.kuis.models.KabKotaModel;
import com.irvanudin.kuis.models.ProvinsiModel;
import com.irvanudin.kuis.models.JadwalModel.DetailJadwal;
import com.irvanudin.kuis.services.ApiService;
import com.irvanudin.kuis.utils.helpers;

@Controller
public class HomeController {

    private final ApiService apiService;

    public HomeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "Lampung", required = false) String provinsi,
                       @RequestParam(defaultValue = "Kab. Pringsewu", required = false) String kabkota,
                       Model model) throws JsonProcessingException {
        // Get Date
        String date = helpers.getDateNow();
        // JsonString
        String provinsiJString = apiService.getProvinsi();
        String kabKotaJString = apiService.getKabKota(provinsi);
        String jadwalJString = apiService.getJadwal(provinsi, kabkota);
        // Json to Object
        ObjectMapper objectMapper = new ObjectMapper();
        ProvinsiModel provinsiObj = objectMapper.readValue(provinsiJString, ProvinsiModel.class);
        KabKotaModel kabKotaObj = objectMapper.readValue(kabKotaJString, KabKotaModel.class);
        JadwalModel jadwalObj = objectMapper.readValue(jadwalJString, JadwalModel.class);
        // Cek Date & set isToday
        DetailJadwal jadwalData = jadwalObj.getData().getData().get(date);
        if (jadwalData != null) jadwalData.setIsToday(true); 
        // Add to Model
        model.addAttribute("date", date);
        model.addAttribute("provinsi", provinsiObj);
        model.addAttribute("kabKota", kabKotaObj);
        model.addAttribute("jadwal", jadwalObj);
        // Return View
        return "home";
    }
    
}
