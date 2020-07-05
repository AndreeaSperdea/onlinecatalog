package com.andreea.onlinecatalog.controller;

import com.andreea.onlinecatalog.model.Student;
import com.andreea.onlinecatalog.repository.StudentRepository;
import com.andreea.onlinecatalog.service.SchoolGroupService;
import com.andreea.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolGroupService schoolGroupService;      //pentru a ne aduce school groupu-ul in studenti

    @GetMapping("allstudents")
    //cand navighez pe /allstudents ne va returna pagina showallstudents, numele poate fi orice
    public String showAllStudents(Model model) {      //se paseaza atribute catre Spring MVC
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);   //students - atributul din showallstudents.html din index.html
        return "student/showallstudents";

    }

    @GetMapping("addstudent")
    public String addStudent(Model model) {
        model.addAttribute("schoolgroups",schoolGroupService.findAll());
        model.addAttribute("student", new Student());   //sa stie pagina html (formularul) care este tipul obiectului
        return "student/addstudent";
    }

    @PostMapping("addstudent")
    public String addStudent(@ModelAttribute Student student) {
//        System.out.println(student);

        studentService.save(student);  //salvam studentul in baza de date

        return "redirect:/allstudents";  //ne duce la controlerul de all students..ala din getul de mai sus
    }




    @GetMapping("editstudent/{id}")            //sa stie ce ID sa editeze
    public String editStudent(Model model, @PathVariable Integer id) {      //path variable se pune dupa / in browser

        Student student = studentService.findById(id);

        model.addAttribute("student", student);   //sa stie pagina html (formularul) care este tipul obiectului
        model.addAttribute("schoolgroups",schoolGroupService.findAll());
        return "student/editstudent";
    }

    @PostMapping("editstudent/{id}")   //nu mai trebuie pathvariable pt ca avem deja de la get
    public String editstudent(@ModelAttribute Student student, @PathVariable Integer id) {
//
//        //        System.out.println(student);
//        Student database_student = studentService.findById(id);   //citim din baza de date informatiile despre studentul cu id-ul respectiv
//
//        database_student.setFirstName(student.getFirstName());   //atribuim in baza de date valoarea citita de pe html
//        database_student.setLastName(student.getLastName());

        studentService.save(student);  //salvam studentul in baza de date, se comporta ca update,daca deja exista

       // return "redirect:/editstudent/" + id;  //ne duce la controlerul de all students..ala din getul de mai sus
        return "redirect:/allstudents";
    }

    @GetMapping("deletestudent/{id}")            //sa stie ce ID sa editeze, pt stergere nu avem nevoie de post
    public String deleteStudent(@PathVariable Integer id) {      //path variable se pune dupa / in browser

//        Student student = studentRepository.findById(id).get();
//        studentRepository.delete(student);   sau
        studentService.deleteById(id);
        return "redirect:/allstudents";   //forward - pentru a pasa mai departe informatia
    }

}
