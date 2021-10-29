package homeworks.javacore.zip;

import java.io.*;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
        private static final long serialVersionUID = 1L;

        private int health;
        private int weapons;
        private int lvl;
        private double distance;

        public GameProgress(int health, int weapons, int lvl, double distance) {
            this.health = health;
            this.weapons = weapons;
            this.lvl = lvl;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "GameProgress{" +
                    "health=" + health +
                    ", weapons=" + weapons +
                    ", lvl=" + lvl +
                    ", distance=" + distance +
                    '}';
        }

        public void saveGame (String address) {
            try (FileOutputStream fos = new FileOutputStream(address);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(this);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public void zipFiles (String address, LinkedList<String> list) {
            try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(address));
                 FileInputStream fis = new FileInputStream(list.get(0));
                 FileInputStream fis2 = new FileInputStream(list.get(1));
                FileInputStream fis3 = new FileInputStream(list.get(2))) {
                ZipEntry entry = new ZipEntry("packed_save1.dat");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                ZipEntry entry2 = new ZipEntry("packed_save2.dat");
                zout.putNextEntry(entry2);
                byte[] buffer2 = new byte[fis2.available()];
                fis2.read(buffer2);
                zout.write(buffer2);
                ZipEntry entry3 = new ZipEntry("packed_save3.dat");
                zout.putNextEntry(entry3);
                byte[] buffer3 = new byte[fis3.available()];
                fis3.read(buffer3);
                zout.write(buffer3);
                zout.closeEntry();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        public void openZip (String startAddress, String finalAddress) {
            try (ZipInputStream zin = new ZipInputStream(new FileInputStream(startAddress))) {
                ZipEntry entry;
                String name;
                while ((entry = zin.getNextEntry()) != null) {
                    name = entry.getName();
                    FileOutputStream fout = new FileOutputStream(finalAddress + "\\" + name);
                    for (int c = zin.read(); c != -1; c = zin.read()) {
                        fout.write(c);
                    }
                    fout.flush();
                    zin.closeEntry();
                    fout.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public GameProgress openProgress(String address) {
            GameProgress gameProgress = null;

            try (FileInputStream fis = new FileInputStream(address);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
                gameProgress = (GameProgress) ois.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return gameProgress;
        }
    }



