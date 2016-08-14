package ru.sbt.social_network.user_profile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.user.Gift;

import static org.mockito.Mockito.*;

/**
 * Created by kirill on 14.08.16
 */
@RunWith(MockitoJUnitRunner.class)
public class UserProfileImplTest {
    @Mock
    Database database;
    UserProfile userProfile;

    @Before
    public void setUp() throws Exception {
        userProfile = new UserProfileImpl(database);
    }

    @Test
    public void testLoadUser() throws Exception {
        userProfile.loadUser(1);
        verify(database).getUserById(1);
    }

    @Test
    public void testGiveGift() throws Exception {
        Gift gift = new Gift(1, 12);
        userProfile.giveGift(1, gift);
        verify(database).addGift(1, gift);
    }
}