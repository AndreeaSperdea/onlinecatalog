package com.andreea.onlinecatalog.controller;

import com.andreea.onlinecatalog.model.Professor;
import com.andreea.onlinecatalog.model.Professor;
import com.andreea.onlinecatalog.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("allprofessors")
    //cand navighez pe /allprofessors ne va returna pagina showallprofessors, numele poate fi orice
    public String showAllProfessors(Model model) {      //se paseaza atribute catre Spring MVC
        List<Professor> professorList = professorService.findAll();
        model.addAttribute("professors", professorList);   //professor - atributul din index.html
        return "professor/showallprofessors";

    }

    @GetMapping("addprofessor")
    public String addProfessor(Model model) {
        model.addAttribute("professor", new Professor());   //sa stie pagina html (formularul) care este tipul obiectului
        return "professor/addprofessor";
    }

    @PostMapping("addprofessor")
    public String addProfessor(@ModelAttribute Professor professor) {
//        System.out.println(student);

        professorService.save(professor);  //salvam profesorul in baza de date

        return "redirect:/allprofessors";  //ne duce la controlerul de all professors..ala din getul de mai sus
    }


    @GetMapping("editprofessor/{id}")            //sa stie ce ID sa editeze
    public String editProfessor(Model model, @PathVariable Integer id) {      //path variable se pune dupa / in browser

        Professor professor = professorService.findById(id);

        model.addAttribute("professor", professor);   //sa stie pagina html (formularul) care este tipul obiectului
        return "professor/editprofessor";
    }

    @PostMapping("editprofessor/{id}")   //nu mai trebuie pathvariable pt ca avem deja de la get
    public String editProfessor(@ModelAttribute Professor professor, @PathVariable Integer id) {

//
//       Professor database_professor = professorService.findById(id);   //citim din baza de date informatiile despre studentul cu id-ul respectiv
//
//        database_professor.setFirstName(professor.getFirstName());   //atribuim in baza de date valoarea citita de pe html
//       database_professor.setLastName(professor.getLastName());


        professorService.save(professor);  //salvam profesorul in baza de date, se comporta ca update,daca deja exista

       // return "redirect:/editstudent/" + id;  //ne duce la controlerul de all students..ala din getul de mai sus
        return "redirect:/allprofessors";
    }

    @GetMapping("deleteprofessor/{id}")            //sa stie ce ID sa editeze, pt stergere nu avem nevoie de post
    public String deleteProfessor(@PathVariable Integer id) {      //path variable se pune dupa / in browser

//        Professor student = studentRepository.findById(id).get();
//        studentRepository.delete(student);   sau
        professorService.deleteById(id);
        return "redirect:/allprofessors";   //forward - pentru a pasa mai departe informatia
    }

}
