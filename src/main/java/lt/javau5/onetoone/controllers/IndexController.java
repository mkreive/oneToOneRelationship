package lt.javau5.onetoone.controllers;

import lt.javau5.onetoone.entity.Address;
import lt.javau5.onetoone.entity.Building;
import lt.javau5.onetoone.repo.AddressRepository;
import lt.javau5.onetoone.repo.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/index")
    public Building getBuilding() {
        Address address = new Address();
        Building building = new Building();

        address.setBuilding(building);
        address.setLocation("Baker's Street");
        addressRepository.save(address);

        building.setAddress(address);
        building.setName("Anne's House");
        buildingRepository.save(building);

        return building;
    }
}
