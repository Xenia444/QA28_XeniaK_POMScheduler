package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class EventDto {
    String title;
    String type;
    int breaks;
    int wage;
}
