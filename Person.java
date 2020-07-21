package com.Person;

import java.util.*;

public class Person {
    String firstName,lastName,address,state,city,phone;
    int zip;
    int duplicateFlag=0;
    Scanner sc=new Scanner(System.in);
    ArrayList<Person> list=new ArrayList<Person>();
    Person addressbook;
    public Person(String firstName, String lastName, String address, String state, String city, int zip, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getState(){
        return state;
    }
    public String getCity(){
        return city;
    }
    public int getZip(){
        return zip;
    }
    public String getPhone(){ return phone; }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setAddress(String address){ this.address=address; }
    public void setState(String state){
        this.state=state;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setZip(int zip){
        this.zip=zip;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void duplicateEntry(String firstName){
        System.out.println("Checking for duplicate entries");
        if(list.size()>1) {
            for (int iteration = 0; iteration < list.size(); iteration++) {
                addressbook = (Person) list.get(iteration);
                if (firstName.equals(addressbook.firstName)) {
                    System.out.println("Duplicate record found with same first name" + addressbook.getFirstName());
                    duplicateFlag = 1;
                }
            }
        }
        else{
            System.out.println("No records to check duplicates");
        }
    }
    public void addEntry(){

        System.out.println("Enter the number of people to be added");
        int numP=sc.nextInt();
        for(int iteration=0;iteration<numP;iteration++) {
            System.out.println("Enter the first name");
            firstName = sc.next();
            System.out.println("Enter the last name");
            lastName = sc.next();
            duplicateEntry(firstName);
            if(duplicateFlag==0) {
                System.out.println("Enter address");
                address = sc.next();
                System.out.println("Enter state");
                state = sc.next();
                System.out.println("Enter city");
                city = sc.next();
                System.out.println("Enter zip");
                zip = sc.nextInt();
                System.out.println("Enter phone");
                phone = sc.next();

                list.add(new Person(firstName, lastName, address, state, city, zip, phone));
                //addList.display();
                for (Person person : list) {
                    System.out.println("Firstname :" + person.getFirstName() + "\nLastname :" + person.getLastName() + "\nAddress :" + person.getAddress() + "\nState :" + person.getState() + "\nCity :" + person.getCity() + "Zip :" + person.getZip() + "\nPhone :" + person.getPhone());
                }
            }
        }
    }
    public void editEntry(){
        System.out.println("Enter the first name");
        String firstName=sc.next();
        for(int iteration=0;iteration<list.size();iteration++){
            addressbook=(Person)list.get(iteration);
            if(firstName.equals(addressbook.firstName)){
                System.out.println("Matching record found "+addressbook.firstName);
                System.out.println("Do you want to edit 1.Address 2.State 3.City 4.Zip 5.Phone");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Enter the address");
                        address = sc.next();
                        addressbook.setAddress(address);
                        break;
                    case 2:
                        System.out.println("Enter State");
                        state = sc.next();
                        addressbook.setState(state);
                        break;
                    case 3:
                        System.out.println("Enter City");
                        city = sc.next();
                        addressbook.setCity(city);
                        break;
                    case 4:
                        System.out.println("Enter Zip");
                        zip = sc.nextInt();
                        addressbook.setZip(zip);
                        break;
                    case 5:
                        System.out.println("Enter phone");
                        phone = sc.next();
                        addressbook.setPhone(phone);
                        break;
                    default:
                        System.out.println("Not applicable");
                        break;

                }
                System.out.println("Firstname :"+addressbook.getFirstName()+"\nLastname :"+addressbook.getLastName()+"\nAddress :"+addressbook.getAddress()+"\nState :"+addressbook.getState()+"\nCity :"+addressbook.getCity()+"Zip :"+addressbook.getZip()+"\nPhone :"+addressbook.getPhone());
            }
            else {
                System.out.println("No matching record found");
            }
        }
    }
    public void deleteEntry() {
        System.out.println("Enter the first name");
        String firstName = sc.next();
        for (int iteration = 0; iteration < list.size(); iteration++) {
            addressbook = (Person) list.get(iteration);
            if (firstName.equals(addressbook.firstName)) {
                System.out.println("Matching record found " + addressbook.firstName);
                System.out.println("Do you want to delete 1.Yes 2.No");
                int choice = sc.nextInt();
                if (choice == 1) {
                    list.remove(iteration);
                } else {
                    System.out.println("No need to delete");
                }
            }
        }
    }
    public void sortByNames(){
        list.stream().sorted(Comparator.comparing(Person::getFirstName)).forEach(p -> System.out.printf("%s\t%s\t %s\t%s\t%s\t%s\t%s\t%n", p.getFirstName(),p.getLastName(),p.getAddress(),p.getState(),p.getCity(),p.getZip(),p.getPhone()));
    }
    public void sortByCityStateZip(){
        System.out.println("Enter the choice to sort 1.SortbyCity 2.SortbyState 3.SortbyZip");
        int choice=sc.nextInt();
        switch(choice){
            case 1: list.stream().sorted(Comparator.comparing(Person::getCity)).forEach(p -> System.out.printf("%s\t%s\t %s\t%s\t%s\t%s\t%s\t%n", p.getCity(),p.getFirstName(),p.getLastName(),p.getAddress(),p.getState(),p.getZip(),p.getPhone()));
                    break;
            case 2: list.stream().sorted(Comparator.comparing(Person::getState)).forEach(p -> System.out.printf("%s\t%s\t %s\t%s\t%s\t%s\t%s\t%n", p.getState(),p.getFirstName(),p.getLastName(),p.getAddress(),p.getCity(),p.getZip(),p.getPhone()));
                    break;
            case 3: list.stream().sorted(Comparator.comparing(Person::getZip)).forEach(p -> System.out.printf("%s\t%s\t %s\t%s\t%s\t%s\t%s\t%n", p.getZip(),p.getFirstName(),p.getLastName(),p.getAddress(),p.getCity(),p.getState(),p.getPhone()));
                    break;
            default: System.out.println("Not in list");
                     break;
        }

    }
    public void viewByCityState(){

       System.out.println("Enter the city and state");
       String city=sc.next();
       String state=sc.next();
       for(int iteration=0;iteration<list.size();iteration++) {
           addressbook = (Person) list.get(iteration);
           if (city.equals(addressbook.getCity()) && state.equals(addressbook.getState())) {
               System.out.println("Matching record found"+addressbook.getFirstName());
           }
       }
    }

     public void searchCityorState(){

        System.out.println("Enter the city and state");
        String city=sc.next();
        String state=sc.next();
        for(int iteration=0;iteration<list.size();iteration++) {
            addressbook = (Person) list.get(iteration);
            if (city.equals(addressbook.getCity()) || state.equals(addressbook.getState())) {
                System.out.println("Matching record found"+addressbook.getFirstName());
            }
        }
     }

     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String firstName = null,lastName=null,address=null,state=null,city=null,phone=null;
        int zip=0;
        System.out.println("Welcome to Address Book Program");
        Person select=new Person(firstName,lastName,address,state,city,zip,phone);
        while(true){
            System.out.println("Enter the choice 1.Add 2.Edit 3.Delete 4.Sort 5.SortByCity/state/zip 6.ViewByCityandstate 7.SearchCityorState 8.Quit");
            int choice1=sc.nextInt();
            switch(choice1) {
                case 1:
                    select.addEntry();
                    break;
                case 2:
                    select.editEntry();
                    break;
                case 3:
                    select.deleteEntry();
                    break;
                case 4:
                    select.sortByNames();
                     break;
                case 5:
                    select.sortByCityStateZip();
                        break;
                case 6:
                    select.viewByCityState();
                        break;
                case 7:
                    select.searchCityorState();
                        break;
                case 8:
                    System.out.println("Thankyou for using Address book");
                    break;
                default:
                    System.out.println("Enter correct choice");
                    break;
            }

        }
    }
}