package com.cgvsu.texture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToText {

    public int[][][] pixelData;
    public int wight;
    public int height;

    private static final int MASK_8BIT = 0xff;
    private static final int SHIFT_RED = 16;
    private static final int SHIFT_GREEN = 8;
    private static final int SHIFT_BLUE = 0;

    public void loadImage(String path) {
        BufferedImage img;

        try {
            img = ImageIO.read(new File(path));

            int w = img.getWidth();
            int h = img.getHeight();

            pixelData = new int[w][h][3];
            wight = w;
            height = h;

            int[] rgb;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    rgb = getPixelData(img, i, j);

                    pixelData[w - 1 - i][h - 1 - j][0] = rgb[0];
                    pixelData[w - 1 - i][h - 1 - j][1] = rgb[1];
                    pixelData[w - 1 - i][h - 1 - j][2] = rgb[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] getPixelData(BufferedImage img, int x, int y) {
        int argb = img.getRGB(x, y);
        return new int[] {
                (argb >> SHIFT_RED)   & MASK_8BIT,
                (argb >> SHIFT_GREEN) & MASK_8BIT,
                (argb >> SHIFT_BLUE)  & MASK_8BIT
        };
    }
}
