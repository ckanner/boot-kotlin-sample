package com.kanner.sample.service;

import java.io.File;
import java.util.Map;

/**
 * @author kanner
 */
public interface TemplateEngineService {

    /**
     * 生成模板文件的全路径
     *
     * @param templateName 模板的名字，不包含后缀
     * @return 全路径
     */
    default String generateTemplatePath(String templateName) {
        final StringBuilder path = new StringBuilder("");
        path.append(getPrefix()).append(File.separatorChar).append(templateName).append(getSuffix());
        return path.toString();
    }

    default String getPrefix() {
        return "templates";
    }

    default String getSuffix() {
        return ".mustache";
    }

    String render(String templateName, Map<String, Object> model);

}
