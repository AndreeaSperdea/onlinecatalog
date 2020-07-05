package com.andreea.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SchoolGroup {
    private String groupName;
    private Date groupYear;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    @OneToMany(mappedBy = "schoolGroup", cascade = CascadeType.ALL)     //entitatea care ne mapeaza, din clasa curenta, numele clasei
    private List<Student> students;                              //o gupa poate contine mai multi studenti
}
