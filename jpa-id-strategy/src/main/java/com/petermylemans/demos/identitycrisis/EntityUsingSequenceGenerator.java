package com.petermylemans.demos.identitycrisis;

import javax.persistence.*;

@Entity
public class EntityUsingSequenceGenerator {

        @Id
        @SequenceGenerator(name = "EntityUsingSequenceGenerator", sequenceName = "EntityUsingSequenceGenerator",
                           allocationSize = 100, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EntityUsingSequenceGenerator")
    private Long id;

    private String someColumn;
}
