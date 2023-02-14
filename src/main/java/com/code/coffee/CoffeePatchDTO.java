package com.code.coffee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Pattern;
import java.util.Optional;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // 응답으로 null 노출 안함
public class CoffeePatchDTO {
    private long coffeeId;
    private Optional<@Pattern(regexp = "^[a-zA-Z](\\s?[a-zA-Z])*$") String> engName;
    private Optional<@Pattern(regexp = "^[가-힣]+$") String> KorName;
    private Optional<@Range(min = 1000,max = 50000) Integer> price;
    // 선택적 포함으로 변경
}
