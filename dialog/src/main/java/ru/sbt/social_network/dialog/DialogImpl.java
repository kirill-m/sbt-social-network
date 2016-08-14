package ru.sbt.social_network.dialog;

import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.database.DatabaseImpl;
import ru.sbt.social_network.user.Message;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kirill on 14.08.16
 */
public class DialogImpl implements Dialog {
    private final Database db = new DatabaseImpl(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>());

    @Override
    public List<Message> loadHistory(int userOneId, int userTwoId) {
        return db.getMessagesHistory(userOneId, userTwoId);
    }

    @Override
    public void sendMessage(int userId, int recipient, Message message) {
        db.saveMessage(db.getChat(userId, recipient).getId(), message);
    }

    @Override
    public void createDialog(int userOneId, int userTwoId) {
        db.addChat(userOneId, userTwoId);
    }
}
