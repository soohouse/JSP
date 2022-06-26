package basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Book {
	
		/*
		 # @Resource
		 - 빈을 자동으로 주입하는 아노테이션 입니다.
		 - 필드, 메서드에만 적용이 가능하며, 생성자에는 적용이 불가능합니다.
		 - name 속성을 통해 특정 bean의 id를 지목할 수 있습니다.
		  */

		
		//@Autowired
		@Qualifier
		//@resource(name="paper1") java8버전 이후에는 문법이 사라짐
		private Paper paper;
		
		public void setPaper(Paper paper) {
			this.paper = paper;
		}
		
		public Paper getPaper() {
			return paper;
		}
	}

