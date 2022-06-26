package basic.ex04;

import java.util.Arrays;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ct =
				new GenericXmlApplicationContext("classpath:auto-config.xml");
		
		Printer printer = ct.getBean("prt", Printer.class);
		printer.showPaperInfo();
		
		System.out.println("-----------------------------------");
		
		Book book = ct.getBean("book", Book.class);
		String data = Arrays.toString(book.getPaper().data);
		System.out.println(data);

		ct.close();
	}

}
