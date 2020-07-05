package com.andreea.onlinecatalog.model;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;



@Entity
@Table
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL)
    private List<User> users;
}
