package controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import com.example.demo.bean.file;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileUploadController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
    static String path="";
    @RequestMapping("/")
    public String UploadPage(Model model) {
        return "uploadview";
    }
    @RequestMapping("/upload")
    public String upload(Model model,@RequestParam("files") MultipartFile[] files) throws Exception {
        display display=new display();
        StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
         path=uploadDirectory+"\\"+file.getOriginalFilename();
            display.toJson(path);
        }
        model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
        return "uploadstatusview";
    }
        @RequestMapping( "/view")
        public @ResponseBody
        file greeting() throws Exception {
        display obj=new display();
        String res[]=obj.toJson(path);
        System.out.println(Arrays.deepToString(res));
        return new file(res[0],res[1],res[2],res[3],res[4],res[5]);
    }
}