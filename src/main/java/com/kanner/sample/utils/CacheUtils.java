package com.kanner.sample.utils;

import javax.script.CompiledScript;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author kanner
 */
public class CacheUtils {

    public static final ConcurrentMap<String, CompiledScript> SCRIPT_CACHE = new ConcurrentHashMap<>();

}
