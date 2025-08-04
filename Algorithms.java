import java.util.*;
import java.time.LocalDate;

public class Algorithms {
    Random r;
    Algorithms(){
        r = new Random();
    }
public String generateTktUid(){
char [] c = new char[10];
String s;
for(int i=0; i<6; i++){
    c[i]= (char)(r.nextInt(48,58));
}
for(int j=6; j<10; j++){
    c[j]= (char)r.nextInt(65,91);
} 
s = new String(c);
return s;
}
public static String [] getDates(int n){
 String dates [] = new String[n];
 LocalDate currentDate = LocalDate.now();
 for(int i=0; i<n; i++){
    dates[i] = currentDate.plusDays(i).toString();
 }
 return dates;
}
public static void main(String[] args) {
    Algorithms a = new Algorithms();
    System.out.println(a.generateTktUid());

    String [] str = Algorithms.getDates(3);
    for(String e: str){
        System.out.println(e);
    }
}



}