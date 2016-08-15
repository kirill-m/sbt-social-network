package ru.sbt.social_network.dialog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.user.Chat;
import ru.sbt.social_network.user.Message;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kirill on 15.08.16
 */
@RunWith(MockitoJUnitRunner.class)
public class DialogImplTest {
    @Mock
    Database database;
    Dialog dialog;

    @Before
    public void setUp() {
        dialog = new DialogImpl(database);
    }

    @Test
    public void testLoadHistory() {
        dialog.loadHistory(1, 2);
        verify(database).getMessagesHistory(1, 2);
    }

    @Test
    public void testSendMessage() {
        Chat chat = new Chat(12, 1, 2, new ArrayList<>());
        when(database.getChat(1, 2)).thenReturn(chat);

        Date date = new Date();
        Message message = new Message(11, 2, "Text", date);
        dialog.sendMessage(1, 2, message);
        verify(database).saveMessage(12, message);
        verify(database).getChat(1, 2);
    }

    @Test
    public void testCreateDialog() {
        dialog.createDialog(1, 2);
        verify(database).addChat(1, 2);
    }
}