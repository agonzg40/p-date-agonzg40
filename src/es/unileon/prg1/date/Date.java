package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}

	public int getYear (){

		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public int getDay(){
		return this.day;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public boolean isSameYearIf(Date aux){
		
		boolean igual = false;

		if(this.year == aux.getYear()){
			igual = true;
		}
		return igual;
	}

	public boolean isSameMonthIf(Date aux){
		
		boolean igual = false;

		if(this.month == aux.getMonth()){
			igual = true;
		}
		return igual;
	}

	public boolean isSameDayIf(Date aux){
		
		boolean igual = false;

		if(this.day == aux.getDay()){
			igual = true;
		}
		return igual;
	}

	public boolean isSameIf(Date aux){
		
		boolean igual = false;

		if(this.year == aux.getYear() && this.month == aux.getMonth() && this.day == aux.getDay()){
			igual = true;
		}
		return igual;
	}

	public boolean isSameYear(Date aux){
		
		boolean igual = false;

		igual = (this.year == aux.getYear());
			
		
		return igual;
	}

	public boolean isSameMonth(Date aux){
		
		boolean igual = false;

		igual=(this.month == aux.getMonth());
		return igual;
	}

	public boolean isSameDay(Date aux){
		
		boolean igual = false;

		igual=(this.day == aux.getDay());

		
		return igual;
	}

	public boolean isSame(Date aux){
		
		boolean igual = false;

		igual=(this.year == aux.getYear() && this.month == aux.getMonth() && this.day == aux.getDay());
		return igual;
	}
	
	public String getNameOfMonth(){

		int n = this.getMonth();
		String month = "";

		switch(n){
		
			case 1:
				month = "Enero";
				break;
			
			case 2:
				month = "Febrero";
				break;
			
			case 3:
				month = "Marzo";
				break;
			
			case 4:
				month = "Abril";
				break;

			case 5:
				month = "Mayo";
				break;
		
			case 6:
				month = "Junio";
				break;
			
			case 7:
				month = "Julio";
				break;
			
			case 8:
				month = "Agosto";
				break;
			
			case 9:
				month = "Septiembre";
				break;
	
			case 10:
				month = "Octubre";
				break;
		
			case 11:
				month = "Noviembre";
				break;

			case 12:
				month = "Diciembre";
				break;

		}

		return month;
	}

	public boolean rightDay(){

		boolean aux = true;
		int day = this.getDay();
		if(day > this.getDaysOfMonth() || day < 1){
			aux = false;
		}

		return aux;

	}

	public String season(){

		String season = "";

		switch(this.month){

			case 1: //next
			case 2: //next
			case 3: 
				season="Winter";
				break;

			case 4: //next
			case 5: //next
			case 6:
				season="Spring";
				break;

			case 7: //next
			case 8: //next
			case 9:
				season="Summer";
				break;

			case 10: //next
			case 11: //next
			case 12:
				season="Autumn";
				break;

		}

		return season;

	}

	public int monthsUntilEndOfYear(){

		return 12-this.getMonth();
	}

	public int daysUntilEndOfMonth(){

		int day =this.getDay(), i=0;
	
		while(day<this.getDaysOfMonth()){
			i++;
			day++;

		}	

		return i;

	}

	public String sameDaysOfMonths(){

		String months;
	
		if(this.getDaysOfMonth()==31){
			
			months = "Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre";
		}else if(this.getDaysOfMonth() == 30){
			months = "Abril, Junio, Septiembre, Noviembre";
		}else{
			months = "Febrero";
		}

		return months;
	}

	public int triesWhile(){

		int numIntentos=0;

		boolean acierto=false;
		
		while(!acierto){

			int diaR=(int)(Math.random()*31+1); 
			int mesR=(int)(Math.random()*12+1);

			if(diaR==this.getDay()&&mesR==this.getMonth()){ 
				acierto=true;
			}else if(diaR!=this.getDay()||mesR!=this.getMonth()){
				numIntentos++;	
			}
		}
		return numIntentos;
	}

	public int triesDoWhile(){

		int numIntentos=0;

		boolean acierto=false;
		
		do{

				int diaR=(int)(Math.random()*31+1); 
				int mesR=(int)(Math.random()*12+1);

				if(diaR==this.getDay()&&mesR==this.getMonth()){ 

				acierto=true;

				}

				else if(diaR!=this.getDay()||mesR!=this.getMonth()){

					numIntentos++;	

				}

		}while(!acierto);

		return numIntentos;
	
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
