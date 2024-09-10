package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unisabana.dyas.tdd.Registry;

public class RegistryTest {
    private Registry registry;

    @Before
    public void setUp() {
        registry = new Registry();
    }

        @Test
    public void testVotanteValido() {
        Person person = new Person("Juan", 1234, 25, Gender.MALE, true);
        Assert.assertTrue(registry.registerVoter(person) == RegisterResult.VALID);
    }

    @Test
    public void testMenorEdad() {
        Person person = new Person("Maria", 5678, 17, Gender.FEMALE, true);
        Assert.assertFalse(registry.registerVoter(person) == RegisterResult.VALID);
    }

    @Test
    public void testEdadInvalida() {
        Person person = new Person("Jose", 9101, 121, Gender.UNIDENTIFIED, true);
        Assert.assertEquals(RegisterResult.INVALID_AGE, registry.registerVoter(person));
    }

    @Test
    public void testVotanteMuerto() {
        Person person = new Person("Santiago", 1122, 50, Gender.MALE, false);
        Assert.assertNotSame(RegisterResult.VALID, registry.registerVoter(person));
    }

        @Test
    public void testVotanteDuplicado() {
        Person person1 = new Person("Pepita", 3344, 30, Gender.FEMALE, true);
        Person person2 = new Person("Pepito", 3344, 35, Gender.MALE, true);
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertSame(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void testdebajolimitevalido() {
        Person person = new Person("Rosa", 5566, 17, Gender.FEMALE, true);
        Assert.assertFalse(registry.registerVoter(person) == RegisterResult.VALID);
    }

    @Test
    public void testLimiteinferiorvalido() {
        Person person = new Person("David", 7788, 18, Gender.MALE, true);
        Assert.assertEquals(RegisterResult.VALID, registry.registerVoter(person));
    }


}
