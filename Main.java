package homeworks.javacore.zip;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static LocalDateTime time = null;

    public static void main(String[] args) {
        String text;
        GameProgress save1 = new GameProgress(86, 5, 3, 66.6);
        GameProgress save2 = new GameProgress(66, 6, 6, 33.6);
        GameProgress save3 = new GameProgress(12, 1, 8, 666.6);
        LinkedList<String> list = new LinkedList<>();
        String address = "C:" + File.separator + "Users" + File.separator + "1" + File.separator + "Desktop" + File.separator + "games";

        createDirectory(address + File.separator + "src");
        createDirectory(address + File.separator + "res");
        createDirectory(address + File.separator + "savegames");
        File saveGames = new File(address + File.separator + "savegames");
        createDirectory(address + File.separator + "temp");
        createDirectory(address + File.separator + "src" + File.separator + "main");
        createDirectory(address + File.separator + "src" + File.separator + "test");
        createDirectory(address + File.separator + "res" + File.separator + "vectors");
        createDirectory(address + File.separator + "res" + File.separator + "drawables");
        createDirectory(address + File.separator +  "res" + File.separator + "icons");
        createFile(address + File.separator + "src" + File.separator + "main" + File.separator + "Main.java");
        createFile(address + File.separator + "src" + File.separator + "main" + File.separator + "Utils.java");
        createFile(address + File.separator + "temp" + File.separator + "temp.txt");
//        File src = new File(address + File.separator + "src");
//        if (src.mkdir())
//            sb.append("Директория " + src.getName() + " создана в каталоге " + src.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File res = new File(address + File.separator + "res");
//        if (res.mkdir())
//            sb.append("Директория " + res.getName() + " создана в каталоге " + res.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File saveGames = new File(address + File.separator + "savegames");
//        if (saveGames.mkdir())
//            sb.append("Директория " + saveGames.getName() + " создана в каталоге " + saveGames.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File temp = new File(address + File.separator + "temp");
//        if (temp.mkdir())
//            sb.append("Директория " + temp.getName() + " создана в каталоге " + temp.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File main = new File(address + File.separator + "src" + File.separator + "main");
//        if (main.mkdir())
//            sb.append("Директория " + main.getName() + " создана в каталоге " + main.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File test = new File(address + File.separator + "src" + File.separator + "test");
//        if (test.mkdir())
//            sb.append("Директория " + test.getName() + " создана в каталоге " + test.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File mainJava = new File(main, "Main.java");
//        try {
//            if (mainJava.createNewFile())
//                sb.append("Файл " + mainJava.getName() + " создан в каталоге " + mainJava.getParent() + " " + time.now());
//            sb.append(System.getProperty("line.separator"));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        File utils = new File(main, "Utils.java");
//        try {
//            if (utils.createNewFile())
//                sb.append("Файл " + utils.getName() + " создан в каталоге " + utils.getParent() + " " + time.now());
//            sb.append(System.getProperty("line.separator"));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        File drawables = new File(address + File.separator + "res" + File.separator + "drawables");
//        if (drawables.mkdir())
//            sb.append("Директория " + drawables.getName() + " создана в каталоге " + drawables.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File vectors = new File(address + File.separator + "res" + File.separator + "vectors");
//        if (vectors.mkdir())
//            sb.append("Директория " + vectors.getName() + " создана в каталоге " + vectors.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File icons = new File(address + File.separator +  "res" + File.separator + "icons");
//        if (icons.mkdir())
//            sb.append("Директория " + icons.getName() + " создана в каталоге " + icons.getParent() + " " + time.now());
//        sb.append(System.getProperty("line.separator"));
//
//        File tempTxt = new File(temp, "temp.txt");
//        try {
//            if (tempTxt.createNewFile())
//                sb.append("Файл " + tempTxt.getName() + " создан в каталоге " + tempTxt.getParent() + " " + time.now());
//            sb.append(System.getProperty("line.separator"));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
        text = sb.toString();
        try (FileWriter writer = new FileWriter(address + File.separator + "temp" + File.separator + "temp.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        save1.saveGame(address + File.separator + "savegames" + File.separator + "save1.dat");
        save2.saveGame(address + File.separator + "savegames" + File.separator + "save2.dat");
        save3.saveGame(address + File.separator + "savegames" + File.separator + "save3.dat");

        list.add(address + File.separator + "savegames" + File.separator + "save1.dat");
        list.add(address + File.separator + "savegames" + File.separator + "save2.dat");
        list.add(address + File.separator + "savegames" + File.separator + "save3.dat");

        save1.zipFiles(address + File.separator + "savegames" + File.separator + "ZIP_output.zip", list);

        if (saveGames.isDirectory()) {
            for (File item : saveGames.listFiles()) {
                if (item.length() < 200) {
                    item.delete();
                }
            }
        }

        save1.openZip(address + File.separator + "savegames" + File.separator + "ZIP_output.zip", address + File.separator + "savegames");
        System.out.println(save1.openProgress(address + File.separator + "savegames" + File.separator + "packed_save1.dat"));
    }

    private static void createDirectory (String address) {
        File file = new File(address);
        if (file.mkdir())
            sb.append("Директория " + file.getName() + " создана в каталоге " + file.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));
    }

    private static void createFile (String address) {
        File file = new File(address);
        try {
            if (file.createNewFile())
                sb.append("Файл " + file.getName() + " создан в каталоге " + file.getParent() + " " + time.now());
            sb.append(System.getProperty("line.separator"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}