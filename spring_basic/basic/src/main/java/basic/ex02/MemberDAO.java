package basic.ex02;

public class MemberDAO {

   private DataBaseInfo dbInfo;
   
   public void setDbInfo(DataBaseInfo dbInfo) {
      this.dbInfo = dbInfo;
   }
   
   public void showDBinfo() {
      System.out.println("URL: " + dbInfo.getUrl());
      System.out.println("URL: " + dbInfo.getUid());
      System.out.println("URL: " + dbInfo.getUpw());
   }
   
    
}