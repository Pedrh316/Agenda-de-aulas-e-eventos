package com.mycompany.sistemaagenda.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import com.google.zxing.qrcode.QRCodeWriter;

public class PixService {
    public static String generatePixPayload(String chave, double valor){
        StringBuilder retorno = new StringBuilder();
        String aux = campo("00", "BR.GOV.BCB.PIX") + campo("01", chave),
               crc = "";
        
        retorno.append(campo("00", "01"));
        retorno.append(campo("26", aux));
        retorno.append(campo("52", "0000"));
        retorno.append(campo("53", "986"));
        
        if(valor > 0){
            retorno.append(campo("54", String.format(java.util.Locale.US, "%.2f", valor)));
        }
        
        retorno.append(campo("58", "BR"));
        retorno.append(campo("59", "Meninas Digitais"));
        retorno.append(campo("60", "Cornélio Procópio"));
        retorno.append(campo("62", campo("05", "***")));
        retorno.append("6304");
        
        crc = crc16(retorno.toString());
        
        retorno.append(crc);
        
        return retorno.toString();
    }
    
    public static BufferedImage generateQRCode(String payload, int height, int width) throws WriterException{
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(payload, BarcodeFormat.QR_CODE, width, height);
        
        return MatrixToImageWriter.toBufferedImage(matrix);
    }
    
    private static String campo(String id, String valor){
        return id + String.format("%02d", valor.length()) + valor;
    }
    
    private static String crc16(String payload){
        int crc = 0xFF;
        
        for(byte b : payload.getBytes(java.nio.charset.StandardCharsets.UTF_8)){
            crc ^= (b & 0xFF) << 8;
            
            for(int i = 0; i < 8; i++){
                if((crc & 0x8000) == 0x8000) crc = (crc << 1) ^ 0x1021;
                else crc = crc << 1;
                
                crc &= 0xFFFF;
            }
        }
        return String.format("%04X", crc);
    }
}
