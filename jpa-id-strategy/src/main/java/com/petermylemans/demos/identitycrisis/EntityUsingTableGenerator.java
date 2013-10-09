package com.petermylemans.demos.identitycrisis;

import javax.persistence.*;

@Entity
public class EntityUsingTableGenerator {

    @Id
    @TableGenerator(name = "EntityUsingTableGeneratorId", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "EntityUsingTableGeneratorId")
    private Long id;

    private String someColumn;

}
