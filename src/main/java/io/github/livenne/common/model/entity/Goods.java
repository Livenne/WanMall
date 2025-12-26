package io.github.livenne.common.model.entity;

import io.github.livenne.annotation.orm.Entity;
import io.github.livenne.annotation.orm.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity("goods")
public class Goods {
    @Id
    private Long id;
    private Long sales;
    private Double price;
    private Long discount;
    private Long inventory;
    private String name;
    private String type;
    private String args;
    private String addr;
    private String cover;
    private String pictures;
    private String description;
}
