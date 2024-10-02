package com.game.companies;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class foldersCreation {
    public static void main(String[] args) {
        File root = new File("C:\\SO");
        List<String> alphabet = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            alphabet.add(String.valueOf((char)('a' + i)));
        }

        final int depth = 3;
        mkDirs(root, alphabet, depth);
    }

    public static void mkDirs(File root, List<String> dirs, int depth) {
        if (depth == 0) return;
        for (String s : dirs) {
            File subdir = new File(root, s);
            subdir.mkdir();
            mkDirs(subdir, dirs, depth - 1);
        }
    }
}
