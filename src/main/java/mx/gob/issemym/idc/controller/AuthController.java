/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.controller;

//import com.octo.captcha.service.image.ImageCaptchaService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Bryan Valdez Jara <Bryan at ibryan.valdez@gmail.com>
 */
@Controller
public class AuthController {
    
//    @Resource(name = "captchaService")
//    private ImageCaptchaService captchaService;    
    
//    @GetMapping("/login")
//    public String getLogin(){
//        return "/login";
//    }      

//    @GetMapping("/user/getcode")
//    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        
//        try {
//            String captchaId = request.getSession().getId();
//            BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, request.getLocale());    
//            ImageIO.write(challenge, "jpeg", jpegOutputStream);                        
//        } catch (Exception e) {
//            response.sendError(response.SC_NOT_FOUND);          
//        }                
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        response.setHeader("Cache-Control", "no-store");
//        response.setHeader("Pragma", "no-cache");
//        response.setDateHeader("Expires", 0);        
//        response.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream = response.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();      
//    }    
//    
}
