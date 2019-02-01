package com.ndy.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ndy.file.abstraction.IUseFileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GsonUtil<T> implements IUseFileIO<T> {

    private final String JSON_EXTENSION = ".json";
    private File jsonPathFolder, jsonFile;
    private Gson gson;
    private T obj;
    private Class<T> clazz;

    public GsonUtil(File jsonPathFolder, String fileName, T obj, Class<T> clazz) {
        this.jsonPathFolder = jsonPathFolder;
        this.jsonFile = new File(getJsonPathFolder(), fileName + JSON_EXTENSION);
        this.obj = obj;
        this.clazz = clazz;

        initialize();
    }

    public File getJsonPathFolder() { return jsonPathFolder; }

    @Override
    public void save() {
        try{
            FileWriter writer = new FileWriter(jsonFile);
            String json = gson.toJson(obj);
            writer.write(json);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T load() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
            T obj = gson.fromJson(reader, clazz);
            reader.close();

            return obj;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void initialize() {
        if(this.gson == null)
            this.gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    }

    public boolean delete() { return jsonFile.delete(); }
    public boolean exists() {
        return jsonFile.exists();
    }
}
