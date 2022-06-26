package basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

	//@Autowired
	private Keyboard keyboard;
	//@Autowired
	private Mouse mouse;
	//@Autowired
	private Monitor monitor;
	
	
	@Autowired
	public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
		super();
		this.keyboard = keyboard;
		this.mouse = mouse;
		this.monitor = monitor;
	}



	public void computerInfo() {
		System.out.println("*** 컴퓨터의 정보 ***");
		keyboard.info();
		mouse.info();
		monitor.info();
		
	}
}
