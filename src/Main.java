import java.util.Scanner;

class Main{
   public static void main(String[] args) {
      int ch;

      Scanner scn = new Scanner(System.in);
      Cryptography cpt = new Cryptography();
      
         cpt.getSeckeyUser();
      do{
         try{
         System.out.println("\n1.encrypt message\n2.decrypt message\n0.Exit\nchoose your option:");
         ch = scn.nextInt();

         if (ch == 0) break;

         cpt.getMessageUser();
         switch (ch) {

            case 1:
                  System.out.println("\nThe encrypted message is:"+cpt.encrypt());
                  break;
            case 2:
                  System.out.println("\nThe decrypted message is:"+cpt.decrypt());
                  break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }

   }while(true);

   }
}
   
