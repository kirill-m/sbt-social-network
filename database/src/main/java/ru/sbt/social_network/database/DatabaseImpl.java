package ru.sbt.social_network.database;

import ru.sbt.social_network.user.Chat;
import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.Message;
import ru.sbt.social_network.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kirill on 14.08.16
 */
public class DatabaseImpl implements Database {

    private final Map<Integer, User> users;
    private final Map<Integer, Set<User>> friendLists;
    private final Map<Integer, Chat> dialogs;
    private final Map<Integer, List<Gift>> giftLists;

    public DatabaseImpl(Map<Integer, User> users, Map<Integer, Set<User>> friendLists, Map<Integer, Chat> dialogs,
                        Map<Integer, List<Gift>> giftLists) {
        this.users = users;
        this.friendLists = friendLists;
        this.dialogs = dialogs;
        this.giftLists = giftLists;
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public Set<User> getFriendList(int id) {
        return friendLists.get(id);
    }

    @Override
    public void addFriend(int userId, int friendId) {
        Set<User> friends1 = friendLists.get(userId);
        Set<User> friends2 = friendLists.get(friendId);
        friends1.add(users.get(friendId));
        friends2.add(users.get(userId));
        friendLists.put(userId, friends1);
        friendLists.put(friendId, friends2);
    }

    @Override
    public void removeFriend(int userId, int friendId) {
        Set<User> friends1 = friendLists.get(userId);
        Set<User> friends2 = friendLists.get(friendId);
        friends1.remove(users.get(friendId));
        friends2.remove(users.get(userId));
        friendLists.put(userId, friends1);
        friendLists.put(friendId, friends2);
    }

    @Override
    public List<Message> getMessagesHistory(int userId, int friendId) {
        return new ArrayList<>();
    }

    @Override
    public void saveMessage(int chatId, Message message) {
        if (dialogs.containsKey(chatId)) {
            Chat chat = dialogs.get(chatId);
            chat.addMessage(message);
            dialogs.put(chatId, chat);
        }
    }

    @Override
    public void addGift(int recipientId, Gift gift) {
        List<Gift> giftList = giftLists.get(recipientId);
        giftList.add(gift);
    }

    @Override
    public Chat getChat(int userId1, int userId2) {
        Integer chatId = generateChatId(userId1, userId2);
        return new Chat(chatId, 1, 2, new ArrayList<>());
    }

    @Override
    public void addChat(int userId1, int userId2) {
        Integer chatId = generateChatId(userId1, userId2);
        dialogs.put(chatId, new Chat(chatId, userId1, userId2, new ArrayList<>()));
    }

    private int generateChatId(int userId1, int userId2) {
        return Integer.valueOf("" + userId1 + userId2);
    }
}
