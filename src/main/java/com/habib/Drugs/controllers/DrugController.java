package com.habib.Drugs.controllers;

import com.habib.Drugs.Service.DrugService;
import com.habib.Drugs.entities.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DrugController {
@Autowired
    DrugService drugService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createDrug";
    }
    @RequestMapping("/saveDrug")
    public String saveDrug(@ModelAttribute("drug") Drug drug,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        drug.setDateCreation(dateCreation);

        Drug saveDrug = drugService.saveDrug(drug);
        String msg ="Drug added with Id "+saveDrug.getIdDrug();
        modelMap.addAttribute("msg", msg);
        return "createDrug";
    }
    @RequestMapping("/ListeDrugs")
    public String listeDrugs(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Drug> dru = drugService.getAllDrugsParPage(page, size);
        modelMap.addAttribute("drugs", dru);
        modelMap.addAttribute("pages", new int[dru.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeDrugs";
    }
    @RequestMapping("/supprimerDrug")
    public String supprimerDrug(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size)
    {
        drugService.deleteDrugById(id);
        Page<Drug> dru = drugService.getAllDrugsParPage(page,size);
        modelMap.addAttribute("drugs", dru);
        modelMap.addAttribute("pages", new int[dru.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeDrugs";
    }
    @RequestMapping("/modifierDrug")
    public String editerDrug(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Drug d= drugService.getDrug(id);
        modelMap.addAttribute("drug", d);
        return "editerDrug";
    }
    @RequestMapping("/updateDrug")
    public String updateDrug(@ModelAttribute("drug") Drug drug, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        drug.setDateCreation(dateCreation);

        drugService.updateDrug(drug);
        return "redirect:/ListeDrugs";
    }


}
