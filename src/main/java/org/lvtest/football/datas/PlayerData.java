package org.lvtest.football.datas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerData {

    private Long id;

    private String name;

    private String lastname;

    private String nationality;

    private Integer age;

    private String team;
}
