package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class DocumentsTypes {
    @Id
    private String id;

    @Column()
    private String name;
}
