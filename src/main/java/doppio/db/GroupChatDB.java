package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.messenger.model.GroupChat;

import java.io.*;
import java.util.LinkedList;

public class GroupChatDB implements DBSet<GroupChat> {

    GsonBuilder builder;

    public GroupChatDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public GroupChat get(int id) {
        for (GroupChat groupChat : all()) {
            if (groupChat.getId() == id)
                return groupChat;
        }
        return null;
    }

    @Override
    public LinkedList<GroupChat> all() {
        LinkedList<GroupChat> groupChats = new LinkedList<>();
        File file = new File("src/main/resources/groupchats/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/groupchats/" + s));
                groupChats.add(gson.fromJson(reader, GroupChat.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return groupChats;
    }

    @Override
    public int add(GroupChat groupChat) {
        int id;
        if (groupChat.getId() != -1)
            id = groupChat.getId();
        else
            id = nextId();
        groupChat.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(groupChat);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/groupchats/" + id + ".txt");
            fileWriter.write(json);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void remove(int id) {
        File f = new File("src/main/resources/groupchats/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/groupchats/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/groupchats/" + s);
            f.delete();
        }
    }

    @Override
    public void update(GroupChat groupChat) {
        remove(groupChat.getId());
        add(groupChat);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (GroupChat groupChat : all()) {
                if (groupChat.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }

}
