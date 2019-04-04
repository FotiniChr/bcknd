package com.example.demobcknd;

import com.example.demobcknd.models.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);   // gia na trexei genika to programma

		customer c1 = new customer("fofo", "xris", "fot@gmail.com", "6980000000", "address1", "15021");
		System.out.println("\nCustomer 1 "  +  c1.toString()  + "  --  \n\n "  ) ;

		room r1 = new room(100, 500);
		System.out.println("Room 1 "  +  r1.toString()  + "  --  \n\n "  ) ;

		rent r11 = new rent(c1, r1 , "nooo" , 1);
		System.out.println("Rent 1 "  +  r11.toString()  + "  --  \n\n "  ) ;




	}

}