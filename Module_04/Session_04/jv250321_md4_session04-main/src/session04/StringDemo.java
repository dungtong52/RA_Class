package session04;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hello World";
        str1.concat(" xin chào");
        System.out.println(str1);
        StringBuilder str3 = new StringBuilder("Hello World");
        str3.append(" xin chào");
        System.out.println(str3);
        String str10 = str3.toString();
        //Literal --> primitive --> String pool --> Immutable
        String str4 = "Rikkeisoft";
        String str5 = "Rikkeisoft";
        //Object --> reference --> Heap --> Mutable
        String str6 = new String("Rikkeisoft");
        String str7 = new String("Rikkeisoft");
        //So sánh với equals
        System.out.println("So sánh str4 và str5 với equals: " + str4.equals(str5));//true
        System.out.println("So sánh str4 và str6 với equals: " + str4.equals(str6));//true
        System.out.println("So sánh str6 và str7 với equals: " + str6.equals(str7));//true
        //So sánh với ==
        System.out.println("So sánh str4 và str5 với ==: " + (str4 == str5));//true
        System.out.println("So sánh str4 và str6 với ==: " + (str4 == str6));//false
        System.out.println("So sánh str6 và str7 với ==: " + (str6 == str7));//false

        System.out.println("Độ lệch 2 chuỗi: " + "ABC".compareTo("AD"));
        System.out.println("Chuỗi đảo ngược của str3: " + str3.reverse());


    }
}
