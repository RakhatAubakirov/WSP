package oop.examples.System;

import java.io.File;
import java.util.ArrayList;

public class MyDocuments {
    private String name;
    ArrayList<File> files;

    public MyDocuments(String name, ArrayList<File> files) {
        this.name = name;
        this.files = files;
    }

    public void addFiles(File file) {

        files.add(file);

    }

    public void deleteFiles(File file) {

        files.remove(file);
    }

    public String toString() {

        return name + " " + files;
    }

    public boolean equals(Object o) {


        if (o == this) {
            return true;
        }


        if (!(o instanceof MyDocuments)) {
            return false;
        }

        MyDocuments d = (MyDocuments) o;

        return this.name.equals(d.name);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        return result;
    }
}
