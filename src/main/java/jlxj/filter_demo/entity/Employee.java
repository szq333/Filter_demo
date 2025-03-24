package jlxj.filter_demo.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String password;
}

