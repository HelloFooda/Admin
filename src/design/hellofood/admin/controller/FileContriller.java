package design.hellofood.admin.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import design.hellofood.admin.util.MSUtil;
import design.hellofood.admin.util.Result;

@Controller
@RequestMapping("/file")
public class FileContriller {
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
//	@RequestParam
	public Result upload(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request){
		Result result = new Result();
		String url = "http://"+request.getServerName()+":"+request.getLocalPort();
//		重命名文件，防止不同用户文件名相同被覆盖
		String picTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String picType = file.getContentType();
		String fileName = MSUtil.md5(picTime);
		if ("image/jpeg".equals(picType)) {
			fileName = fileName.concat(".jpg");
		}else if ("image/png".equals(picType)) {
			fileName = fileName.concat(".png");
		}else if ("image/gif".equals(picType)) {
			fileName = fileName.concat(".gif");
		}else {
			fileName = fileName.concat(".jpg");
		}
//		存放图片地址
		String savePath = request.getServletContext().getRealPath("/upload");
		System.out.println("保存路径-->"+savePath);
		File saveFile = new File(savePath);
		if (!saveFile.exists() && saveFile.isDirectory()) {
			System.out.println("目录不存在，自动创建");
			saveFile.mkdirs();
		}
		File targetFile = new File(savePath,fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}try {
//			复制文件
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("上传文件失败");
		}
		
		String filePath = savePath+File.separator+fileName;
		System.out.println("拼接名字-->"+filePath);
		result.setStatus(0);
		result.setMsg("上传成功");
		result.setData(filePath);
		return result;
	}
}














