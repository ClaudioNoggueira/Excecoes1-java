package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int roomNumber = input.nextInt();
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(input.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(input.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

			System.out.println("\nEntre com os dados para atualizar a reserva.");
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(input.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

		} catch (ParseException e) {
			System.out.println("\nFormato de data inválido.");
			System.out.println("Por favor, siga o padrão (DD/MM/AAAA). Ex: 31/12/2021");
		} catch (DomainException e) {
			System.out.println("\nErro na reserva: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(
					"\nValor inválido. Não foi possível efetuar operação pois foi inserido um valor inadequado.");
		} catch (RuntimeException e) {
			System.out.println("\nErro inesperado.");
		} finally {
			input.close();
		}
	}
}
