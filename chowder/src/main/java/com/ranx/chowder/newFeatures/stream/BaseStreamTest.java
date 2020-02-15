package com.ranx.chowder.newFeatures.stream;


import java.util.Arrays;
import java.util.List;

/**
 * @author ranx
 * @create 2020-02-12 11:10
 **/
public class BaseStreamTest {

    protected static final List<Employee> list = Arrays.asList(
            new Employee(1, "Alex", 1000),
            new Employee(2, "Michael", 2000),
            new Employee(3, "Jack", 1500),
            new Employee(4, "Owen", 1500),
            new Employee(5, "Denny", 2000)
    );

    protected static final List<List<Employee>> listFlat = Arrays.asList(
            Arrays.asList(new Employee(1, "Alex", 1000),
                    new Employee(2, "Michael", 2000)
            ),
            Arrays.asList(new Employee(3, "Jack", 1500),
                    new Employee(4, "Owen", 1500)
            ),
            Arrays.asList(new Employee(5, "Denny", 2000))
    );
}
