package com.kanner.sample.script

import com.kanner.sample.utils.CacheUtils
import java.io.InputStreamReader
import javax.script.SimpleBindings

/**
 * @author kanner
 */
fun render(url: String, model: Map<String, Any>): String {
    val templateLoader: (path: String) -> String = {path -> getTemplate(path)}
    val cache = CacheUtils.SCRIPT_CACHE
    val compiledScript = cache.getOrPut(url,  { compilableEngine().compile(getTemplate(url));  })
    val bindings = SimpleBindings(model)
    bindings.put("include", { path: String -> templateLoader("templates/$path.kts") })
    bindings.put("cache", cache)
    return compiledScript.eval(bindings) as String
}

fun getTemplate(path: String): String {
    val reader = InputStreamReader(Thread.currentThread().contextClassLoader.getResourceAsStream(path))
    return reader.readLines().joinToString("\n")
}