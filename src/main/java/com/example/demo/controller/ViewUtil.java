package com.example.demo.controller;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

public class ViewUtil {

    static public View getQrView(final BitMatrix matrix, final MatrixToImageConfig config ){
        return new AbstractView(){

            @Override
            protected void renderMergedOutputModel(Map<String, Object> model,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response) throws Exception {

                response.setContentType("image/png; charset=UTF-8");
                response.setHeader("Content-Transfer-Encoding", "binary");

                OutputStream out = response.getOutputStream();

                MatrixToImageWriter.writeToStream(matrix, "png", out, config);
                out.flush();
            }

        };
    }
}
