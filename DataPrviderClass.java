	package example;
	import org.testng.annotations.DataProvider;
	
	public class DataPrviderClass {
	        @DataProvider(name="testMethod")
	        public static Object[][] getDataFromDataprovider(){
	            return new Object[][] {
	                { "John", "john1992" },
	                { "Harry", "harry123" },
	                { "Emy", "emy123"}
	            };  
	}
	}

