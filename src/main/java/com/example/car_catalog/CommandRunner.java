package com.example.car_catalog;

import com.example.car_catalog.domain.entities.*;
import com.example.car_catalog.repositories.ModelRepository;
import com.example.car_catalog.services.brands.BrandService;
import com.example.car_catalog.services.car.CarService;
import com.example.car_catalog.services.fuelType.FuelTypeService;
import com.example.car_catalog.services.models.ModelService;
import com.example.car_catalog.services.seeds.SeedService;
import com.example.car_catalog.services.transmission.TransmissionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandRunner implements CommandLineRunner {


    private final SeedService seedService;
    private final CarService carService;
    private final BrandService brandService;

    private final FuelTypeService fuelTypeService;
    private final ModelService modelService;
    private final TransmissionService transmissionService;
    private  final  Scanner scanner = new Scanner(System.in);

    public CommandRunner(SeedService seedService, CarService carService, BrandService brandService, FuelTypeService fuelTypeService, ModelService modelService, TransmissionService transmissionService) {
        this.seedService = seedService;
        this.carService = carService;
        this.brandService = brandService;
        this.fuelTypeService = fuelTypeService;
        this.modelService = modelService;
        this.transmissionService = transmissionService;

    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll();
        createCars();
        /*createBrand();
        deleteCarById()*/
        /*getCarById();*/
    }

    private void getCarById() {
        System.out.println("Enter the ID of the car:");
        Long carId = Long.parseLong(scanner.nextLine());

        Car car = carService.getCarById(carId);

        if (car != null) {
            System.out.println("Car details:");
            System.out.println("ID: " + car.getId());
            System.out.println("VIN Number: " + car.getVinNumber());
            System.out.println("Price: " + car.getPrice());
            System.out.println("Registration Date: " + car.getRegDate());
            System.out.println("Remarks: " + car.getRemarks());
            System.out.println("Fuel type: " + car.getFuelType().getName());
            System.out.println("Model: " + car.getModel().getName());
            System.out.println("Brand: " + car.getModel().getBrand().getName());
            System.out.println("Transmission type: " + car.getTransmission());
        } else {
            System.out.println("Car with ID " + carId + " not found.");
        }
    }


    public void createBrand() {
        Brand brand = new Brand();
        System.out.print("Brand name: ");
        brand.setName(scanner.nextLine());
        Brand createdBrand = brandService.createBrand(brand);

        System.out.println("Brand created: " + createdBrand);
    }
    public void createCars() {

        /*FuelType fuelType = fuelTypeService.getFuelTypeById(1L);

        Model model = modelService.getModelById(3L);

        Transmission transmissionType = transmissionService.getTransmissionById(2L);*/

        Car car = new Car();
        System.out.print("Enter the VIN Number: ");
        car.setVinNumber(scanner.nextLine());

        System.out.print("Enter car price: ");
        String priceString = scanner.nextLine();
        BigDecimal price = new BigDecimal(priceString);
        car.setPrice(price);

        System.out.print("Enter car registration date: ");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString, dateFormatter);
        car.setRegDate(date);

        System.out.print("Enter car remarks ");
        car.setRemarks(scanner.nextLine());

        System.out.println("Choose car fuel type by ID: 1)GASOLINE, 2)DIESEL, 3)GAS, 4)Electric ");
        int fuelTypeId = Integer.parseInt(scanner.nextLine());
        FuelType fuelType = null;

        switch (fuelTypeId) {
            case 1:
                fuelType = fuelTypeService.getFuelTypeById(1L);
                break;
            case 2:
                fuelType = fuelTypeService.getFuelTypeById(2L);
                break;
            case 3:
                fuelType = fuelTypeService.getFuelTypeById(3L);
                break;
            case 4:
                fuelType = fuelTypeService.getFuelTypeById(4L);
                break;
            default:
                System.out.println("Invalid choice. Try again!");
                fuelTypeId = Integer.parseInt(scanner.nextLine());
        }
        car.setFuelType(fuelType);


        System.out.print("Enter car model: ");
        String modelName = scanner.nextLine();

        Model model = new Model();
        model.setName(modelName);

        System.out.print("Enter car brand: ");
        String brandName = scanner.nextLine();
        Brand brand = new Brand();
        brand.setName(brandName);
        car.setModel(modelService.createModelWithBrand(modelName,brandName));
       /* car.setModel(modelService.createModel(model));

        System.out.print("Enter car brand: ");
        String brandName = scanner.nextLine();

        Brand brand = new Brand();
        brand.setName(brandName);
        car.getModel().setBrand(brandService.createBrand(brand));*/


        System.out.println("Choose car transmission by ID: 1)AUTOMATIC, 2)MANUAL, 3)HYBRID");
        int transmissionTypeId = Integer.parseInt(scanner.nextLine());
        Transmission transmissionType = null;

        switch (transmissionTypeId) {
            case 1:
                transmissionType = transmissionService.getTransmissionById(1L);
                break;
            case 2:
                transmissionType = transmissionService.getTransmissionById(2L);
                break;
            case 3:
                transmissionType = transmissionService.getTransmissionById(3L);
                break;
            default:
                System.out.println("Invalid choice.Try again!");
                transmissionTypeId= Integer.parseInt(scanner.nextLine());
        }
        car.setTransmission(transmissionType);

        Car createdCar = carService.createCar(car);
        System.out.println("New Car created");
    }
    public void deleteCarById(){

        System.out.println("Enter the ID of the car to delete:");
        Long carId = scanner.nextLong();
         carService.deleteCar(carId);
        System.out.println("Car with ID " + carId + " has been deleted.");
    }

}