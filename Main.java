package homeworks.javacore.zip;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String text;
        LocalDateTime time = null;
        GameProgress save1 = new GameProgress(86, 5, 3, 66.6);
        GameProgress save2 = new GameProgress(66, 6, 6, 33.6);
        GameProgress save3 = new GameProgress(12, 1, 8, 666.6);
        LinkedList<String> list = new LinkedList<>();


        File src = new File("C:\\Users\\1\\Desktop\\games\\src");
        if (src.mkdir())
            sb.append("Директория " + src.getName() + " создана в каталоге " + src.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File res = new File("C:\\Users\\1\\Desktop\\games\\res");
        if (res.mkdir())
            sb.append("Директория " + res.getName() + " создана в каталоге " + res.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File saveGames = new File("C:\\Users\\1\\Desktop\\games\\savegames");
        if (saveGames.mkdir())
            sb.append("Директория " + saveGames.getName() + " создана в каталоге " + saveGames.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File temp = new File("C:\\Users\\1\\Desktop\\games\\temp");
        if (temp.mkdir())
            sb.append("Директория " + temp.getName() + " создана в каталоге " + temp.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File main = new File("C:\\Users\\1\\Desktop\\games\\src\\main");
        if (main.mkdir())
            sb.append("Директория " + main.getName() + " создана в каталоге " + main.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File test = new File("C:\\Users\\1\\Desktop\\games\\src\\test");
        if (test.mkdir())
            sb.append("Директория " + test.getName() + " создана в каталоге " + test.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File mainJava = new File(main, "Main.java");
        try {
            if (mainJava.createNewFile())
                sb.append("Файл " + mainJava.getName() + " создан в каталоге " + mainJava.getParent() + " " + time.now());
            sb.append(System.getProperty("line.separator"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File utils = new File(main, "Utils.java");
        try {
            if (utils.createNewFile())
                sb.append("Файл " + utils.getName() + " создан в каталоге " + utils.getParent() + " " + time.now());
            sb.append(System.getProperty("line.separator"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File drawables = new File("C:\\Users\\1\\Desktop\\games\\res\\drawables");
        if (drawables.mkdir())
            sb.append("Директория " + drawables.getName() + " создана в каталоге " + drawables.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File vectors = new File("C:\\Users\\1\\Desktop\\games\\res\\vectors");
        if (vectors.mkdir())
            sb.append("Директория " + vectors.getName() + " создана в каталоге " + vectors.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File icons = new File("C:\\Users\\1\\Desktop\\games\\res\\icons");
        if (icons.mkdir())
            sb.append("Директория " + icons.getName() + " создана в каталоге " + icons.getParent() + " " + time.now());
        sb.append(System.getProperty("line.separator"));

        File tempTxt = new File(temp, "temp.txt");
        try {
            if (tempTxt.createNewFile())
                sb.append("Файл " + tempTxt.getName() + " создан в каталоге " + tempTxt.getParent() + " " + time.now());
            sb.append(System.getProperty("line.separator"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        text = sb.toString();
        try (FileWriter writer = new FileWriter(tempTxt, true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        save1.saveGame("C:\\Users\\1\\Desktop\\games\\savegames\\save1.dat");
        save2.saveGame("C:\\Users\\1\\Desktop\\games\\savegames\\save2.dat");
        save3.saveGame("C:\\Users\\1\\Desktop\\games\\savegames\\save3.dat");

        list.add("C:\\Users\\1\\Desktop\\games\\savegames\\save1.dat");
        list.add("C:\\Users\\1\\Desktop\\games\\savegames\\save2.dat");
        list.add("C:\\Users\\1\\Desktop\\games\\savegames\\save3.dat");

        save1.zipFiles("C:\\Users\\1\\Desktop\\games\\savegames\\ZIP_output.zip", list);

        if (saveGames.isDirectory()) {
            for (File item : saveGames.listFiles()) {
                if (item.length() < 200) {
                    item.delete();
                }
            }
        }

        save1.openZip("C:\\Users\\1\\Desktop\\games\\savegames\\ZIP_output.zip", "C:\\Users\\1\\Desktop\\games\\savegames");
        System.out.println(save1.openProgress("C:\\Users\\1\\Desktop\\games\\savegames\\packed_save1.dat"));
    }
}