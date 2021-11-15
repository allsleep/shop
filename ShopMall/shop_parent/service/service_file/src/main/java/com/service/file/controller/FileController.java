package com.service.file.controller;

import ch.qos.logback.core.status.Status;
import com.common.pojo.Result;
import com.common.pojo.StatusCode;
import com.service.file.util.FastDFSClient;
import com.service.file.util.FastDFSFile;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping
    public Result uploadFile(MultipartFile file) {
        try {
            //判断文件是否存在
            try {
                if (file == null) {
                    throw new RuntimeException("文件不存在");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            //获取文件的完整名称
            String originalFilename = file.getOriginalFilename();
            if(StringUtils.isEmpty(originalFilename)) {
                throw new RuntimeException("文件不存在,文件名为空");
            }
            //获取文件的扩展名称
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //获取文件内容
            byte[] content = file.getBytes();
            //创建文件上传的封装实体类
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, content, extName);
            //基于工具类进行文件上传，并接受返回参数 String[]
            String[] uploadResult = FastDFSClient.upload(fastDFSFile);
            //封装返回结果
            String url = FastDFSClient.getTrackerUrl() + uploadResult[0] + "/" + uploadResult[1];
            return new Result(true, StatusCode.OK, "upload success", url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Result(false, Status.ERROR, "upload failed");
    }

}
