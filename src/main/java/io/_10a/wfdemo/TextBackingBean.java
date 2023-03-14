package io._10a.wfdemo;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Named("textBean")
@ViewScoped
public class TextBackingBean implements Serializable {

    private final Set<String> strings = new TreeSet<>(Collections.singleton("Ala ma kota"));

    private String currentString;

    public Set<String> getStrings() {
        return strings;
    }

    public String getCurrentString() {
        return currentString;
    }

    public void setCurrentString(String currentString) {
        this.currentString = currentString;
    }

    public void addCurrentString() {
        strings.add(currentString);
        currentString = null;
    }

}
