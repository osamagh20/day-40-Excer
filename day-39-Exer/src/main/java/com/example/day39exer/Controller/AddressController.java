package com.example.day39exer.Controller;

import com.example.day39exer.ApiResponse.ApiResponse;
import com.example.day39exer.DTO.AddressDTO;
import com.example.day39exer.Model.Address;
import com.example.day39exer.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        List<Address> addressList = addressService.getAllAddress();
        return ResponseEntity.status(200).body(addressList);
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address saved successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}
