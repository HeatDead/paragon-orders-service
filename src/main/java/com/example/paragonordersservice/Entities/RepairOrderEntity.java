package com.example.paragonordersservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repairs_orders")
public class RepairOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long car_id;
    private String user_id;

    private String description;

    private Date order_date;
    private Date finish_date;

    private Long work_type;

    private String result;

    private Double price;
}
