package com.java.bootcamp.projects.javabean.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bootcamp.projects.javabean.UserDataImmutable;
import com.java.bootcamp.projects.javabean.UserDataMutable;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDataTest {

    @Test
    public void testMutableUserDataDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/userdata.json");
        UserDataMutable userDataMutable = mapper.readValue(is, UserDataMutable.class);
        Assert.assertNotNull(userDataMutable);
        Assert.assertTrue(userDataMutable.getId() == 1234);
        Assert.assertEquals("john", userDataMutable.getUserName());
        Assert.assertEquals("admin", userDataMutable.getRole());
    }

    @Test
    public void testImmutableUserDataDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/userdata.json");
        UserDataImmutable userDataImmutable = mapper.readValue(is, UserDataImmutable.class);
        Assert.assertNotNull(userDataImmutable);
        Assert.assertTrue(userDataImmutable.getId() == 1234);
        Assert.assertEquals("john", userDataImmutable.getUserName());
        Assert.assertEquals("admin", userDataImmutable.getRole());
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
        Assert.assertNotNull(userDataMutableFromJson);
        Assert.assertEquals(userDataMutable, userDataMutableFromJson);
    }

    @Test
    public void testEqualsAndHashCodeOfImmutable() {
        UserDataImmutable userData01 = new UserDataImmutable(123L, "Jack", "USER");
        UserDataImmutable userData02 = new UserDataImmutable(123L, "Jack", "USER");
        UserDataImmutable userData03 = new UserDataImmutable(555L, "Jack", "USER");
        UserDataImmutable userData04 = new UserDataImmutable(123L, "Jack", "USER");

        // test hashcode
        Assert.assertTrue(userData01.hashCode() == userData02.hashCode());
        Assert.assertTrue(userData01.hashCode() != userData03.hashCode());
        // test hashcode consistent behavior
        int hashcode01 = userData01.hashCode();
        int hashcode02 = userData01.hashCode();
        Assert.assertTrue(hashcode01 == hashcode02);

        // test equals reflexive behavior
        Assert.assertTrue(userData01.equals(userData01));
        // test equals symmetric behavior
        Assert.assertTrue(userData01.equals(userData02));
        Assert.assertTrue(userData02.equals(userData01));
        // test equals transitive behavior
        Assert.assertTrue(userData01.equals(userData02));
        Assert.assertTrue(userData02.equals(userData04));
        Assert.assertTrue(userData02.equals(userData01));
        // test equals consistent behavior
        Assert.assertTrue(userData01.equals(userData02));
        Assert.assertTrue(userData01.equals(userData02));
        Assert.assertFalse(userData01.equals(userData03));
        Assert.assertFalse(userData01.equals(userData03));

        // test equal null behavior
        Assert.assertFalse(userData01.equals(null));
    }

}
