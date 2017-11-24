package com.kanner.sample.service;

import com.kanner.sample.script.ScriptEngineKt;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kanner
 */
@Service
public class KotlinEngineService implements TemplateEngineService {

    @Override
    public String getSuffix() {
        return ".kts";
    }

    @Override
    public String render(String templateName, Map<String, Object> model) {
        return ScriptEngineKt.render(generateTemplatePath(templateName), model);
    }

}
