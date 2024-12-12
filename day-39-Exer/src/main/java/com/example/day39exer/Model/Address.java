package com.example.day39exer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Address {

    @Id
    private Integer id;
    @NotEmpty(message = "Enter the street")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotEmpty(message = "Enter the building number")
    @Column(columnDefinition = "varchar(10) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    public Teacher teacher;

}
