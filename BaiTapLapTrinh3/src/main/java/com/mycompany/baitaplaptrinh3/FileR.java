/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplaptrinh3;

/**
 *
 * @author HUY
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileR {
    
     public static byte[] readFile(java.io.File file) {
        String path = file.getPath();
        Path p = Paths.get(path);
        byte[] fileBytes = null;
        try {
            fileBytes = Files.readAllBytes(p);
        } catch (IOException e) {
        }
        return fileBytes;
    }

    public static void saveFile(String path, byte[] fileByte) {
        Path p = Paths.get(path);
        try {
            Files.write(p, fileByte);
        } catch (IOException e) {
        }
    }


    public static byte[] byteToBit2(byte[] fileByte) {
        int fileByteLength = fileByte.length;
        byte[] bitArr = new byte[fileByteLength * 8];
        int bitArrPos = 0;
        for (int i = 0; i < fileByteLength; i++) {
            byte currentByte = fileByte[i];

            for (int pos = 7; pos >= 0; pos--) {
                byte currPosBit = getBit(currentByte, pos);
                bitArr[bitArrPos] = currPosBit;
                bitArrPos++;
            }
        }

        return bitArr;
    }


    private static byte getBit(byte inputValue, int position) {
        byte shiftedByte = (byte) (inputValue >> position);
        return (byte) (shiftedByte & 1);
    }
}
