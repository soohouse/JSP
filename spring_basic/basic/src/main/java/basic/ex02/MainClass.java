package basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

   public static void main(String[] args) {

      GenericXmlApplicationContext ct =
            new GenericXmlApplicationContext("classpath:db-config.xml");
                  // classpath : src/main/resources를 한꺼번에 일컫는 뜻.
      
      MemberDAO dao = ct.getBean("dao", MemberDAO.class);
      dao.showDBinfo();
      
      ct.close();
   }

}
