package com.example.lab6_20185910.controllers;

import com.example.lab6_20185910.entity.Device;
import com.example.lab6_20185910.repository.DeviceRepository;
import com.example.lab6_20185910.repository.SiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/equipos")
public class EquiposController {
    final DeviceRepository deviceRepository;
    final SiteRepository siteRepository;


    public EquiposController(DeviceRepository deviceRepository, SiteRepository siteRepository) {

        this.deviceRepository = deviceRepository;
        this.siteRepository = siteRepository;
    }


    @GetMapping(value={"/verEquipos", "/", ""})
    public String listaEquipos(Model model){
        List<Device> listaEquipos = deviceRepository.findAll();
         model.addAttribute("listaEquipos", listaEquipos);
        return "Equipos/equiposLista";
    }

    @GetMapping("/new")
    public String newForm(Model model){
        model.addAttribute("listaEquipos", deviceRepository.findAll());
        model.addAttribute("listaSitios", siteRepository.findAll());
        return "Equipos/new";
    }

    @GetMapping("/borrar")

    public String borrar(@RequestParam("id") int id,
                         RedirectAttributes attr) {

        Optional<Device> optionalDevice = deviceRepository.findById(id);

        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            deviceRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Equipo " + device.getDeviceName()+ " borrado exitosamente");
        }

        return "redirect:/equipos";
    }


    @GetMapping("/save")
    public String formEditar(Device device,
                             RedirectAttributes attr) {

        deviceRepository.save(device);
        attr.addFlashAttribute("msg", "Equipo " + device.getDeviceName() + " creado exitosamente");
        return "redirect:/equipos";

    }
}