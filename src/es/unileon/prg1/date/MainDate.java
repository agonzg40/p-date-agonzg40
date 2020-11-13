package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(11,11,2021);
			Date otro = new Date(11,11,2020);
			System.out.println(today);
			
				System.out.println(today.triesDoWhile());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
