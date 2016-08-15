package ru.sbt.social_network.database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbt.social_network.user.Chat;
import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.Message;
import ru.sbt.social_network.user.User;

import java.util.*;

/**
 * Created by kirill on 15.08.16
 */
public class DatabaseImplTest {
    Map<Integer, User> users;
    Map<Integer, Set<User>> friendLists;
    Map<Integer, Chat> dialogs;
    Map<Integer, List<Gift>> giftLists;
    Database database;

    @Before
    public void setUp() {
        users = new HashMap<>();
        friendLists = new HashMap<>();
        dialogs = new HashMap<>();
        giftLists = new HashMap<>();

        users.put(1, new User(1, "Mike", "http://ava.ru?id=1", "bot"));
        users.put(2, new User(2, "Anna", "http://ava.ru?id=2", "bot"));
        users.put(3, new User(3, "John", "http://ava.ru?id=3", "person"));

        Set<User> hs1 = new HashSet<>();
        hs1.add(users.get(2));
        hs1.add(users.get(3));
        friendLists.put(1, hs1);
        Set<User> hs2 = new HashSet<>();
        hs2.add(users.get(1));
        friendLists.put(2, hs2);
        Set<User> hs3 = new HashSet<>();
        hs3.add(users.get(2));
        friendLists.put(3, hs3);

        Message message1 = new Message(1, 2, "Text1", new Date());
        Message message2 = new Message(1, 2, "Text2", new Date());
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        dialogs.put(1, new Chat(12, 1, 2, messages));

        Gift gift1 = new Gift(1, 12);
        Gift gift2 = new Gift(2, 15);
        List<Gift> gifts = new ArrayList<>();
        gifts.add(gift1);
        gifts.add(gift2);
        giftLists.put(1, gifts);

        database = new DatabaseImpl(users, friendLists, dialogs, giftLists);
    }

    @Test
    public void testGetUserById() {
        User user= database.getUserById(1);
        Assert.assertEquals(1, user.getId());
    }

    @Test
    public void testAbsenceUser() {
        Assert.assertNull(database.getUserById(4));
    }

    @Test
    public void testGetFriendList() {
        Set<User> friends = database.getFriendList(1);
        Assert.assertEquals(2, friends.size());
    }

    @Test
    public void testAddFriend() {
        database.addFriend(2, 3);
        Assert.assertEquals(2, database.getFriendList(2).size());
    }

    @Test
    public void testRemoveFriend() {
        database.removeFriend(2, 1);
        Assert.assertEquals(0, database.getFriendList(2).size());
    }

    @Test
    public void testGetChat() {
        Chat chat = database.getChat(1 ,2);
        Assert.assertEquals(12, chat.getId());
    }

    @Test
    public void testAddChat() {
        database.addChat(1, 3);
        Assert.assertEquals(13, database.getChat(1, 3).getId());
    }

}