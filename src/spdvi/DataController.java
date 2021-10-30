/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author DevMike
 */
public class DataController {
    private static ArrayList<Obra> obras = new ArrayList<>();
    static boolean obrasLoaded = false;
    
    private static void loadObras() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(Constants.JSON_DATA_FILE));
            obras = gson.fromJson(reader, Constants.LIST_OF_OBRA_TYPE);
            obrasLoaded = true;
            reader.close();
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static void saveObras() {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(Constants.JSON_DATA_FILE);
            gson.toJson(obras, writer);
            writer.flush();
            writer.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static ArrayList<Obra> getObras() {
        if (!obrasLoaded) {
            loadObras();          
        }
        return obras;
    }
    
    public static void insertObra(Obra newObra, String newProfileImageFilePath) throws Exception{
        if (!obrasContains(newObra)) {
            obras.add(newObra);
            if(!Constants.NO_IMAGE.equals(newProfileImageFilePath)) {
                File newProfileImageFile = new File(Constants.IMAGES_FOLDER + newObra.getRegistre() + "." + Constants.DEFAULT_PROFILE_IMAGE_TYPE);
                if (!newProfileImageFile.exists()) {
                    try {
                        BufferedImage profileBufferedImage = ImageIO.read(new File(newProfileImageFilePath));
                        BufferedImage resizedBufferedImage = Helper.resizeImageIcon(profileBufferedImage,
                                Constants.DEFAULT_PROFILE_IMAGE_WIDTH, Constants.DEFAULT_PROFILE_IMAGE_HEIGHT );
                        ImageIO.write(resizedBufferedImage, Constants.DEFAULT_PROFILE_IMAGE_TYPE, newProfileImageFile);
                        newObra.setImatge(newProfileImageFile.getName());
                    }
                    catch(IOException ioe) {
                        newObra.setImatge(Constants.NO_IMAGE);
                        ioe.printStackTrace();
                    }

                }
            }
            else {
                newObra.setImatge(Constants.NO_IMAGE);
            }
        }
        else
            throw new Exception("Obra " + newObra.getRegistre() + " already exists in database");
    }
    
    private static boolean obrasContains(Obra obraToCheck) {
        for (Obra o: obras) {
            if (obraToCheck.getRegistre().equals(o.getRegistre())) {
                return true;
            }
        }
        return false;
    }

    static Obra getObra(String id) {
        if (!obrasLoaded) {
            loadObras();
        }
        for (Obra o: obras) {
            if (o.getRegistre().equals(id)) {
                return o;
            }
        }
        return null;
    }
    
    static void updateObra(Obra selectedObra, String titol, String any, String format, String autor, String newProfileImageFilePath) {
        selectedObra.setTitol(titol);
        selectedObra.setAny(any);
        selectedObra.setFormat(format);
        selectedObra.setAutor(autor);

        if (newProfileImageFilePath != null) {
            File newProfileImageFile = new File(Constants.IMAGES_FOLDER + selectedObra.getRegistre() + "." + Constants.DEFAULT_PROFILE_IMAGE_TYPE);
            if (!newProfileImageFile.exists()) {
                try {
                    BufferedImage profileBufferedImage = ImageIO.read(new File(newProfileImageFilePath));
                    BufferedImage resizedBufferedImage = Helper.resizeImageIcon(profileBufferedImage,
                            Constants.DEFAULT_PROFILE_IMAGE_WIDTH, Constants.DEFAULT_PROFILE_IMAGE_HEIGHT );
                    ImageIO.write(resizedBufferedImage, Constants.DEFAULT_PROFILE_IMAGE_TYPE, newProfileImageFile);
                    selectedObra.setImatge(newProfileImageFile.getName());
                }
                catch(IOException ioe) {
                    selectedObra.setImatge(Constants.NO_IMAGE);
                    ioe.printStackTrace();
                }

            }
        }
        else {
            selectedObra.setImatge(Constants.NO_IMAGE);
        }
    }

    static void deleteObra(Obra selectedObra) {
        if (!Constants.NO_IMAGE.equals(selectedObra.getImatge())) {
            File fileToDelete = new File(Constants.IMAGES_FOLDER + selectedObra.getImatge());
            if (fileToDelete.exists()) {
                fileToDelete.delete();
            }
        }
        obras.remove(selectedObra);
        saveObras();
    }
}
