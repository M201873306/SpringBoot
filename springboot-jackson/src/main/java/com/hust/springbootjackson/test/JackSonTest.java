package com.hust.springbootjackson.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hust.springbootjackson.domain.Friend;
import com.hust.springbootjackson.domain.FriendDetail;
import com.hust.springbootjackson.domain.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;


public class JackSonTest {
    @Test
    public void test() {
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        String text = null;
        try {
            text = mapper.writeValueAsString(friend);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(text);
        // 从字符串中读取
        Friend newFriend = null;
        try {
            newFriend = mapper.readValue(text, Friend.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFriend);
    }
    @Test
    public void test2() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        FriendDetail fd = new FriendDetail("yitian", 25, "", 0, "");
        String text = mapper.writeValueAsString(fd);
        System.out.println(text);

        FriendDetail fd2 = mapper.readValue(text, FriendDetail.class);
        System.out.println(fd2);
    }
    @Test
    public void test3() throws Exception {
            Person p1 = new Person("yitian", "易天", 25, "10000", LocalDate.of(1994, 1, 1));
            ObjectMapper mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule());
            //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String text = mapper.writeValueAsString(p1);
            System.out.println(text);

            Person p2 = mapper.readValue(text, Person.class);
            System.out.println(p2);
    }
}
