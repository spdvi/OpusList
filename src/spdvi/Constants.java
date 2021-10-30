/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import java.util.List;

/**
 *
 * @author DevMike
 */
public class Constants {
    public static final String APP_FOLDER = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\";
    public static final String IMAGES_FOLDER = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\images\\";
    public static final String NO_IMAGE = "/spdvi/noImage.png";
    public static final java.lang.reflect.Type LIST_OF_OBRA_TYPE = new com.google.gson.reflect.TypeToken<List<Obra>>() {}.getType();
    public static final String JSON_DATA_FILE = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres.json";
    public static final int DEFAULT_PROFILE_IMAGE_WIDTH = 96;
    public static final int DEFAULT_PROFILE_IMAGE_HEIGHT = 96;
    public static final String DEFAULT_PROFILE_IMAGE_TYPE = "jpg";
}
