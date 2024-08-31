package com.springtesting.testing;

import com.springtesting.testing.Entity.Testing;
import com.springtesting.testing.Global.IdAlreadyExist;
import com.springtesting.testing.Global.InvalidAge;
import com.springtesting.testing.Global.NoElementFound;
import com.springtesting.testing.repository.TestingRepository;
import com.springtesting.testing.service.TestingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ServiceTest {
    @Mock
    TestingRepository repository;

    @InjectMocks
    TestingService services;

    @BeforeEach
    void setmock(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testadd() throws IdAlreadyExist, InvalidAge{
        Testing expected = new Testing(1, "Jack", 19, "Male", "HR", 2024, 40000.00);
        when(repository.save(expected)).thenReturn(expected);
        Testing actual = services.addData(expected);
        assertEquals(expected, actual);
    }
//    @Test
//    void testAddAll() throws  InvalidAge{
//        Testing entity1 = new Testing(1, "Jack", 19, "Male", "HR", 2024, 40000.00);
//        Testing entity2 = new Testing(2, "Lenovo", 44, "Female", "Purchase", 2022, 22222.00);
//        List<Testing> list = Arrays.asList(entity1, entity2);
//        when(repository.saveAll(list)).thenReturn(list);
//        List<Testing> result1 = services.addAllData(list);
//        assertEquals(list, result1);
//    }
    @Test
    void testAddAll() {
        Testing entity1 = new Testing(1, "Jack", 19, "Male", "HR", 2024, 40000.00);
        Testing entity2 = new Testing(2, "Lenovo", 44, "Female", "Purchase", 2022, 22222.00);
        List<Testing> list = Arrays.asList(entity1, entity2);
        when(repository.saveAll(list)).thenReturn(list);
        List<Testing> result1 = services.addAllData(list);
        assertEquals(list, result1);
    }
    @Test
    void testFindById() throws NoElementFound {
        Testing entity3 = new Testing(1, "Jack", 19, "Male", "HR", 2024, 40000.00);
        when(repository.findById(1)).thenReturn(Optional.of(entity3));
        Testing result2 = services.getById(1);
        assertEquals(entity3, result2);
    }
    @Test
    void testFindAll(){
        Testing entity4 = new Testing(1, "Jack", 19, "Male", "HR", 2024, 40000.00);
        Testing entity5 = new Testing(2, "Lenovo", 44, "Female", "Purchase", 2022, 22222.00);
        List<Testing> list2 = Arrays.asList(entity4, entity5);
        when(repository.findAll()).thenReturn(list2);
        List<Testing> result4 = services.getAll();
        assertEquals(list2, result4);
    }
}
