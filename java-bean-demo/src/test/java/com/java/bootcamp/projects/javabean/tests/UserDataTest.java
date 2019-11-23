package com.java.bootcamp.projects.javabean.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bootcamp.projects.javabean.UserDataImmutable;
import com.java.bootcamp.projects.javabean.UserDataMutable;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDataTest {

    @Test
    public void testMutableUserDataDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/userdata.json");
        UserDataMutable userDataMutable = mapper.readValue(is, UserDataMutable.class);
        assertNotNull(userDataMutable);
        assertTrue(userDataMutable.getId() == 1234);
        assertEquals("john", userDataMutable.getUserName());
        assertEquals("admin", userDataMutable.getRole());
    }

    @Test
    public void testImmutableUserDataDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/userdata.json");
        UserDataImmutable userDataImmutable = mapper.readValue(is, UserDataImmutable.class);
        assertNotNull(userDataImmutable);
        assertTrue(userDataImmutable.getId() == 1234);
        assertEquals("john", userDataImmutable.getUserName());
        assertEquals("admin", userDataImmutable.getRole());
    }

    @Test
    public void testSerializationAndDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserDataMutable userDataMutable = new UserDataMutable();
        userDataMutable.setId(5555L);
        userDataMutable.setUserName("Jane");
        userDataMutable.setRole("ROLE");
        String jsonData = mapper.writeValueAsString(userDataMutable);
        UserDataMutable userDataMutableFromJson = mapper.readValue(jsonData, UserDataMutable.class);
        assertNotNull(userDataMutableFromJson);
        assertEquals(userDataMutable, userDataMutableFromJson);
    }

    @Test
    public void testEqualsAndHashCodeOfImmutable() {
        UserDataImmutable userData01 = new UserDataImmutable(123L, "Jack", "USER");
        UserDataImmutable userData02 = new UserDataImmutable(123L, "Jack", "USER");
        UserDataImmutable userData03 = new UserDataImmutable(555L, "Jack", "USER");
        UserDataImmutable userData04 = new UserDataImmutable(123L, "Jack", "USER");

        // test hashcode
        assertTrue(userData01.hashCode() == userData02.hashCode());
        assertTrue(userData01.hashCode() != userData03.hashCode());
        // test hashcode consistent behavior
        int hashcode01 = userData01.hashCode();
        int hashcode02 = userData01.hashCode();
        assertTrue(hashcode01 == hashcode02);

        // test equals reflexive behavior
        assertTrue(userData01.equals(userData01));
        // test equals symmetric behavior
        assertTrue(userData01.equals(userData02));
        assertTrue(userData02.equals(userData01));
        // test equals transitive behavior
        assertTrue(userData01.equals(userData02));
        assertTrue(userData02.equals(userData04));
        assertTrue(userData02.equals(userData01));
        // test equals consistent behavior
        assertTrue(userData01.equals(userData02));
        assertTrue(userData01.equals(userData02));
        assertFalse(userData01.equals(userData03));
        assertFalse(userData01.equals(userData03));

        // test equal null behavior
        assertFalse(userData01.equals(null));
    }

}
