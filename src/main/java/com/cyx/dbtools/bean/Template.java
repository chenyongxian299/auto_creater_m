package com.cyx.dbtools.bean;

public class Template {
    /**
     * 工程根目录的物理路径
     */
    private String rootDirect;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 文件名（不包括后缀扩展名）
     */
    private String fileName;

    /**
     * 文件名（包括后缀扩展名）
     */
    private String fileNameExtend;

    public String getRootDirect() {
        return rootDirect;
    }

    public void setRootDirect(String rootDirect) {
        this.rootDirect = rootDirect;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameExtend() {
        return fileNameExtend;
    }

    public void setFileNameExtend(String fileNameExtend) {
        this.fileNameExtend = fileNameExtend;
    }
}
