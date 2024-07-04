package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        //file是一个临时文件，需要转换到指定位置，否则本次请求完成后临时文件会删除，上传的文件也就不见了
        log.info(file.toString());

        //原始文件名，我们通过原始文件名去获取上传文件后缀，注意不要使用原始文件名作为保存名，
        // 因为不同用户可能上传同名文件，会覆盖
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建一个目录对象
        File dir = new File(basePath);
        //判断目录是否存在
        if(!dir.exists()){
            dir.mkdirs();
        }
        try{
            //将临时文件转存到指定位置
            file.transferTo(new File(basePath + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        return Result.success(fileName);

    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable String name, HttpServletResponse response){

        try{
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath+name));
            //输出流，通过输出流将文件写回浏览器，在浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes))!= -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




