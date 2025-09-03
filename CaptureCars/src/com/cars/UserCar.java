package com.cars;
import javax.swing.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

    // Vehicle Registry with GUI
    public class UserCar {
        static public void main(String[] args) { // can put static before public
            //


            Collection<Car> cars = new ArrayList<>();


            JOptionPane.showMessageDialog(null,"Welcome to the Vehicle app","Vehicle app",JOptionPane.PLAIN_MESSAGE);

            int menuOption = Integer.parseInt(JOptionPane.showInputDialog(null,"(1) Capture vehicle details\n"+
                    "(2) View Vehicle report\n"+
                    "(3) Exit app","Vehicle report",JOptionPane.QUESTION_MESSAGE));


            while ((menuOption== 1) || (menuOption==2) ){

                if (menuOption==1){
                    Car carObj= new Car();
                    int year;
                    int millage;
                    String make;
                    String model;
                    String plateNum="";
                    String vinNum;


                    make= (JOptionPane.showInputDialog(null,"Enter vehicle make"));


                    model=JOptionPane.showInputDialog(null,"Enter vehicle model");


                    vinNum=JOptionPane.showInputDialog(null,"Enter vin");

                    while (!(vinNum.length() == 17)){

                        vinNum=JOptionPane.showInputDialog(null,"Enter vin make sure its 17 characters long");
                    }


                    int plateChoice =Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter (1) for old format license plate number+\n" +
                            "and (2) for new format plate number"));

                    if (plateChoice==1 ){

                        plateNum=JOptionPane.showInputDialog(null,"Enter plate number e.g. AAA555GP");
                    } else if (plateChoice == 2) {

                        plateNum= JOptionPane.showInputDialog(null,"Enter Plate number e.g. AA66BBGP");
                    }

                    millage= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter millage"));

                    year= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter year"));

                    carObj.setMake(make);
                    carObj.setModel(model);
                    carObj.setPlateNumber(plateNum);
                    carObj.setVin(vinNum);
                    carObj.setYear(year);
                    carObj.setMillage(millage);

                    cars.add(carObj);

                } else if (menuOption == 2) {
                    if (cars.isEmpty()) {

                        JOptionPane.showMessageDialog(null,"There are no cars captured","Vehicle Report",JOptionPane.ERROR_MESSAGE);
                    }else {

                        JOptionPane.showMessageDialog(null,"***************************\n"+
                                "VEHICLE REPORT\n"+
                                "*****************************","Vehicle Report",JOptionPane.INFORMATION_MESSAGE);
                        for (Car carObject :cars){

                            JOptionPane.showMessageDialog(null,"MAKE: "+carObject.getMake()+
                                    "\nMODEL: "+carObject.getModel()+
                                    "\nPLATE NUMBER: "+ carObject.getPlateNumber()+
                                    "\nVIN :"+ carObject.getVin()+
                                    "\nYear :"+ carObject.getYear()+
                                    "\nMILLAGE :"+ carObject.getMillage(),"Vehicle Report",JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                }

                menuOption=Integer.parseInt(JOptionPane.showInputDialog(null,"(1) Capture vehicle details\n"+
                        "(2) View Vehicle report\n"+
                        "(3) Exit app","Vehicle Report",JOptionPane.QUESTION_MESSAGE));
            }

            JOptionPane.showMessageDialog(null,"Thanks for using the app");
        }
    }

