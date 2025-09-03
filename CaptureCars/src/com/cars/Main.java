package com.cars;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    static public void main(String[] args){
     Scanner input = new Scanner(System.in);
        // Store all captured Car objects in an ArrayList (dynamic collection)

        Collection<Car> cars = new ArrayList<Car>();
        
         // Initial menu prompt
        System.out.println("Good day,welcome to the app");
        System.out.println("(1) Capture vehicle details\n"+
                           "(2) View vehicle report\n"+
                           "(3) Exit app");

        int menuOption = input.nextInt();

         // Main loop: only runs while the user chooses option 1 or 2
        while((menuOption == 1) || (menuOption == 2)){

            if(menuOption == 1){
                // Create a new Car object to hold input
               Car carObj = new Car();
               int year;
               int millage;
               String make;
               String model;
               String plateNum = "";
               String vinNum;

                // Prompt for vehicle make
                System.out.println("Enter make");
                make = input.next();

                //Prompt for vehicle model
                System.out.println("Enter model");
                model = input.next();

                //Prompt and validate VIN(must be 17 characters)
                System.out.println("Enter vin");
                vinNum = input.next();
                while(!(vinNum.length() == 17)){
                    System.out.println("Enter vin and make sure it is 17 characters long");
                    vinNum = input.next();
                }

                //Prompt for licence plate format
                System.out.println("Please enter (1) for old format license plate number, and (2) for new format plate number ");
                int plateChoice = input.nextInt();
                if(plateChoice == 1){
                    System.out.println("Enter the plate number e.g. AAA555GP");
                    plateNum = input.next();
                } else if(plateChoice == 2) {
                    System.out.println("Enter the plate number e.g. AA66BBGP");
                    plateNum = input.next();
                }
                //Prompt for millage(odometer reading)
                System.out.println("Enter millage");
                millage = input.nextInt();

                //Prompt for year of manufacture
                System.out.println("Enter year");
                year = input.nextInt();

                carObj.setMake(make);
                carObj.setModel(model);
                carObj.setPlateNumber(plateNum);
                carObj.setVin(vinNum);
                carObj.setYear(year);
                carObj.setMillage(millage);

                //Add Car object to collection
                cars.add(carObj);

            } else if(menuOption == 2){
                if(cars.isEmpty()){
                    System.out.println("The are no cars captured");
                }else{
                    System.out.println("***************************\n"+
                                        "VEHICLE REPORT\n"+
                                        "***************************");
                    //Loop through each car and print details
                    for(Car carObject: cars){
                        System.out.println("VEHICLE MAKE: " + carObject.getMake() +
                                           "\nVEHICLE MODEL: " + carObject.getModel() +
                                           "\nLICENSE PLATE NUMBER: " + carObject.getPlateNumber() +
                                           "\nVIN NUMBER: " + carObject.getVin() +
                                           "\nYEAR: " + carObject.getYear() +
                                           "\nVEHICLE MILLAGE: " + carObject.getMillage());
                    }
                }
            } 
            //Show the menu again after operation
            System.out.println("(1) Capture vehicle details\n"+
                                 "(2) View vehicle report\n"+
                                 "(3) Exit app");
            menuOption = input.nextInt();// Get next menu choice
        }
        //Exit message
        System.out.println("Thanks for using the app");

    }
}

