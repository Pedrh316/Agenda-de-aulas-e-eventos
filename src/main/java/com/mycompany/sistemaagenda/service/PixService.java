package com.mycompany.sistemaagenda.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

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
        retorno.append(campo("60", "Cornelio Procopio"));
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
    
    public static void generateCancelTicket(String email, LocalDate date, LocalTime time, float fee)
        throws IOException{
        int opt = 0;
        JFileChooser chooser = new JFileChooser();
        File ticket;
        PDPage page = new PDPage();
        PDPageContentStream content;
        PDType1Font helveticaB = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD),
                    helvetica = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
        LocalDateTime eventTime = LocalDateTime.of(date, time),
                      cancelTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        chooser.setDialogTitle("Salvar comprovante");
        chooser.setSelectedFile(new File("cancelamento_inscricao.pdf"));
        
        opt = chooser.showSaveDialog(null);
        
        if(opt != JFileChooser.APPROVE_OPTION) return;
        
        ticket = chooser.getSelectedFile();
        
        try(PDDocument doc = new PDDocument()){
            doc.addPage(page);
            
            content = new PDPageContentStream(doc, page);
            
            content.setFont(helveticaB, 16);
            content.beginText();
            content.newLineAtOffset(150, 700);
            content.showText("COMPROVANTE DE CANCELAMENTO");
            content.endText();
            
            content.setFont(helvetica, 12);
            content.beginText();
            content.newLineAtOffset(80, 620);
            content.showText("******************************************************************");
            content.newLineAtOffset(0, -30);
            content.showText("E-mail: " + email);
            content.newLineAtOffset(0, -30);
            content.showText("Data de cancelamento: " + cancelTime.format(formatter));
            content.newLineAtOffset(0, 0);
            content.newLineAtOffset(0, -30);
            content.showText("Data do evento: " + eventTime.format(formatter));
            content.newLineAtOffset(0, -30);
            content.showText("Taxa de inscrição: " + Float.toString(fee));
            content.newLineAtOffset(0, 0);
            content.endText();
            
            content.setFont(helvetica, 12);
            content.beginText();
            content.newLineAtOffset(80, 420);
            content.showText("******************************************************************");
            content.endText();
            
            content.setFont(helvetica, 10);
            content.beginText();
            content.newLineAtOffset(80, 400);
            content.showText("Não possui valor fiscal");
            content.endText();
            
            content.close();
            doc.save(ticket);
        } catch(IOException ioe){
            throw new IOException("Erro ao gerar comprovante");
        }
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
