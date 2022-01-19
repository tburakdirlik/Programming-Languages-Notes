package com.spring.restservices2;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;

@SpringBootApplication
public class RestServices2Application {

    public static void main(String[] args) {
        SpringApplication.run(RestServices2Application.class, args);
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
@Getter
@Setter
class MemberRequest{

    @NotNull
    private String name;

}
//----------------------------------------------------------------------------------------------------------------------
@Getter
@Setter
@Builder
class MemberResponse{

    private Long memberId;
    private String name;
}
//-------------------------------------------------localhost:8080/members-----------------------------------------------
@RestController
class Controller{
    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createMeember(@RequestBody MemberRequest request){
        return MemberResponse.builder()
                .name(request.getName())
                .memberId(89L)
                .build();
    }
}
/*
SEND --> RAW - JSON
                        {
                            "name": "tunahan"
                        }


RESPONSE
                        {
                            "memberId": 89,
                            "name": "tunahan"
                        }
*/
//----------------------------------------------------------------------------------------------------------------------