package main;

import java.time.LocalDate;
import java.time.LocalTime;

import model.Disappearence;

public class Main {

	public static void main(String[] args) {
		
        Disappearence desaparecimento = new Disappearence(
            1, // idDisappearence
            LocalDate.of(2025, 10, 30), 
            LocalTime.of(15, 45), 
            "Praia Central", 
            "Saiu para caminhar e não voltou", 
            "Camiseta branca e calça jeans", 
            101, 
            5
        );

        System.out.println(desaparecimento);

	}

}
