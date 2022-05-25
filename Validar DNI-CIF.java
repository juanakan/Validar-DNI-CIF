	public static boolean isDni(String dni) {
		if(!(dni.length()>=8 && dni.length()<=9)){
			return false;
		}
		String partNumeric = dni.substring(0,dni.length()-1);
		int dniNum;
		try{
			dniNum = Integer.parseInt(partNumeric);
		}catch(NumberFormatException e){
			return false;
		}
		char letter = dni.substring(dni.length()-1,dni.length()).toUpperCase().charAt(0);
		
		if( !(letter>='A' && letter<='Z') ){
			return false;
		}
		char letterNif[]= {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int rest = dniNum % 23;
		String newDni = dniNum+ "" + letterNif[rest];
		if(!(newDni.equals(dni))){
			return false;
		}
		return true;

	}
	
	 private static boolean isCif(String cif) {

		 if (cif != null) {
		 final String cifUP = cif.toUpperCase();

		 if ("ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1) {
		 return false;
		 }

		 final Pattern mask = Pattern
		 .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
		 final Matcher matcher = mask.matcher(cifUP);


		 if (!matcher.matches()) {
		 return false;
		 }

		 final char primerCar = cifUP.charAt(0);
		 final char ultimoCar = cifUP.charAt(cifUP.length() - 1);


		 String tipUltCar;

		 if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
		 tipUltCar = "L";
		 if (!(ultimoCar >= 'A' && ultimoCar <= 'Z')) {
		 return false;
		 }

		 } else if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E'
		 || primerCar == 'H') {
		 tipUltCar = "N";
		 if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
		 return false;
		 }

		 } else {
		 tipUltCar = "A";
		 }


		 final String digitos = cifUP.substring(1, cifUP.length() - 1);

		 Integer sumaPares = 0;
		 for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
		 sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
		 }

		 Integer sumaImpares = 0;
		 for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
		 Integer cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
		 if (cal.toString().length() > 1) {
		 cal = Integer.parseInt(cal.toString().substring(0, 1))
		 + Integer.parseInt(cal.toString().substring(1, 2));
		 }
		 sumaImpares += cal;
		 }

		 final Integer total = sumaPares + sumaImpares;

		 Integer numControl = 10 - (total % 10);

		 int pos = numControl == 10? 0:numControl; 

		 final char carControl = "JABCDEFGHI".charAt(pos);

		 if (tipUltCar.equals("N")) {

		 final Integer ultCar = Integer.parseInt(Character
		 .toString(ultimoCar));
		 if (pos != ultCar.intValue()) {
		 
		 return false;
		 }

		 } else if (tipUltCar.equals("L")) {
		 if (carControl != ultimoCar) {
		 return false;
		 }

		 } else { 

		 Integer ultCar = -1;

		 ultCar = "JABCDEFGHI".indexOf(ultimoCar);
		 
		 if (ultCar < 0){
		 ultCar = Integer.parseInt(Character.toString(ultimoCar));
		 if (pos != ultCar.intValue()) {
		 return false;
		 }
		 }
		 if ((pos != ultCar.intValue()) && (carControl != ultimoCar)) {
		 return false;
		 }
		 }
		 return true;
		 }
		 return false;
		 }
	

