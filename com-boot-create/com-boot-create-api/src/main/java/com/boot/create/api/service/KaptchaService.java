package com.boot.create.api.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Producer;


@Service
public class KaptchaService {

    @Autowired    
    private Producer producer;

    public String[] genVerifyCode() {
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        return new String[]{text, toBase64String(image)};
    }

    private String toBase64String(BufferedImage image) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();
            return Base64.encodeBase64String(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
