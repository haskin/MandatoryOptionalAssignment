package org.example;

import java.util.stream.Stream;

public class Main<T> {

    public static void main(String[] args) {

        JOptional<String> emptyOptional = JOptional.ofNullable(null);
        System.out.println(emptyOptional.orElse("I am an empty optional"));

        JOptional<String> jOptional = JOptional.ofNullable("I am a string optional");
        Stream<String> stringStream = jOptional.stream();
        stringStream.forEach(System.out::println);

        JOptional<Account> accountOptional = JOptional.ofNullable(new Account());
        JOptional<Address> addressOptional = accountOptional.map(Account::getCustomer)
                .map(Customer::getAddress);

        System.out.println(addressOptional.orElse(new Address()));
        System.out.println(addressOptional.orElseGet(Address::new));

    }
}

class Account {
    Customer customer = new Customer();

    public Customer getCustomer() {
        return customer;
    }

}

class Customer {
    Address address = new Address();

    public Address getAddress() {
        return address;
    }

}

class Address {

    String street = "111 Address St";

    Address() {

    }

    @Override
    public String toString() {
        return street;
    }

}