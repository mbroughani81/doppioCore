package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.messenger.model.PrivateChat;

import java.io.*;
import java.util.LinkedList;

public class PrivateChatDB implements DBSet<PrivateChat> {

    GsonBuilder builder;

    public PrivateChatDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public PrivateChat get(int id) {
        for (PrivateChat privateChat : all()) {
            if (privateChat.getId() == id)
                return privateChat;
        }
        return null;
    }

    @Override
    public LinkedList<PrivateChat> all() {
        LinkedList<PrivateChat> privateChats = new LinkedList<>();
        File file = new File("src/main/resources/privatechats/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/privatechats/" + s));
                privateChats.add(gson.fromJson(reader, PrivateChat.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return privateChats;
    }

    @Override
    public int add(PrivateChat privateChat) {
        int id;
        if (privateChat.getId() != -1)
            id = privateChat.getId();
        else
            id = nextId();
        privateChat.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(privateChat);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/privatechats/" + id + ".txt");
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
        File f = new File("src/main/resources/privatechats/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/privatechats/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/privatechats/" + s);
            f.delete();
        }
    }

    @Override
    public void update(PrivateChat privateChat) {
        remove(privateChat.getId());
        add(privateChat);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (PrivateChat privateChat : all()) {
                if (privateChat.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
    
}
