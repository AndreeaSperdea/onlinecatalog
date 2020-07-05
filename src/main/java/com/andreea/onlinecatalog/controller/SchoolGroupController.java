package com.andreea.onlinecatalog.controller;

import com.andreea.onlinecatalog.model.Professor;
import com.andreea.onlinecatalog.model.SchoolGroup;
import com.andreea.onlinecatalog.model.Student;
import com.andreea.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolGroupController {

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allschoolgroups")  //numele din menu (cum il definim acolo)
    public String showAllGroups(Model model){
        List<SchoolGroup> schoolGroups = schoolGroupService.findAll();
        model.addAttribute("schoolgroup", schoolGroups);  //numele din html

        return "schoolgroup/showallschoolgroups";
    }

    @GetMapping("addschoolgroup")
    public String addSchoolGroup(Model model) {
        model.addAttribute("schoolgroup", new SchoolGroup());   //sa stie pagina html (formularul) care este tipul obiectului
        return "schoolgroup/addschoolgroup";
    }

    @PostMapping("addschoolgroup")
    public String addSchoolGroup(@ModelAttribute SchoolGroup schoolGroup) {
//        System.out.println(student);

        schoolGroupService.save(schoolGroup);  //salvam studentul in baza de date

        return "redirect:/allschoolgroups";  //ne duce la controlerul de all students..ala din getul de mai sus
    }

    @GetMapping("editschoolgroup/{id}")            //sa stie ce ID sa editeze
    public String editSchoolGroup(Model model, @PathVariable Integer id) {      //path variable se pune dupa / in browser

        SchoolGroup schoolGroup = schoolGroupService.findById(id);

        model.addAttribute("schoolgroup", schoolGroup);
        return "schoolgroup/editschoolgroup";
    }

    @PostMapping("editschoolgroup/{id}")   //nu mai trebuie pathvariable pt ca avem deja de la get
    public String editSchoolGroup(@ModelAttribute SchoolGroup schoolGroup, @PathVariable Integer id) {

        schoolGroupService.save(schoolGroup);
        return "redirect:/allschoolgroups";
    }

    @GetMapping("deleteschoolgroup/{id}")
    public String deleteSchoolGroup(@PathVariable Integer id){
        schoolGroupService.deleteById(id);
        return "redirect:/allschoolgroups";
    }

    @GetMapping("group/{id}/students")
    public String viewStudentsInGroup(Model model, @PathVariable Integer id){
        model.addAttribute("students",schoolGroupService.findStudentsByGroup(id));
                return "schoolgroup/viewstudents";
    }



}

