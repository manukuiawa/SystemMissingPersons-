package main;

import java.time.LocalDate;
import java.time.LocalTime;

import model.Disappearence;

public class Main {

	public static void main(String[] args) {
		// criando um objeto da classe Disappearence
        Disappearence desaparecimento = new Disappearence(
            1, // idDisappearence
            LocalDate.of(2025, 10, 30), // dateDisappearence
            LocalTime.of(15, 45), // hourDisappearence
            "Praia Central", // location
            "Saiu para caminhar e não voltou", // contextDisappearence
            "Camiseta branca e calça jeans", // clothesDisappearence
            101, // idPeople (referência à pessoa)
            5 // idCommunicant (quem comunicou)
        );

        System.out.println(desaparecimento);

	}

}
