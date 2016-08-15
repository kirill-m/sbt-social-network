package ru.sbt.social_network.friendlist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sbt.social_network.database.Database;

import static org.mockito.Mockito.*;

/**
 * Created by kirill on 15.08.16
 */
@RunWith(MockitoJUnitRunner.class)
public class FriendListInteractionImplTest {
    @Mock
    Database database;
    FriendListInteraction fli;

    @Before
    public void setUp() {
        fli = new FriendListInteractionImpl(database);
    }

    @Test
    public void testAddFriend() {
        fli.addFriend(1, 2);
        verify(database).addFriend(1, 2);
    }

    @Test
    public void testRemoveFriend() {
        fli.removeFriend(1, 2);
        verify(database).removeFriend(1, 2);
    }

    @Test
    public void testGetFriendList() {
        fli.getFriendList(1);
        verify(database).getFriendList(1);
    }
}