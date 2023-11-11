package com.example.onboarding.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    public String saveImagePost(String name, MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();

        if (originalFileName == null) {
            originalFileName = "file.jpg";
        }

        String filename = name + originalFileName.substring(originalFileName.lastIndexOf("."));
        String imageDir = "src/main/resources/static/images/post";
        String projectPath = new File("").getAbsolutePath();

        Path path = Paths.get(projectPath, imageDir, filename);
        File newFile = path.toFile();
        FileUtils.writeByteArrayToFile(newFile, file.getBytes());

        String imageDir2 = "target/classes/static/images/post";

        Path path2 = Paths.get(projectPath, imageDir2, filename);
        File newFile2 = path2.toFile();
        FileUtils.writeByteArrayToFile(newFile2, file.getBytes());

        return "post/" + filename;
    }

    public String saveVideo(String name, MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();

        if (originalFileName == null) {
            originalFileName = "file.mp4";
        }

        String filename = name + originalFileName.substring(originalFileName.lastIndexOf("."));
        String imageDir = "src/main/resources/static/videos";
        String projectPath = new File("").getAbsolutePath();

        Path path = Paths.get(projectPath, imageDir, filename);
        File newFile = path.toFile();
        FileUtils.writeByteArrayToFile(newFile, file.getBytes());

        String imageDir2 = "target/classes/static/videos";

        Path path2 = Paths.get(projectPath, imageDir2, filename);
        File newFile2 = path2.toFile();
        FileUtils.writeByteArrayToFile(newFile2, file.getBytes());

        return "videos/" + filename;
    }
    public String savePresentation(String name, MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();

        if (originalFileName == null) {
            originalFileName = "file.pptx";
        }

        String filename = name + originalFileName.substring(originalFileName.lastIndexOf("."));
        String imageDir = "src/main/resources/static/presentation";
        String projectPath = new File("").getAbsolutePath();

        Path path = Paths.get(projectPath, imageDir, filename);
        File newFile = path.toFile();
        FileUtils.writeByteArrayToFile(newFile, file.getBytes());

        String imageDir2 = "target/classes/static/presentation";

        Path path2 = Paths.get(projectPath, imageDir2, filename);
        File newFile2 = path2.toFile();
        FileUtils.writeByteArrayToFile(newFile2, file.getBytes());

        return "presentation/" + filename;
    }

    public String saveImageProduct(String name, MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();

        if (originalFileName == null) {
            originalFileName = "file.jpg";
        }

        String filename = name + originalFileName.substring(originalFileName.lastIndexOf("."));
        String imageDir = "src/main/resources/static/images/product";
        String projectPath = new File("").getAbsolutePath();

        Path path = Paths.get(projectPath, imageDir, filename);
        File newFile = path.toFile();
        FileUtils.writeByteArrayToFile(newFile, file.getBytes());

        String imageDir2 = "target/classes/static/images/product";

        Path path2 = Paths.get(projectPath, imageDir2, filename);
        File newFile2 = path2.toFile();
        FileUtils.writeByteArrayToFile(newFile2, file.getBytes());

        return "product/" + filename;
    }
}
