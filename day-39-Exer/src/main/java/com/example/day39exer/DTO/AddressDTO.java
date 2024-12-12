package com.example.day39exer.DTO;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "Enter the street")
    private String street;
    @NotEmpty(message = "Enter the building number")
    private String buildingNumber;

}
