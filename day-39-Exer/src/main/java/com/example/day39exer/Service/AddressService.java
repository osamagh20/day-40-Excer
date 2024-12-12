package com.example.day39exer.Service;

import com.example.day39exer.ApiResponse.ApiException;
import com.example.day39exer.DTO.AddressDTO;
import com.example.day39exer.Model.Address;
import com.example.day39exer.Model.Teacher;
import com.example.day39exer.Repository.AddressRepository;
import com.example.day39exer.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if(teacher == null){
            throw new ApiException("teacher not found");
        }
        Address address1 = new Address(null,addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address1);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address == null){
            throw new ApiException("teacher not found");
        }
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);

    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address == null){
            throw new ApiException("teacher not found");
        }
        addressRepository.delete(address);
    }


}
