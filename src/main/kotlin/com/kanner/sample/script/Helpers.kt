package com.kanner.sample.script

import com.kanner.sample.model.User
import java.util.concurrent.ConcurrentHashMap
import javax.script.Compilable
import javax.script.CompiledScript
import javax.script.ScriptEngineManager
import javax.script.SimpleBindings
import kotlin.script.templates.standard.ScriptTemplateWithBindings

/**
 * @author kanner
 */
fun ScriptTemplateWithBindings.include(path: String, model: Map<String, Any>? = null) :String {
    var cache = bindings["cache"]!! as ConcurrentHashMap<String, CompiledScript>
    var includeBindings = if (model != null) {
        val b = SimpleBindings(LinkedHashMap(model))
        b["include"] = bindings["include"]
        b["i18n"] = bindings["i18n"]
        b["cache"] = cache
        b
    } else {
        val b = SimpleBindings(bindings)
        b.remove("kotlin.script.state")
        b
    }
    val template = (bindings["include"] as (String) -> String).invoke(path)
    val compiledScript = cache.getOrPut(path, { compilableEngine().compile(template) })
    return compiledScript.eval(includeBindings) as String
}

fun ScriptTemplateWithBindings.i18n(code: String) =
        (bindings["i18n"] as (String) -> String).invoke(code)

fun <T> Iterable<T>.joinToLine(function: (foo: T) -> String): String
{ return joinToString(separator = "\n") { foo -> function.invoke(foo) } }

var ScriptTemplateWithBindings.user: User
    get() = bindings["user"] as User
    set(value) { throw UnsupportedOperationException()}

var ScriptTemplateWithBindings.title: String
    get() = bindings["title"] as String
    set(value) { throw UnsupportedOperationException()}

fun compilableEngine() = ScriptEngineManager().getEngineByExtension("kts") as Compilable