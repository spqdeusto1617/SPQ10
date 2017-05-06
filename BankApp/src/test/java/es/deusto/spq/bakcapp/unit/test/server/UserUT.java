package es.deusto.spq.bakcapp.unit.test.server;

import bankapp.server.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.validation.*;
import java.util.Set;

public class UserUT {

    protected static Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validUser() {
        User user = new User();

        user.setEmail("email@example.com");
        user.setPass("password");
        user.setUsername("username");

        assertTrue(user != null);
        assertThat(user.getEmail(), is("email@example.com"));
        assertThat(user.getPass(), is("password"));
        assertThat(user.getUsername(), is("username"));
    }

    /* TODO - review validation fields annotations */
    @Test(expected = ConstraintViolationException.class)
    public void invalidUser() {
        User user = new User("", "", "");
        assertTrue(user != null);
        assertFalse(validate(user).isEmpty());
    }

    public static <T> Set<ConstraintViolation<T>> validate(T obj) {
        return validator.validate(obj);
    }
}
