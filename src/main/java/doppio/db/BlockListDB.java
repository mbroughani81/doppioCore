package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.sociallist.model.BlockList;

import java.io.*;
import java.util.LinkedList;

public class BlockListDB implements DBSet<BlockList> {

    GsonBuilder builder;

    public BlockListDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public BlockList get(int id) {
        for (BlockList blockList : all()) {
            if (blockList.getId() == id)
                return blockList;
        }
        return null;
    }

    @Override
    public LinkedList<BlockList> all() {
        LinkedList<BlockList> blockLists = new LinkedList<>();
        File file = new File("src/main/resources/blocklists/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/blocklists/" + s));
                blockLists.add(gson.fromJson(reader, BlockList.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return blockLists;
    }

    @Override
    public int add(BlockList blockList) {
        int id = nextId();
        blockList.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(blockList);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/blocklists/" + id + ".txt");
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
        File f = new File("src/main/resources/blocklists/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/blocklists/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/blocklists/" + s);
            f.delete();
        }
    }

    @Override
    public void update(BlockList blockList) {
        remove(blockList.getId());
        add(blockList);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (BlockList blockList : all()) {
                if (blockList.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
