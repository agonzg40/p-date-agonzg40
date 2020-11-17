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

	public int daysOfYear(){

        int days= 0;
        int total = 0;

        try{

            Date aux = new Date (1,1,2020);

            for ( int i = 1; i <= this.month; i++){
                aux.setMonth(i);
                days = aux.getDaysOfMonth();
                total = total + days;
            }


        }catch(DateException e){}
        return  total;
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
			}else if(diaR!=this.getDay()||mesR!=this.getMonth()){
				numIntentos++;	
			}
		}while(!acierto);
		return numIntentos;
	}

	public String dateToString(){
		String month, fecha;
		month = this.getNameOfMonth();
		int day = this.getDay();
		int year = this.getYear();
		fecha = day+"/"+month+"/"+year;
    		return fecha;
	}

		
	public String dayOfWeek(int dia){
		int suma = dia;
		String diaS ="";
		try{
			Date date = new Date(this.day, this.month, this.year);
			
		//Para tener en cuenta los años bisiestos
		if((((this.year%4 == 0) && (this.year%100 != 0)) || (this.year%400 == 0))&& (this.month>2)){ 
			
			for(int i = 1; i <date.passedDays()+1;i++){
				suma = suma + 1;
					if(suma == 8){
						suma = 1;
					}
			}
		}else{
			
			for(int i = 1; i <date.passedDays();i++){
				suma = suma + 1;
				if(suma == 8){
					suma = 1;
				}
			}
		}
		switch(suma){
			case 1:
				diaS="Lunes";
				break;
			case 2:
				diaS="Martes";
				break;
			case 3:
				diaS="Miercoles";
				break;
			case 4:
				diaS="Jueves";
				break;
			case 5:
				diaS="Viernes";
				break;
			case 6:
				diaS="Sabado";
				break;
			case 7:
				diaS="Domingo";
				break;
		}
		}catch(DateException e){}
		return diaS;
	}

		public int passedDays(){
		int suma = this.day;
		
		for(int i = 1;i<this.month;i++){
			suma = suma + p_getDaysOfMonth(i);
		}
		return suma;
	}

	private int p_getDaysOfMonth(int mes){
		int day = 0;
		
		switch(mes){
			
			case 1: //Next
			case 3: //Next
			case 5: //Next
			case 7: //Next
			case 8: //Next
			case 10: //Next
			case 12:
				day = 31;
				break;
			case 4: //Next
			case 6: //Next
			case 9: //Next
			case 11:
				day = 30;
				break;
			case 2:
				day = 28;
				break;
		}
		return day;
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
