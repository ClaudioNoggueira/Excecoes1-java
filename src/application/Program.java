package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int roomNumber = input.nextInt();
		System.out.print("Data de check-in (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Data de check-out (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(input.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro ao efetuar reserva: Data de check-out deve ser depois da data de check-in.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

			System.out.println("\nEntre com os dados para atualizar a reserva.");
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(input.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Dados para atualização de reserva devem ser datas futuras");
			} else if ((!checkOut.after(checkIn))) {
				System.out.println("Erro ao efetuar reserva: Data de check-out deve ser depois da data de check-in.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}
		}
		input.close();
	}
}
