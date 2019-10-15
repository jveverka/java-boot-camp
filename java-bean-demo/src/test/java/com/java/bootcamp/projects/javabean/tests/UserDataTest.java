package com.java.bootcamp.projects.javabean.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        String jsonData = mapper.writeValueAsString(userDataMutable);
        UserDataMutable userDataMutableFromJson = mapper.readValue(jsonData, UserDataMutable.class);
        Assert.assertNotNull(userDataMutableFromJson);
        Assert.assertEquals(userDataMutable, userDataMutableFromJson);
    }

}
