package web;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

@Data
public class Dog {

    private String name;
    private String type;
    private String color;
}
