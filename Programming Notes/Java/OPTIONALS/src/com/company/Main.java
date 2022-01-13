package com.company;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<Double> empty = Optional.empty(); // Değer içermeyen Opt
        Optional<String> of = Optional.of("Merhaba Dünya"); // String türünden değer içeren bir Opt
        Optional<Integer> ofNullable = Optional.ofNullable(null); // null kabul eder istisna fırlatmazz
        //Optional<String> ofNull = Optional.of(null); // null kabul etmez istisna fırlatır.,

        /*
        #ifPresent – Varsa yap, yoksa yapma
        Eğer bir Optional içinde sadece veri varsa (null değilse) bir işin yapılması isteniyorsa #ifPresent metodu kullanılabilir.
        #ifPresent metodu Consumer<T> fonksiyonel arayüzü türünden bir nesne kabul etmektedir.
        Örneğin bir sayının karesini almaya çalışalım. Kullanılan değişken null değerini referans ediyorsa NullPointerException istisnası alınacaktır.

        ________________________________________________________
        |       Integer numara = null;                          |
        |       Double karesi = Math.pow(numara , 2); //(1)     |
        |       System.out.println("Sonuç: " + karesi);         |
        |_______________________________________________________|______________________________________________________________________________________________________________________________
        |                                                                                                                                                                                     |
        | OUTPUT --> Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "numara" is null at com.company.Main.main(Main.java:29)  |
        |_____________________________________________________________________________________________________________________________________________________________________________________|
        |                                                                   |
        | 1 -> Exception in thread “main” java.lang.NullPointerException    |
        | Bu istisna için if deyimiyle karşı önlem alınabilir.              |
        |___________________________________________________________________|

        */
        Integer num = null;

        if(num != null) {

            Double karesi = Math.pow(num, 2);

            System.out.println("Sonuç: " + karesi);

        }
        /*
        Fakat if deyimiyle birlikte ! , == , != ifadelerini kullanmak akıcı bir geliştirim deneyimi sunmaz.
        Ayrıca bu durum hata yapılmasına daha açıktır.
        Bunun yerine Optional#ifPresent metodunu kullanabiliriz.
        */

        Integer NUMBER = null;
        Optional<Integer> opt = Optional.ofNullable(NUMBER);
        opt.ifPresent(number -> {
            Double power2 = Math.pow(num , 2);
            System.out.println("Sonuç: " + power2);
        });

        /*

        ______________________________________________________________________________________________________________________________________________________
        |                                                                                                                                                       |
        |Parametre	        Açıklama                                                                                                                          |
        |                                                                                                                                                       |
        |isPresent()  -->	null kontorülüdür. Boş ise false, Dolu ise true değerini döndürür.                                                                |
        |orElse()	  -->   kullanici.get().ad().orElse(“burak”) şeklinde bir şart ile true ya da false değer döndürerek gerekli nesneyi seçebilirsiniz       |
        |orElseGet()  --> 	Nesne içerisinde eğer bir değer null ise varsaydığımız değeri göndeerebiliyoruz.                                                  |
        |ifPresent()  -->	Eğer null değilse istediğimiz işlemleri ise bu parametre ile yapmaktayız.                                                         |
        |_____________________________________________________________________________________________________________________________________________________  |

        */
    }
}
class OPTIONAL_WITH_MAP {
    public static void main(String[] args) {
        /*Optional nesnelerinin sarmaladığı veriler üzerinde dönüştürüm yapılabilmektedir. Bir önceki örneği bu şekilde yeniden yazabiliriz.
         */
        Integer numara = null;
        Optional<Integer> opt = Optional.ofNullable(numara);
        opt
                .map(num -> Math.pow(num, 2))
                .ifPresent(System.out::println);
    }
}

class FILTER {
    public static void main(String[] args) {

/*
Optional nesnelerinin sarmaladığı veriler üzerinde süzme işlemi de yapılabilmektedir.
Örneğin aşağıdaki kod parçası yerine;
*/
        String message = null;
        if (message != null)
            if (message.length() > 5)
                System.out.println(message);
//Aşağıdaki Optional karşılığını kullanabiliriz.

        String message2 = "tunahan burak dirlik";
        Optional<String> opt = Optional.ofNullable(message2);

        opt
                .filter(m -> m.length() > 5)
                .ifPresent(System.out::println);
    }
}

class ORELSE {
    public static void main(String[] args) {

/*
orElse metodu daha çok ternary (üçlü) şart ihtiyacı olduğu durumlarda ihtiyaç duyulabilir.
Daha akıcı bir geliştirim deneyimi sunar. numara null değilse numarayı döndür, null ise 0 döndür.
*/
        Integer numara = null;
        int result = (numara != null) ? numara : 0;
        System.out.println(result);

//Yukarıdaki üçlü şartı orElse ile birlikte kullanabiliriz.
        Integer num = null;

        Optional<Integer> opt = Optional.ofNullable(num);

        System.out.println(opt.orElse(0));

    }
}
