//                                                  2. HAFTA CUMARTESİ

package com.spring.restservices;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.jmx.export.metadata.ManagedMetric;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Map;
import java.util.Set;

//----------------------------------------------------------------------------------------------------------------------
@SpringBootApplication
public class RestServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServicesApplication.class, args);
    }

}
//----------------------------------------------------------------------------------------------------------------------
@Getter
@Setter
@Builder
class Member {

    private Long memberId;
    private String name;

}
//----------------------------------------------------------------------------------------------------------------------
@RestController
class HelloWorldController{

            //------------------------------------------localhost:8080/hello--------------------------------------------

            //@RequestMapping(method = RequestMethod.GET, value = "/hello")   bu eski usül yöntem genelde bu kullanılmaz
            @GetMapping("/hello")
            public String sayHello(){
                return "hello world";
            }
            //-------------------------------------------localhost:8080/members-----------------------------------------

            //@GetMapping("/get-members") bu kullanım yok
            @GetMapping("/members")
            public List<Member> retrieveMembers(){
                return List.of(
                        Member.builder()
                                .memberId(12L)
                                .name("tunahan")
                                .build(),
                        Member.builder()
                                .memberId(13L)
                                .name("burak")
                                .build()
                );
            }
            //--------------------------------------------localhost:8080/members2---------------------------------------
            @GetMapping("/members2")
            public Set<Member> retrieveMembers2(){
                return Set.of(
                        Member.builder()
                                .memberId(12L)
                                .name("tunahan")
                                .build(),
                        Member.builder()
                                .memberId(13L)
                                .name("burak")
                                .build()
                );
            }
            //--------------------------------------------localhost:8080/members3---------------------------------------
            @GetMapping("/members3")
            @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 döndürür ama datayı da gösterir
            //@ResponseStatus(HttpStatus.OK) Hiçbirşey yazmazsan soldakini yazmış gibi davranır
            //Mantık genelde, içerde hata alıyorsam 500 döneyim almıyorsam ok döneyimdir
            public Set<Member> retrieveMembers3(){
                return Set.of(
                        Member.builder()
                                .memberId(12L)
                                .name("tunahan")
                                .build(),
                        Member.builder()
                                .memberId(13L)
                                .name("burak")
                                .build()
                );
            }
            //---------------------------------------------localhost:8080/members4/15000---------------------------------
            //rest conventionlarına göre spesific bir member ı alma şekli aşağıdaki gibidir
            @GetMapping("/member4/{memberId}")
            public Member retrieveMembers4(@PathVariable Long memberId){
                return Member.builder()
                        .memberId(memberId)
                        .name("burak")
                        .build();
            }
            //---------------------------------------------localhost:8080/members5/12------------------------------------

            @DeleteMapping("/member5/{memberId}")
            @ResponseStatus(HttpStatus.NO_CONTENT) // Status 204: No Content, ben burda metotun boş döneceğini söylemiş oluyorum
            public void deleteMember(@PathVariable Long memberId){
                //eğer metot void dönüyorsa @ResponseStatus --> HttpStatus.NO_CONTENT olur.
                //metotun void olması body nin 0 olduğunu gösterir ama response size 0 değildir burda 112 byte mesela
            }
            //-----------------localhost:8080/members    veya    localhost:8080/members?name=tunahan&id=12--------------

            /*body gönderiyorsam @RequestBody yazmam gerekiyor
             request body yazmazsam bu classları url e yerleştirmeye çalışır */
            @PostMapping("/members")
            @ResponseStatus(HttpStatus.CREATED)
            public Member createMember(@RequestBody Member member){
                return Member.builder()
                        .name(member.getName())
                        .memberId(12L)
                        .build();
            }
             /*

            POST --> localhost:8080/members    veya    localhost:8080/members?name=tunahan&id=12

                                                                                          ______________________________
                                                                                          |                            |
                                                                                          |   {                        |
                                                RAW FORMATINDA GÖNDERDİĞİM BODY -->       |         "name": "tunahan"  |
                                                                                          |   }                        |
                                                                                          |____________________________|

                                                                                          ______________________________
                                                                                          |                            |
                                                                                          |  {                         |
                                                 DÖNEN CEVAP                    -->       |      "memberId": 12,       |
                                                                                          |      "name": "tunahan"     |
                                                                                          |                            |
                                                                                          |   }                        |
                                                                                          |____________________________|



            produces response un tipi hangi tipte olacak onu gösteriyor
            consumes metotun aldığı parametre hangi tipte olacak onu göösteriyor
            rest http nin belirli kurallarla uygulanmış halidir
            her rest servis http servisdir aynı zamanda, ama her http servis rest değildir.
            rest aslında bir mimari stildir.
            Http nin daha derli toplu uygulanmış halidir.
            bittorrent mimarisi incele

            spring boot application hiyerarşik olarak kendisiyle aynı seviyede olan veya
            alt paketlerde olan componentleri bulur ve contextlerine ekler

            @Configuration


            endpoint = dışardan erişebildiğim bir nokta
            spring boot uygulamaları default olarak 8080 portunu kullanır
            aynı pc de 2 tane spring boot uygulaması varsa bir tanesinin port numarasını değiştirmem
            gerekir.

            Bu eski kullanım --> @RequestMapping(method = RequestMethod.GET, value = "/hello")
            Bu yeni kullanım --> @GetMapping("/hello")
            ikisi de aynı

            long integer bunlar javanın kendi dünyasına ait kavramlar.
            Json diyo ki sayımısın değilmisin kardeşim bana onu söyle text misin değil misin
            Json için listin veya setin de bir önemi yok. set dönmek veya list dönmek json için farketmiyor
            json kullanmak spring bootun default davranışı

              */
            //----------------------------------------------------------------------------------------------------------
            @PostMapping("/members/{memberId}")
            @ResponseStatus(HttpStatus.CREATED)
            public Member createMember4(@RequestBody Member member,
                                        @RequestHeader("deneme-header") String header,
                                        @PathVariable Long memberId,
                                        @RequestParam(required = false) String memberName
                                        ){
                                                    return Member.builder()
                                                            .name(member.getName())
                                                            .memberId(12L)
                                                            .build();
                                         }

            /*
                                        POST --> localhost:8080/members/12?memberName=tunahan
                                                 localhost:8080/members/12   yukardakiyle yandaki aynı şey mi bunu sor

                                        Query Params
                                            KEY		VALUE
                                            memberName	tunahan

                                        HEADERS
                                            KEY		VALUE
                                            deneme-header	1-2-3

                                        BODY
                                            {
                                                    "name": "tunahan"
                                            }
            @RequestParam null olamaz metot içine koyduysan göndermek zorundasın ,
            @Pathvariable kullanılmak zorunda çünkü url i şekilllendiriyor
            @RequestParam(required=false) String memberName --> bu optional oluyor, memberName i ister gönder ister gönderme
            @Requestbodt nin gelmesini sağlayan şey gönderdiğim body di
            @RequestHeader ın gelmesii sağlayan şey verdiğim headerlardı
            @Pathvariable ın gelmesini sağlayan şey url deki 12
            @Requestparamın gelmesini sağlayan şey ? den sonraki key value çiftydi  --> memberName=tunahan
            requestbody çoğunlukla post isteklerinde kullanılır, urlde taşımak istemeyeceğimiz,
            
            hassas bilgileri bunla taşırsın mesela, data bi yere yazılacaksa kullanılır.
            request paramla geleln bilgileri ben bi yere kaydtemiyorum, datayyı updateetmek için kullanmıyorum
            requestparamla sorgulama yaparsın genelde 
            pathvariable urlden bi değer çekmek için --> >url yzılan değişkne ismiyle eşleşir.
            postmapping ve requestparam birlikte kullanmıcaz çoğu zaman
            postmappinng ve requsetbody çoğu zaman beraber
            ? demek benim url im bitti query paramtresi geçmeye başıcam demektir.
            validasyon koycaksak @Valid koymamız gerekiyor
            @Valid null gönderiyorsam eğer bunu engellemeye çalışır  
            @Valid, içerde validasyonlar var mapleme yapmadan önce onları kontrol et demeye yarıyo
            Tek başına @Valid veya tek başına @NotNull yeterli değil
            @NotBlank bana boş string gönderme demek

                @NotBlank
                private String name;
            kullanımı da yukardaki gibi
            @NotEmpty den white spaceler geçiyor
            
before that commit 5fc9d67 
            */
//----------------------------------------------------------------------------------------------------------------------
}

