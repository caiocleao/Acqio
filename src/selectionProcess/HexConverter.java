package selectionProcess;

public class HexConverter {

	
	/*
	
		Respostas teoricas:  
		
		Como as perguntas e o teste estão em inglês, as respostas também estarão em inglês.
	  
	  	3. Why JSON is better than XML?
	  	A: JSON has many advantages over XML. It is much easier to parse, in fact it can be parsed by a standart Javascript function,
	  	while XML requires it's own parser it can still be parsed by many programing languages. JSON is also shorter, quicker on operations 
	  	of read/write and can use arrays. 
	  	
	  	That said there are still similarities between then. Both are self describing, hierarchical, can be parsed by multiple languages 
	  	and can be fetched via a XMLHttpRequest. 
	  
	  	4. 4. The most significant improvement HTTP 1.1 introduced over HTTP 1.0 was persisted connection by default. Why that made a difference? 
	  	A: The most significant improvement was allowing for more than one request/response per HTTP connection.
	  
	  	5. When a table column is defined as UNIQUE, most DB system automatically create an index for that column. Why?
	  	A: As many database management systems allow for the creations of tables without a primary key, having this property increases efficiency on
	  	queries.  The only instance that a column with the UNIQUE property set as true can have multiple rows with the same value is if they are set to null. 
	  	Unique guarantees that no other entry will be equal IF set, but a row from a unique column can be null and we can have multiple null rows.
	  	
	  	
	 */
	
	public static void main(String[] args) {
		
		String hexValue = "C921";
		int decValue = hexToDec(hexValue);
		System.out.println(decValue);
		
		int[] list = new int[5];
		list[0] = 1;
		list[1] = 10;
		list[2] = 3;
		list[3] = 7;
		list[4] = 9;
		
		int[] bigNums = biggestSum(list);
		System.out.println( bigNums[0] + " " + bigNums[1]);
		
	}
	
	public static int[] biggestSum ( int[] list ) {
		
		int[] bigNumbers = new int[2];
		
		int biggest = 0;
		int secondBiggest = 0;
		
		for ( int i = 0; i < list.length; i++ ) {
			
			if ( list[i] > biggest ) {
				biggest = list[i];
			} else if ( list[i] > secondBiggest ) {
				secondBiggest = list[i];
			}
			
		}
		
		bigNumbers[0] = biggest;
		bigNumbers[1] = secondBiggest;
		
		return bigNumbers;
	}
	
	public static int hexToDec ( String hexValue ) {
		
		hexValue = hexValue.toUpperCase();
		
		int currentValue;
		int totalValue = 0;
		int j = 0;
		for ( int i = hexValue.length()-1; i >= 0; i-- ) {
			
			currentValue = getDecimalValueOfChar(hexValue.charAt(i));
			totalValue += currentValue * ( Math.pow(16, j) );
			j++;
		}
		
		
		return totalValue;
	}
	
	public static int getDecimalValueOfChar ( char c ) {
		
		// Checa valor Ascii para os intervalos de 0-9 e A-F 
		if ( c >= 48 && c <= 57 ) {
			int test = c - 48;
			return test;
		} else if ( c >= 65 && c <= 70) {
			
			int test = 10 + ( c % 65 );
			return test;
			
		}
		
		// -1 Sendo o valor de retorno para um digito fora da base hexadecimal
		return -1; 
	}
	
	
}
