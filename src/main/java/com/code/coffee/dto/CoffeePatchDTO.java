package com.code.coffee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // 응답으로 null 노출 안함
public class CoffeePatchDTO {
    private long coffeeId;
//    private Optional<@Pattern(regexp = "^[a-zA-Z](\\s?[a-zA-Z])*$") String> engName;
//    private Optional<@Pattern(regexp = "^[가-힣]+$") String> KorName;
//    private Optional<@Range(min = 1000,max = 50000) Integer> price;
    // 선택적 포함으로 변경
    // -> 바디가 2개 이상이면  에러
@Pattern(regexp = "^[a-zA-Z](\\s?[a-zA-Z])*$",
        message = "영어로만 이루어져 있어야하며 문자 사이에만 공백 한 번 가능합니다.")
    private String engName;
    @Pattern(regexp = "^[가-힣]+$",
            message = "한글로만 이루어져 있어야 하며, 공백이 없어야 합니다.")
    private String korName;
    @Range(min = 1000,max = 50000,
            message = "가격은 1000 이상 50000 이하여야 합니다.")
    private Integer price;
}
//엥 아니 이거 그냥 아니 아... 이거 그냥 @Pattern 자체가 선택적으로 적용되고 요청 바디에 있으면 돌아가고 없으면 안돌아가고
//계속 price 쪽에 문제 있는건 알았는데 왜 그런가 했더니
//int 형은 값이 없으면 0이 되버리고 그럼 1000~50000 에 걸려서 자꾸 400 배드 리퀘스트 뜨는 거였음
//그래서 값 없으면 null 리턴하는 Integer 타입으로만 바꿔주면 해결됨 하..참내...